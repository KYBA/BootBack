package com.example.demo.entity.resp;

import java.util.List;

public class ScoreAndCount {
    private double userPercent;
    private double avgPercent;
    List<QuestionVO> questionVOs;

    public double getUserPercent() {
        return userPercent;
    }

    public void setUserPercent(double userPercent) {
        this.userPercent = userPercent;
    }

    public double getAvgPercent() {
        return avgPercent;
    }

    public void setAvgPercent(double avgPercent) {
        this.avgPercent = avgPercent;
    }

    public List<QuestionVO> getQuestionVOs() {
        return questionVOs;
    }

    public void setQuestionVOs(List<QuestionVO> questionVOs) {
        this.questionVOs = questionVOs;
    }

}
