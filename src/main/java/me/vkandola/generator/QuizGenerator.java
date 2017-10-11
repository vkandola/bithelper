package me.vkandola.generator;

/**
 * The abstract interface of the quiz generators.
 */
public abstract class QuizGenerator {
    private static int QUESTION_ANSWER_DELAY_SECONDS = 5000;

    /**
     * Generate the question.
     */
    public abstract Question generate();

    public void askQuestion(Question question) {
        System.out.printf("Question:\n%s\n", question.getQuestionString());
        try {
            Thread.sleep(QUESTION_ANSWER_DELAY_SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.printf("\nAnswer:\n%s\n", question.getQuestionAnswer());
    }
}
