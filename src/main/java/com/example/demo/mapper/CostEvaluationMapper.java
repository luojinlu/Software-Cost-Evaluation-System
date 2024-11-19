package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.CostEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CostEvaluationMapper {
    @Select("SELECT * FROM t_costevaluation WHERE ProjectID = #{projectID}")
    List<CostEvaluation> findByProjectID(@Param("projectID") int projectID);
}
