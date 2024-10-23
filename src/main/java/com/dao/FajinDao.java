package com.dao;

import com.entity.FajinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FajinView;

/**
 * 罚金信息 Dao 接口
 *
 * @author 
 */
public interface FajinDao extends BaseMapper<FajinEntity> {

   List<FajinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
