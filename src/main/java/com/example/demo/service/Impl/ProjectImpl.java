package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProjectImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public int updateProjectState(Integer id, String state) {
        return projectMapper.updateProjectState(id, state);
    }


    //展示评估完成即待生成报告中的项目列表
    @Override
    public List<Project> selectEvaluatedProjects() {
        return projectMapper.selectEvaluatedProjects();
    }
    //展示所有已经生成报告的项目的项目列表
    @Override
    public List<Project> selectReportsProjects() {
        return projectMapper.selectReportsProjects();
    }
    //展示所有待审核的项目列表
    @Override
    public List<Project> selectToBeReviewedProjects() {
        return projectMapper.selectToBeReviewedProjects();
    }
    //展示所有审核完成的项目列表
    @Override
    public List<Project> selectPassProjects() {
        return projectMapper.selectPassProjects();
    }

    @Override
    public List<Project> selectNoPassProjects() {
        return null;
    }

    @Override
    public List<Project> findPassProjectsByCondition(Project project) {
        ArrayList<Project> res = new ArrayList<>();
        List<Project> projects = selectPassProjects();
        if (Objects.isNull(project)){
            return res;
        }
        // id不为空则根据id查找
        if(project.getId() != null){
            return projectMapper.selectPassProjectsById(project.getId());
        }
        // 名字不为空则名字模糊查询
        if(!project.getProjectName().isEmpty()){
            return projectMapper.selectPassProjectsByName(project.getProjectName());
        }
        return projects;
    }

    @Override
    public List<Project> findToBeReviewedProjectsByCondition(Project project) {
        ArrayList<Project> res = new ArrayList<>();
        List<Project> projects = selectToBeReviewedProjects();
        if (Objects.isNull(project)){
            return res;
        }
        // id不为空则根据id查找
        if(project.getId() != null){
            return projectMapper.selectToBeReviewedProjectsById(project.getId());
        }
        // 名字不为空则名字模糊查询
        if(!project.getProjectName().isEmpty()){
            return projectMapper.selectToBeReviewedProjectsByName(project.getProjectName());
        }
        return projects;
    }

    @Override
    public List<Project> findEvaluatedProjectsByCondition(Project project) {
        ArrayList<Project> res = new ArrayList<>();
        List<Project> projects = selectEvaluatedProjects();
        if (Objects.isNull(project)){
            return res;
        }
        // id不为空则根据id查找
        if(project.getId() != null){
            return projectMapper.selectEvaluatedProjectsById(project.getId());
        }
        // 名字不为空则名字模糊查询
        if(!project.getProjectName().isEmpty()){
            return projectMapper.selectEvaluatedProjectsByName(project.getProjectName());
        }
        return projects;
    }

    @Override
    public List<Project> findNoPassProjectsByCondition(Project project) {
        ArrayList<Project> res = new ArrayList<>();
        List<Project> projects = selectNoPassProjects();
        if (Objects.isNull(project)){
            return res;
        }
        // id不为空则根据id查找
        if(project.getId() != null){
            return projectMapper.selectNoPasProjectsById(project.getId());
        }
        // 名字不为空则名字模糊查询
        if(!project.getProjectName().isEmpty()){
            return projectMapper.selectNoPassProjectsByName(project.getProjectName());
        }
        return projects;
    }


}
