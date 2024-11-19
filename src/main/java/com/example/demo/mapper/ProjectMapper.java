package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    //更新项目状态
    @Update("UPDATE t_project SET state = #{state} WHERE id = #{id}")
    int updateProjectState(@Param("id") Integer id, @Param("state") String state);

    //展示评估完成即待生成报告中的项目列表
    @Select("select * from t_project where state = '评估完成'")
    public List<Project> selectEvaluatedProjects();

    //展示所有已经生成报告的项目的项目列表
    @Select("select * from t_project where state IN ('待审核', '审核通过', '审核未通过')")
    public List<Project> selectReportsProjects();
    //展示所有待评审的项目列表
    @Select("select * from t_project where state = '待审核'")
    public List<Project> selectToBeReviewedProjects();
    //展示所有评审通过的项目列表
    @Select("select * from t_project where state = '审核通过'")
    public List<Project> selectPassProjects();

    //
    //根据项目名称进行模糊查找评审通过的项目列表
    @Select("select * from t_project where project_name like '%${projectName}%' and state = '审核通过'")
    public List<Project> selectPassProjectsByName(String projectName);
    //根据项目ID进行模糊查找评审通过的项目列表
    @Select("select * from t_project where id = #{id} and state = '审核通过'")
    public List<Project> selectPassProjectsById(Integer id);
    //根据项目名称进行模糊查找待审核的项目列表
    @Select("select * from t_project where project_name like '%${projectName}%' and state = '待审核'")
    public List<Project> selectToBeReviewedProjectsByName(String projectName);
    //根据项目ID进行模糊查找待审核的项目列表
    @Select("select * from t_project where id = #{id} and state = '待审核'")
    public List<Project> selectToBeReviewedProjectsById(Integer id);
    //根据项目名称进行模糊完成评估的项目列表
    @Select("select * from t_project where project_name like '%${projectName}%' and state = '评估完成'")
    public List<Project> selectEvaluatedProjectsByName(String projectName);
    //根据项目ID进行模糊查找完成评估的项目列表
    @Select("select * from t_project where id = #{id} and state = '评估完成'")
    public List<Project> selectEvaluatedProjectsById(Integer id);
    //根据项目名称进行模糊完成评估的项目列表
    @Select("select * from t_project where project_name like '%${projectName}%' and state = '审核未通过'")
    public List<Project> selectNoPassProjectsByName(String projectName);
    //根据项目ID进行模糊查找完成评估的项目列表
    @Select("select * from t_project where id = #{id} and state = '审核未通过'")
    public List<Project> selectNoPasProjectsById(Integer id);



}
