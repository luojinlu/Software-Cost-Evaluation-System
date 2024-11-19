package com.example.demo.service;

import com.example.demo.entity.CostEvaluation;

import java.util.List;

public interface CostEvaluationService {
    List<CostEvaluation> findByProjectID(int projectID);

}
