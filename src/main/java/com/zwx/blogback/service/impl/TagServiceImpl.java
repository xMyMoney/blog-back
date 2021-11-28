package com.zwx.blogback.service.impl;

import com.zwx.blogback.model.ArticleTagMapper;
import com.zwx.blogback.model.Tag;
import com.zwx.blogback.dao.TagMapper;
import com.zwx.blogback.model.res.ResTag;
import com.zwx.blogback.service.ArticleTagMapperService;
import com.zwx.blogback.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zwx
 * @since 2021-11-03
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagMapperService articleTagMapperService;

    @Transactional
    @Override
    public boolean updateStatusById(Integer tagId) {
        tagMapper.updateById(new Tag(tagId,true));
        boolean b = articleTagMapperService.removeByTagId(tagId);
        return true;
    }

    @Transactional
    @Override
    public Boolean saveListTags(Integer newArticleId, List<Tag> tags) {

        List<Integer> oldTagIdList = articleTagMapperService.getTagListByArticleId(newArticleId);

        List<Integer> newTagIdList = new ArrayList<>();
        for (Tag tag : tags) {
            Integer tagId;
            if(null != tag.getName()) {
                this.save(tag);
                tagId = tagMapper.getLatestId();
            }else {
               tagId = tag.getId();
            }
            boolean flag = articleTagMapperService.isExist(newArticleId,tagId);
            if(!flag) {
                articleTagMapperService.save(new ArticleTagMapper(newArticleId,tagId));
            }
            newTagIdList.add(tag.getId());
        }

        for (Integer id : oldTagIdList) {
            if(!newTagIdList.contains(id)) {
                articleTagMapperService.delete(newArticleId,id);
            }
        }

        return true;
    }

    @Override
    public List<ResTag> getTagList() {
        return tagMapper.selectList();
    }


}
