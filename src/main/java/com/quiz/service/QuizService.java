package com.quiz.service;

import com.quiz.model.Quiz;
import java.util.List;

public interface QuizService {

    void addQuiz(Quiz quiz);

    Quiz updateQuiz(Long id, Quiz quiz);

    void removeQuiz(Long id);

    Quiz getQuiz(Long id);

    List<Quiz> getQuizzes();
}
