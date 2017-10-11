package me.vkandola.generator;

public class BinaryQuizGenerator extends QuizGenerator {

    /**
     * Generates the Binary quiz question.
     */
    @Override
    public Question generate() {
        return new Question("Why is there only 10 types of people in the world?",
                "Because some people understand binary, and some don't!");
    }
}
