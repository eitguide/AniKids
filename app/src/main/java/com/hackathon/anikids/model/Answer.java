package com.hackathon.anikids.model;

/**
 * Answer
 *
 * @author thtuan
 * @since 12:53 PM 29-10-2016
 */
public class Answer {
    private String answer;
    private boolean isTrue = false;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
