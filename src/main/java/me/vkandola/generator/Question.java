package me.vkandola.generator;

public class Question {
    private String questionString;
    private String questionAnswer;

    public Question(String questionString, String questionAnswer) {
        this.questionString = questionString;
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}
