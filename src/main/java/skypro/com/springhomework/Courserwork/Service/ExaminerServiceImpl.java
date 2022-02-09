package skypro.com.springhomework.Courserwork.Service;

import org.springframework.stereotype.Service;
import skypro.com.springhomework.Courserwork.Exception.NotValidAmountOfQuestionsException;
import skypro.com.springhomework.Courserwork.Domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount < 1 || amount > questionService.getAll().size()) {
            throw new NotValidAmountOfQuestionsException("The amount of questions is not valid");
        }
        if (amount == questionService.getAll().size()) {
            return questionService.getAll();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
