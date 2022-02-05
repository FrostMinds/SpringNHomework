package skypro.com.springhomework.ExaminerService.service;

import skypro.com.springhomework.ExaminerService.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
