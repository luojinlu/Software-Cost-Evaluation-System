package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/updateState")
    public Map<String, Object> updateProjectState(@RequestParam Integer id, @RequestParam String state) {
        int result = projectService.updateProjectState(id, state);
        Map<String, Object> map = new HashMap<>();

        // 调用ProjectService的updateProjectStatus方法尝试改变项目状态，并根据结果放入不同的数据
        if (result > 0) {
            map.put("isOk", true);
            map.put("msg", "项目状态更新成功");
        } else {
            map.put("isOk", false);
            map.put("msg", "项目状态更新失败");
        }

        // 返回Map
        return map;
    }

    //展示评估完成即待生成报告中的项目列表
    @GetMapping("/findEvaluatedAll")
    public Map findEvaluatedAll(){
        List<Project> list = projectService.selectEvaluatedProjects();
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无评估完成待生成报告中的项目");
        }

        return result;
    }
    //展示所有已经生成报告的项目的项目列表
    @GetMapping("/findReportsAll")
    public Map findReportsAll(){
        List<Project> list = projectService.selectReportsProjects();
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无已经生成报告的项目");
        }

        return result;
    }
    //展示所有待审核项目列表
    @GetMapping("/findToBeReviewedProjects")
    public Map findToBeReviewedProjects(){
        List<Project> list = projectService.selectToBeReviewedProjects();
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无待审核项目");
        }

        return result;
    }
    //展示所有审核通过的项目列表
    @GetMapping("/findPassProjects")
    public Map findPassProjects(){
        List<Project> list = projectService.selectPassProjects();
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无审核通过项目");
        }

        return result;
    }

    //展示所有审核通过的项目列表,并对其编号和名称模糊查询
    @PostMapping("/findToBeReviewedByCondition")
    public Map findToBeReviewedByCondition(@RequestBody Project project){
        List<Project> list = projectService.findToBeReviewedProjectsByCondition(project);
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无待审核项目");
        }
        return result;
    }

    //展示所有待审核的项目列表,并对其编号和名称模糊查询
    @PostMapping("/findPassProjectsByCondition")
    public Map findPassProjectsByCondition(@RequestBody Project project){
        List<Project> list = projectService.findPassProjectsByCondition(project);
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无审核通过项目");
        }
        return result;
    }

    //展示所有已完成评估的项目列表,并对其编号和名称模糊查询
    @PostMapping("/findEvaluatedProjectsByCondition")
    public Map findEvaluatedProjectsByCondition(@RequestBody Project project){
        List<Project> list = projectService.findEvaluatedProjectsByCondition(project);
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无已完成评估项目");
        }
        return result;
    }

    //展示所有未通过的项目列表,并对其编号和名称模糊查询
    @PostMapping("/findNoPassProjectsByCondition")
    public Map findNoPassProjectsByCondition(@RequestBody Project project){
        List<Project> list = projectService.findNoPassProjectsByCondition(project);
        Map result = new HashMap<>();
        if(list!=null){
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("projects",list);
        }else{
            result.put("isOk",false);
            result.put("msg","无未通过项目");
        }
        return result;
    }


}
