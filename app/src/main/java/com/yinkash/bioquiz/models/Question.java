package com.yinkash.bioquiz.models;

public class Question {

    private Integer id;
    private String questionString;
    private boolean answer;

    public Question(Integer id, String questionString, boolean answer) {
        this.id = id;
        this.questionString = questionString;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

}
