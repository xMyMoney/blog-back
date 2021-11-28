package com.zwx.blogback.controller.system;

import com.zwx.blogback.model.Tag;
import com.zwx.blogback.model.common.PageBean;
import com.zwx.blogback.model.common.RespBean;
import com.zwx.blogback.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/tag")
public class SysTagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public RespBean getList() {
        return RespBean.ok("查找成功",new PageBean<>(tagService.getTagList()));
    }

    @GetMapping
    public RespBean getName(Integer tagId) {
        return RespBean.ok("查找成功",tagService.getById(tagId).getName());
    }

    @PostMapping
    public RespBean addTag(String tagName) {
        return tagService.save(new Tag(tagName)) ? RespBean.ok("添加成功") : RespBean.error("添加失败");
    }

    @PutMapping
    public RespBean updateTag(Tag tag) {
        return tagService.updateById(tag) ? RespBean.ok("修改成功") : RespBean.error("修改失败");
    }

    @DeleteMapping
    public RespBean deleteTag(Integer tagId) {
        return tagService.updateStatusById(tagId) ? RespBean.ok("删除成功") : RespBean.error("删除失败");
    }
}
