package com.example.demo.entity;

public class CostEvaluation {
    private int CEID;
    private int projectID;
    private String PDRValue;
    private String effortEstimate;
    private String totalCost;
    private String assemmentDate;

    public int getCEID() {
        return CEID;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getPDRValue() {
        return PDRValue;
    }

    public String getEffortEstimate() {
        return effortEstimate;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public String getAssemmentDate() {
        return assemmentDate;
    }

    public void setCEID(int CEID) {
        this.CEID = CEID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setPDRValue(String PDRValue) {
        this.PDRValue = PDRValue;
    }

    public void setEffortEstimate(String effortEstimate) {
        this.effortEstimate = effortEstimate;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public void setAssemmentDate(String assemmentDate) {
        this.assemmentDate = assemmentDate;
    }

    public CostEvaluation() {
    }
}
