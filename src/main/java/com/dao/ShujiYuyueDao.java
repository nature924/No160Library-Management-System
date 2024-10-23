package com.dao;

import com.entity.ShujiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiYuyueView;

/**
 * 书籍借阅 Dao 接口
 *
 * @author 
 */
public interface ShujiYuyueDao extends BaseMapper<ShujiYuyueEntity> {

   List<ShujiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
