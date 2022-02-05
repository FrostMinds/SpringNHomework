package skypro.com.springhomework.ExaminerService.service;

import org.springframework.stereotype.Service;
import skypro.com.springhomework.ExaminerService.domain.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;
    QuestionService questionService;

    Examiner ServiceImpl(QuestionService questionService) {

    }

    Collection<Question> getQuestions(int amount) {

    }
}
