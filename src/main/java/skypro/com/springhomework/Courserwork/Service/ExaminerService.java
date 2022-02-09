package skypro.com.springhomework.Courserwork.Service;

import skypro.com.springhomework.Courserwork.Domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
