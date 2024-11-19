package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Report;
import com.example.demo.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    /**
     * 获取所有报告
     */
    @GetMapping("/list")
    public Result getAllReports() {
        List<Report> reports = reportService.list();
        return Result.suc(reports, (long) reports.size());
    }

    /**
     * 根据ID获取报告
     */
    @GetMapping("/{id}")
    public Result getReportById(@PathVariable Integer id) {
        Report report = reportService.getById(id);
        return report != null ? Result.suc(report) : Result.fail("未找到对应的报告");
    }

    /**
     * 添加新报告
     */
    @PostMapping
    public Result createReport(@RequestBody Report report) {
        boolean success = reportService.save(report);
        return success ? Result.suc() : Result.fail("添加报告失败");
    }

    /**
     * 更新报告
     */
    @PutMapping
    public Result updateReport(@RequestBody Report report) {
        boolean success = reportService.updateById(report);
        return success ? Result.suc() : Result.fail("更新报告失败");
    }

    /**
     * 删除报告
     */
    @DeleteMapping("/{id}")
    public Result deleteReport(@PathVariable Integer id) {
        boolean success = reportService.removeById(id);
        return success ? Result.suc() : Result.fail("删除报告失败");
    }
}
