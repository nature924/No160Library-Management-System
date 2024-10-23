package com.dao;

import com.entity.ShujiChuruInoutListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiChuruInoutListView;

/**
 * 出入库详情 Dao 接口
 *
 * @author 
 */
public interface ShujiChuruInoutListDao extends BaseMapper<ShujiChuruInoutListEntity> {

   List<ShujiChuruInoutListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
