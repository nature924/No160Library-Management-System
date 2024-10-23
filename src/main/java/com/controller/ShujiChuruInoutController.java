
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujiChuruInout")
public class ShujiChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(ShujiChuruInoutController.class);

    private static final String TABLE_NAME = "shujiChuruInout";

    @Autowired
    private ShujiChuruInoutService shujiChuruInoutService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private FajinService fajinService;//罚金信息
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private PandianService pandianService;//每日盘点
    @Autowired
    private ShujiService shujiService;//书籍
    @Autowired
    private ShujiChuruInoutListService shujiChuruInoutListService;//出入库详情
    @Autowired
    private ShujiCollectionService shujiCollectionService;//书籍收藏
    @Autowired
    private ShujiCommentbackService shujiCommentbackService;//书籍评价
    @Autowired
    private ShujiYuyueService shujiYuyueService;//书籍借阅
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = shujiChuruInoutService.queryPage(params);

        //字典表数据转换
        List<ShujiChuruInoutView> list =(List<ShujiChuruInoutView>)page.getList();
        for(ShujiChuruInoutView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiChuruInoutEntity shujiChuruInout = shujiChuruInoutService.selectById(id);
        if(shujiChuruInout !=null){
            //entity转view
            ShujiChuruInoutView view = new ShujiChuruInoutView();
            BeanUtils.copyProperties( shujiChuruInout , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShujiChuruInoutEntity shujiChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujiChuruInout:{}",this.getClass().getName(),shujiChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShujiChuruInoutEntity> queryWrapper = new EntityWrapper<ShujiChuruInoutEntity>()
            .eq("shuji_churu_inout_name", shujiChuruInout.getShujiChuruInoutName())
            .eq("shuji_churu_inout_types", shujiChuruInout.getShujiChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiChuruInoutEntity shujiChuruInoutEntity = shujiChuruInoutService.selectOne(queryWrapper);
        if(shujiChuruInoutEntity==null){
            shujiChuruInout.setInsertTime(new Date());
            shujiChuruInout.setCreateTime(new Date());
            shujiChuruInoutService.insert(shujiChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujiChuruInoutEntity shujiChuruInout, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shujiChuruInout:{}",this.getClass().getName(),shujiChuruInout.toString());
        ShujiChuruInoutEntity oldShujiChuruInoutEntity = shujiChuruInoutService.selectById(shujiChuruInout.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            shujiChuruInoutService.updateById(shujiChuruInout);//根据id更新
            return R.ok();
    }


    /**
    * 出库
    */
    @RequestMapping("/outShujiChuruInoutList")
    public R outShujiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outShujiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String shujiChuruInoutName = String.valueOf(params.get("shujiChuruInoutName"));
        Wrapper<ShujiChuruInoutEntity> queryWrapper = new EntityWrapper<ShujiChuruInoutEntity>()
            .eq("shuji_churu_inout_name", shujiChuruInoutName)
            ;
        ShujiChuruInoutEntity shujiChuruInoutSelectOne = shujiChuruInoutService.selectOne(queryWrapper);
        if(shujiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");



        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<ShujiEntity> shujiList = shujiService.selectBatchIds(ids);
        if(shujiList == null || shujiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(ShujiEntity w:shujiList){
                Integer value = w.getShujiKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setShujiKucunNumber(value);
            }
        }

        //当前表
        ShujiChuruInoutEntity shujiChuruInoutEntity = new ShujiChuruInoutEntity<>();
            shujiChuruInoutEntity.setShujiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            shujiChuruInoutEntity.setShujiChuruInoutName(shujiChuruInoutName);
            shujiChuruInoutEntity.setShujiChuruInoutTypes(1);
            shujiChuruInoutEntity.setShujiChuruInoutContent("");
            shujiChuruInoutEntity.setInsertTime(new Date());
            shujiChuruInoutEntity.setCreateTime(new Date());

        boolean insertShujiChuruInout = shujiChuruInoutService.insert(shujiChuruInoutEntity);
        //list表
        ArrayList<ShujiChuruInoutListEntity> shujiChuruInoutLists = new ArrayList<>();
        if(insertShujiChuruInout){
            for(String id:ids){
                ShujiChuruInoutListEntity shujiChuruInoutListEntity = new ShujiChuruInoutListEntity();
                    shujiChuruInoutListEntity.setShujiChuruInoutId(shujiChuruInoutEntity.getId());
                    shujiChuruInoutListEntity.setShujiId(Integer.valueOf(id));
                    shujiChuruInoutListEntity.setShujiChuruInoutListNumber(map.get(id));
                    shujiChuruInoutListEntity.setInsertTime(new Date());
                    shujiChuruInoutListEntity.setCreateTime(new Date());
                shujiChuruInoutLists.add(shujiChuruInoutListEntity);
                shujiService.updateBatchById(shujiList);
            }
            shujiChuruInoutListService.insertBatch(shujiChuruInoutLists);
        }

        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inShujiChuruInoutList")
    public R inShujiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inShujiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String shujiChuruInoutName = String.valueOf(params.get("shujiChuruInoutName"));
        Wrapper<ShujiChuruInoutEntity> queryWrapper = new EntityWrapper<ShujiChuruInoutEntity>()
            .eq("shuji_churu_inout_name", shujiChuruInoutName)
            ;
        ShujiChuruInoutEntity shujiChuruInoutSelectOne = shujiChuruInoutService.selectOne(queryWrapper);
        if(shujiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<ShujiEntity> shujiList = shujiService.selectBatchIds(ids);
        if(shujiList == null || shujiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(ShujiEntity w:shujiList){
                w.setShujiKucunNumber(w.getShujiKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        ShujiChuruInoutEntity shujiChuruInoutEntity = new ShujiChuruInoutEntity<>();
            shujiChuruInoutEntity.setShujiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            shujiChuruInoutEntity.setShujiChuruInoutName(shujiChuruInoutName);
            shujiChuruInoutEntity.setShujiChuruInoutTypes(2);
            shujiChuruInoutEntity.setShujiChuruInoutContent("");
            shujiChuruInoutEntity.setInsertTime(new Date());
            shujiChuruInoutEntity.setCreateTime(new Date());


        boolean insertShujiChuruInout = shujiChuruInoutService.insert(shujiChuruInoutEntity);
        //list表
        ArrayList<ShujiChuruInoutListEntity> shujiChuruInoutLists = new ArrayList<>();
        if(insertShujiChuruInout){
            for(String id:ids){
                ShujiChuruInoutListEntity shujiChuruInoutListEntity = new ShujiChuruInoutListEntity();
                shujiChuruInoutListEntity.setShujiChuruInoutId(shujiChuruInoutEntity.getId());
                shujiChuruInoutListEntity.setShujiId(Integer.valueOf(id));
                shujiChuruInoutListEntity.setShujiChuruInoutListNumber(map.get(id));
                shujiChuruInoutListEntity.setInsertTime(new Date());
                shujiChuruInoutListEntity.setCreateTime(new Date());
                shujiChuruInoutLists.add(shujiChuruInoutListEntity);
                shujiService.updateBatchById(shujiList);
            }
            shujiChuruInoutListService.insertBatch(shujiChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShujiChuruInoutEntity> oldShujiChuruInoutList =shujiChuruInoutService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shujiChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        shujiChuruInoutListService.delete(new EntityWrapper<ShujiChuruInoutListEntity>().in("shuji_churu_inout_id",ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ShujiChuruInoutEntity> shujiChuruInoutList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShujiChuruInoutEntity shujiChuruInoutEntity = new ShujiChuruInoutEntity();
//                            shujiChuruInoutEntity.setShujiChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            shujiChuruInoutEntity.setShujiChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            shujiChuruInoutEntity.setShujiChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            shujiChuruInoutEntity.setShujiChuruInoutContent("");//详情和图片
//                            shujiChuruInoutEntity.setInsertTime(date);//时间
//                            shujiChuruInoutEntity.setCreateTime(date);//时间
                            shujiChuruInoutList.add(shujiChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("shujiChuruInoutUuidNumber")){
                                    List<String> shujiChuruInoutUuidNumber = seachFields.get("shujiChuruInoutUuidNumber");
                                    shujiChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujiChuruInoutUuidNumber = new ArrayList<>();
                                    shujiChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujiChuruInoutUuidNumber",shujiChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<ShujiChuruInoutEntity> shujiChuruInoutEntities_shujiChuruInoutUuidNumber = shujiChuruInoutService.selectList(new EntityWrapper<ShujiChuruInoutEntity>().in("shuji_churu_inout_uuid_number", seachFields.get("shujiChuruInoutUuidNumber")));
                        if(shujiChuruInoutEntities_shujiChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujiChuruInoutEntity s:shujiChuruInoutEntities_shujiChuruInoutUuidNumber){
                                repeatFields.add(s.getShujiChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujiChuruInoutService.insertBatch(shujiChuruInoutList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shujiChuruInoutService.queryPage(params);

        //字典表数据转换
        List<ShujiChuruInoutView> list =(List<ShujiChuruInoutView>)page.getList();
        for(ShujiChuruInoutView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujiChuruInoutEntity shujiChuruInout = shujiChuruInoutService.selectById(id);
            if(shujiChuruInout !=null){


                //entity转view
                ShujiChuruInoutView view = new ShujiChuruInoutView();
                BeanUtils.copyProperties( shujiChuruInout , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShujiChuruInoutEntity shujiChuruInout, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujiChuruInout:{}",this.getClass().getName(),shujiChuruInout.toString());
        Wrapper<ShujiChuruInoutEntity> queryWrapper = new EntityWrapper<ShujiChuruInoutEntity>()
            .eq("shuji_churu_inout_uuid_number", shujiChuruInout.getShujiChuruInoutUuidNumber())
            .eq("shuji_churu_inout_name", shujiChuruInout.getShujiChuruInoutName())
            .eq("shuji_churu_inout_types", shujiChuruInout.getShujiChuruInoutTypes())
//            .notIn("shuji_churu_inout_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiChuruInoutEntity shujiChuruInoutEntity = shujiChuruInoutService.selectOne(queryWrapper);
        if(shujiChuruInoutEntity==null){
            shujiChuruInout.setInsertTime(new Date());
            shujiChuruInout.setCreateTime(new Date());
        shujiChuruInoutService.insert(shujiChuruInout);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

