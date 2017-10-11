package me.vkandola.generator;

public class HexQuizGenerator extends QuizGenerator {

    /**
     * Generates the Hex quiz question.
     */
    @Override
    public Question generate() {
        return new Question("Why do Canadians prefer their jokes in hexadecimal?",
                "Because 7 8 9 A!");
    }
}
