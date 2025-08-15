import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption; // 1-based index

    Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    boolean isCorrect(int answer) {
        return answer == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a list of questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
            "Which language is used for Android development?",
            new String[]{"1. Python", "2. Java", "3. C++", "4. Ruby"},
            2
        ));
        questions.add(new Question(
            "Which company developed Java?",
            new String[]{"1. Microsoft", "2. Apple", "3. Sun Microsystems", "4. Google"},
            3
        ));
        questions.add(new Question(
            "Which keyword is used to create a subclass in Java?",
            new String[]{"1. extends", "2. inherits", "3. super", "4. sub"},
            1
        ));

        int score = 0;

        System.out.println("=== Welcome to the Quiz ===\n");

        // Loop through questions
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }
            System.out.print("Your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer was option " + q.correctOption + "\n");
            }
        }

        // Show result
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + " out of " + questions.size());

        sc.close();
    }
}
