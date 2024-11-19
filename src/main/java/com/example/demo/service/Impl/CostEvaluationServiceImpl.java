package com.example.demo.service.Impl;

import com.example.demo.entity.CostEvaluation;
import com.example.demo.mapper.CostEvaluationMapper;
import com.example.demo.service.CostEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostEvaluationServiceImpl implements CostEvaluationService {

    @Autowired
    private CostEvaluationMapper costEvaluationMapper;

    @Override
    public List<CostEvaluation> findByProjectID(int projectID) {
        return costEvaluationMapper.findByProjectID(projectID);
    }

}