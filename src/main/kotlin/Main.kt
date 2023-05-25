import java.util.*

// Mutterklasse
open class MutterClass(val questionText: String)

// Kindklasse 1: Multiple-Choice-Fragen
class ChildClass1(questionText: String, val options: List<String>, val correctAnswer: Int) : MutterClass(questionText)

// Kindklasse 2: Ja/Nein-Fragen
class ChildClass2(questionText: String, val correctAnswer: Boolean) : MutterClass(questionText)

class QuizGame {
    var score: Int = 0
    var correctQuestionIndex: Int = 0
    var questions: MutableList<MutterClass> = mutableListOf()

    fun addQuestion(question: MutterClass) {
        questions.add(question)
    }

    fun askQuestion() {
        val currentQuestion = questions[correctQuestionIndex]
        println(currentQuestion.questionText)

        when (currentQuestion) {
            is ChildClass1 -> askMultipleChoiceQuestion(currentQuestion)
            is ChildClass2 -> askYesNoQuestion(currentQuestion)
        }

        correctQuestionIndex++
    }

    fun askMultipleChoiceQuestion(question: ChildClass1) {
        for ((index, option) in question.options.withIndex()) {
            println("${index + 1}. $option")
        }

        val userAnswer = getUserAnswer().toInt()
        checkMultipleChoiceAnswer(userAnswer, question.correctAnswer)
    }

    fun checkMultipleChoiceAnswer(userAnswer: Int, correctAnswer: Int) {
        if (userAnswer == correctAnswer) {
            println("Richtig!")
            score++
        } else {
            println("Falsch!")
        }
    }


    fun askYesNoQuestion(question: ChildClass2) {
        println("Antworte mit Ja (J) oder Nein (N)")
        val userAnswer = getUserAnswer()
        checkYesNoAnswer(userAnswer, question.correctAnswer)
    }

    fun checkYesNoAnswer(userAnswer: String, correctAnswer: Boolean) {
        if (userAnswer.equals("J", true) || userAnswer.equals("N", true) && !correctAnswer) {
            println("Richtig!")
            score++
        } else {
            println("Falsch!")
        }
    }

    fun getUserAnswer(): String {
        var userAnswer = ""
        while (userAnswer !in listOf("1", "2", "3", "4", "J", "N")) {
            println("Wähle eine Option (1-4) oder antworte mit Ja (J) oder Nein (N): ")
            userAnswer = readLine()?.trim()?.uppercase(Locale.getDefault()) ?: ""
        }
        return userAnswer
    }

    fun displayScore() {
        println("Dein Punktestand: $score / ${questions.size}")
    }
}

fun main() {
    val quizGame = QuizGame()

    // Fragen hinzufügen
    val question1 = ChildClass1("Was ist die Hauptstadt von Frankreich?", listOf("Berlin", "Paris", "Rom", "Madrid"), 2)
    val question2 = ChildClass2("Ist die Sonne ein Stern? (Ja/Nein)", true)

    quizGame.addQuestion(question1)
    quizGame.addQuestion(question2)

    // Fragen stellen
    quizGame.askQuestion()
    quizGame.askQuestion()

    // Punktestand anzeigen
    quizGame.displayScore()
}
