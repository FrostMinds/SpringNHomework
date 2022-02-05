package skypro.com.springhomework.ExaminerService.service;

import skypro.com.springhomework.ExaminerService.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
