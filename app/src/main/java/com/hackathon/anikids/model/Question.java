package com.hackathon.anikids.model;

/**
 * Question
 *
 * @author thtuan
 * @since 12:51 PM 29-10-2016
 */
public class Question {
    private String question;
    private Answer answers1;
    private Answer answers2;
    private Answer answers3;
    private Answer answers4;
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswers1() {
        return answers1;
    }

    public void setAnswers1(Answer answers1) {
        this.answers1 = answers1;
    }

    public Answer getAnswers2() {
        return answers2;
    }

    public void setAnswers2(Answer answers2) {
        this.answers2 = answers2;
    }

    public Answer getAnswers3() {
        return answers3;
    }

    public void setAnswers3(Answer answers3) {
        this.answers3 = answers3;
    }

    public Answer getAnswers4() {
        return answers4;
    }

    public void setAnswers4(Answer answers4) {
        this.answers4 = answers4;
    }
}
