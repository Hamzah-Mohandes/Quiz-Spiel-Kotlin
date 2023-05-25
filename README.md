# Quiz-Spiel-Kotlin
# Quiz Game

This is a simple Quiz Game application where users can answer questions. The application is implemented in Kotlin and allows users to play a quiz by providing multiple-choice questions and yes/no questions. The user's score is displayed at the end of the quiz.

## Usage

1. Clone the repository:

2. Navigate to the project directory:


3. Run the application:


4. Follow the prompts to answer the quiz questions.

## Adding Questions

To add new questions to the quiz, you can modify the `main()` function in the `QuizGame` class. Create instances of the `ChildClass1` or `ChildClass2` classes with the desired question text and correct answer, and add them using the `addQuestion()` method.

```kotlin
val quizGame = QuizGame()

// Multiple-choice question
val question1 = ChildClass1("What is the capital of France?", listOf("Berlin", "Paris", "Rome", "Madrid"), 2)
quizGame.addQuestion(question1)

// Yes/No question
val question2 = ChildClass2("Is the sun a star? (Yes/No)", true)
quizGame.addQuestion(question2)

Feel free to modify and adapt this README template to fit your specific project.


