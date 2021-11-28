package com.zwx.blogback.dao;

import com.zwx.blogback.model.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {

    Integer countByStatusInteger(Integer status);

    List<Comments> getParentList(Integer articleId);

    List<Comments> getChildrenList(@Param("articleId") String articleId,@Param("parentId") Integer parentId);
}
