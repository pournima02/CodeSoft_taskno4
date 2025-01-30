package task4;

import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class Quiz_Application {
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static boolean answered = false;

    public static void main(String[] args) {
        loadQuestions();
        startQuiz();
        displayResults();
    }

    private static void loadQuestions() {
        questions.add(new Question("Who is the current Prime Minister of india?", new String[]{"1. Rahul Gandhi", "2. Narendra Modi", "3. Arvind Kejriwal", "4. Amit Shah"}, 2));
        questions.add(new Question("Which indian state was recently renamed from Orissa to?", new String[]{"1. Odisha", "2. Bihar", "3. Jharkand", "4. West Bengal"}, 1));
        questions.add(new Question("What is the name of India's first indigenous aircraft carrier?", new String[]{"1. INS Vikrant", "2. INS Viraat", "3. INS Vikramaditya", "4. INS Arihant"}, 1));
        questions.add(new Question("Which Indian city hosted the 2022 G20 Summit??", new String[]{"1. Mumbai", "2. New Delhi", "3. Bengaluru", "4. Hyderabad"}, 2));
        questions.add(new Question("Who is the current Chief Justice of India??", new String[]{"1. Dhananjaya Y. Chandrachud", "2. Uday Umesh Lalit", "3. S. A. Bobde", "4. Ranjan Gogoi"}, 1));
        questions.add(new Question("What is the name of India's lunar mission that successfully landed on the Moon's south pole?", new String[]{"1.  Chandrayaan-3", "2.  Chandrayaan-2", "3. Mangalyaan", "4. Aditya-L1"}, 1));
        questions.add(new Question("Who is the founder of Paytm?", new String[]{"1. Kunal Bahl", "2. Sachin Bansal", "3. Binny Bansal", "4. Vijay Shekhar Sharma"}, 4));
        questions.add(new Question("Which Indian state has been at the forefront of the recent farmers' protests?", new String[]{"1. Haryana", "2. Punjab", "3. Uttar Pradesh", "4. Madhya Pradesh"}, 1));
        questions.add(new Question("What is the name of India's first semi-high-speed train??", new String[]{"1. Vande Bharat Express", "2. Rajdhani Express", "3. Shatabdi Express", "4. Duronto Express"}, 1));
        questions.add(new Question("Who is the current Governor of the Reserve Bank of India?", new String[]{"1. Raghuram Rajan", "2.  Urjit Patel", "3. Shaktikanta Das", "4. Duvvuri Subbarao"}, 3));
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz! You have 10 seconds per question.");
        System.out.println("------------------------------------------------------");

        for (Question q : questions) {
            askQuestion(q);
        }
    }

    private static void askQuestion(Question q) {
        answered = false;
        System.out.println("\n" + q.questionText);
        for (String option : q.options) {
            System.out.println(option);
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("\nTime's up! Moving to the next question...");
                    answered = true;
                }
            }
        }, 10000); // 10 seconds per question

        System.out.print("Your answer: ");
        int answer = getUserInput();
        timer.cancel(); // Stop the timer if user answers

        if (answered) {
            return;
        }

        answered = true;
        if (answer == q.correctAnswer) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Wrong! The correct answer was " + q.correctAnswer + ".\n");
        }
    }

    private static int getUserInput() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.print("Invalid choice. Enter a number between 1 and 4: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number between 1 and 4: ");
            }
        }
    }

    private static void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score: " + score + "/" + questions.size());
        System.out.println("Thanks for playing!");
    }
}
