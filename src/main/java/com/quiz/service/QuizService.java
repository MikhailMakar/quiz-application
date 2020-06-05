package com.quiz.service;

import com.quiz.model.Quiz;
import java.util.List;

public interface QuizService {

    Quiz createQuiz(Quiz quiz);

    void deleteById(long id);

    Quiz getQuizById(long id);

    List<Quiz> getQuizzes();
}
