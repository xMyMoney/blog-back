package com.zwx.blogback.service;

import com.zwx.blogback.model.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zwx.blogback.model.res.ResTag;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
public interface TagService extends IService<Tag> {

    boolean updateStatusById(Integer tagId);

    Boolean saveListTags(Integer newArticleId,List<Tag> tags);

    List<ResTag> getTagList();
}
