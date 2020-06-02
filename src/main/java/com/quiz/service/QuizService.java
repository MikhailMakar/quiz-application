package com.quiz.service;

import com.quiz.dto.QuizDto;
import com.quiz.model.Quiz;
import java.util.List;

public interface QuizService {

    Quiz createQuiz(QuizDto quizDto);

    void deleteQuiz(long id);

    Quiz getQuiz(long id);

    List<Quiz> getQuizzes();
}
