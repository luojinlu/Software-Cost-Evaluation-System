package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Project;

import java.util.List;

public interface ProjectService extends IService<Project> {
    int updateProjectState(Integer id, String state);

    List<Project> selectEvaluatedProjects();//展示评估完成即待生成报告中的项目列表
    List<Project> selectReportsProjects();//展示所有已经生成报告的项目的项目列表
    List<Project> selectToBeReviewedProjects();//展示所有待审核的项目列表
    List<Project> selectPassProjects();//展示所有审核通过的项目列表

    List<Project> selectNoPassProjects();//展示所有审核未通过的项目列表

    List<Project> findPassProjectsByCondition(Project project);//展示所有审核通过的项目列表,并对其编号和名称模糊查询

    List<Project> findToBeReviewedProjectsByCondition(Project project);//展示所有待审核的项目列表,并对其编号和名称模糊查询

    List<Project> findEvaluatedProjectsByCondition(Project project);//展示所有已完成评估的项目列表,并对其编号和名称模糊查询

    List<Project> findNoPassProjectsByCondition(Project project);//展示所有未通过的项目列表,并对其编号和名称模糊查询
}
