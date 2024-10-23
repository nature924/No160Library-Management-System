package com.dao;

import com.entity.ShujiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiCommentbackView;

/**
 * 书籍评价 Dao 接口
 *
 * @author 
 */
public interface ShujiCommentbackDao extends BaseMapper<ShujiCommentbackEntity> {

   List<ShujiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
