package com.fsl.springbootshiro.controller;


import com.fsl.springbootshiro.business.entity.Resources;
import com.fsl.springbootshiro.business.enums.ResponseStatus;
import com.fsl.springbootshiro.business.service.ShiroService;
import com.fsl.springbootshiro.business.service.SysResourcesService;
import com.fsl.springbootshiro.business.vo.ResourceConditionVO;
import com.fsl.springbootshiro.framework.object.PageResult;
import com.fsl.springbootshiro.framework.object.ResponseVO;
import com.fsl.springbootshiro.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统资源管理
 *
 * @author yudd
 * @date 2019年5月16日14:19:01
 */
@RestController
@RequestMapping("/resources")
public class RestResourcesController {

    @Autowired
    private SysResourcesService resourcesService;
    @Autowired
    private ShiroService shiroService;

    @RequiresPermissions("resources")
    @PostMapping("/list")
    public PageResult getAll(ResourceConditionVO vo) {
        PageInfo<Resources> pageInfo = resourcesService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @RequiresPermissions("role:allotResource")
    @PostMapping("/resourcesWithSelected")
    public ResponseVO resourcesWithSelected(Long rid) {
        return ResultUtil.success(null, resourcesService.queryResourcesListWithSelected(rid));
    }

    @RequiresPermissions("resource:add")
    @PostMapping(value = "/add")
    public ResponseVO add(Resources resources) {
        resourcesService.insert(resources);
        //更新权限
        shiroService.updatePermission();
        return ResultUtil.success("成功");
    }

    @RequiresPermissions(value = {"resource:batchDelete", "resource:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            resourcesService.removeByPrimaryKey(id);
        }

        //更新权限
        shiroService.updatePermission();
        return ResultUtil.success("成功删除 [" + ids.length + "] 个资源");
    }

    @RequiresPermissions("resource:edit")
    @PostMapping("/get/{id}")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.resourcesService.getByPrimaryKey(id));
    }

    @RequiresPermissions("resource:edit")
    @PostMapping("/edit")
    public ResponseVO edit(Resources resources) {
        try {
            resourcesService.updateSelective(resources);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("资源修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }
}
