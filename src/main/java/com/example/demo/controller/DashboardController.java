package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Dashboard;
import com.example.demo.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Resource
    private DashboardService dashboardService;

    /**
     * 获取所有数据
     */
    @GetMapping("/list")
    public Result getAllDashboards() {
        List<Dashboard> list = dashboardService.list();
        return Result.suc(list, (long) list.size());
    }

    /**
     * 根据ID获取数据
     */
    @GetMapping("/{id}")
    public Result getDashboardById(@PathVariable Integer id) {
        Dashboard dashboard = dashboardService.getById(id);
        if (dashboard != null) {
            return Result.suc(dashboard);
        } else {
            return Result.fail("未找到对应的数据");
        }
    }

    /**
     * 添加新数据
     */
    @PostMapping
    public Result createDashboard(@RequestBody Dashboard dashboard) {
        boolean success = dashboardService.save(dashboard);
        return success ? Result.suc() : Result.fail("添加失败");
    }

    /**
     * 更新数据
     */
    @PostMapping("/update")
    public Result updateDashboard(@RequestBody Dashboard dashboard) {
        boolean success = dashboardService.updateById(dashboard);
        return success ? Result.suc() : Result.fail("更新失败");
    }

    /**
     * 删除数据
     */
    @GetMapping("/del/{id}")
    public Result deleteDashboard(@PathVariable Integer id) {
        boolean success = dashboardService.removeById(id);
        return success ? Result.suc() : Result.fail("删除失败");
    }
}
