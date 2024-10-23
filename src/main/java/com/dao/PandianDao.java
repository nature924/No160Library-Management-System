package com.dao;

import com.entity.PandianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PandianView;

/**
 * 每日盘点 Dao 接口
 *
 * @author 
 */
public interface PandianDao extends BaseMapper<PandianEntity> {

   List<PandianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
