package com.example.demo.controller;

import com.example.demo.entity.CostEvaluation;
import com.example.demo.service.CostEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cost-evaluations")
public class CostEvaluationController {

    @Autowired
    private CostEvaluationService costEvaluationService;

    @GetMapping("/by-project-id/{projectID}")
    public List<CostEvaluation> getByProjectID(@PathVariable int projectID) {
        return costEvaluationService.findByProjectID(projectID);
    }

}