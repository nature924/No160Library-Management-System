
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
 * 每日盘点
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pandian")
public class PandianController {
    private static final Logger logger = LoggerFactory.getLogger(PandianController.class);

    private static final String TABLE_NAME = "pandian";

    @Autowired
    private PandianService pandianService;


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
    private ShujiService shujiService;//书籍
    @Autowired
    private ShujiChuruInoutService shujiChuruInoutService;//出入库
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
        PageUtils page = pandianService.queryPage(params);

        //字典表数据转换
        List<PandianView> list =(List<PandianView>)page.getList();
        for(PandianView c:list){
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
        PandianEntity pandian = pandianService.selectById(id);
        if(pandian !=null){
            //entity转view
            PandianView view = new PandianView();
            BeanUtils.copyProperties( pandian , view );//把实体数据重构到view中
            //级联表 书籍
            //级联表
            ShujiEntity shuji = shujiService.selectById(pandian.getShujiId());
            if(shuji != null){
            BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShujiId(shuji.getId());
            }
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
    public R save(@RequestBody PandianEntity pandian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pandian:{}",this.getClass().getName(),pandian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        pandian.setInsertTime(new Date());
        Wrapper<PandianEntity> queryWrapper = new EntityWrapper<PandianEntity>()
            .eq("shuji_id", pandian.getShujiId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(pandian.getInsertTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PandianEntity pandianEntity = pandianService.selectOne(queryWrapper);
        if(pandianEntity==null){
            ShujiEntity shujiEntity = shujiService.selectById(pandian.getShujiId());
            shujiEntity.setShujiKucunNumber(pandian.getPandianNum());
            shujiService.updateById(shujiEntity);
            pandian.setCreateTime(new Date());
            pandianService.insert(pandian);
            return R.ok();
        }else {
            return R.error(511,"请不要重复添加");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PandianEntity pandian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,pandian:{}",this.getClass().getName(),pandian.toString());
        PandianEntity oldPandianEntity = pandianService.selectById(pandian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            pandianService.updateById(pandian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PandianEntity> oldPandianList =pandianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        pandianService.deleteBatchIds(Arrays.asList(ids));

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
            List<PandianEntity> pandianList = new ArrayList<>();//上传的东西
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
                            PandianEntity pandianEntity = new PandianEntity();
//                            pandianEntity.setShujiId(Integer.valueOf(data.get(0)));   //书籍 要改的
//                            pandianEntity.setPandianNum(Integer.valueOf(data.get(0)));   //盘点数量 要改的
//                            pandianEntity.setPandianContent("");//详情和图片
//                            pandianEntity.setInsertTime(date);//时间
//                            pandianEntity.setCreateTime(date);//时间
                            pandianList.add(pandianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        pandianService.insertBatch(pandianList);
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
        PageUtils page = pandianService.queryPage(params);

        //字典表数据转换
        List<PandianView> list =(List<PandianView>)page.getList();
        for(PandianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PandianEntity pandian = pandianService.selectById(id);
            if(pandian !=null){


                //entity转view
                PandianView view = new PandianView();
                BeanUtils.copyProperties( pandian , view );//把实体数据重构到view中

                //级联表
                    ShujiEntity shuji = shujiService.selectById(pandian.getShujiId());
                if(shuji != null){
                    BeanUtils.copyProperties( shuji , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujiId(shuji.getId());
                }
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
    public R add(@RequestBody PandianEntity pandian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,pandian:{}",this.getClass().getName(),pandian.toString());
        Wrapper<PandianEntity> queryWrapper = new EntityWrapper<PandianEntity>()
            .eq("shuji_id", pandian.getShujiId())
            .eq("pandian_num", pandian.getPandianNum())
//            .notIn("pandian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PandianEntity pandianEntity = pandianService.selectOne(queryWrapper);
        if(pandianEntity==null){
            pandian.setInsertTime(new Date());
            pandian.setCreateTime(new Date());
        pandianService.insert(pandian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

