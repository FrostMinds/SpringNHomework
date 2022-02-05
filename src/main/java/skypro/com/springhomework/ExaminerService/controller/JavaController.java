package skypro.com.springhomework.ExaminerService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.springhomework.ExaminerService.domain.Question;
import skypro.com.springhomework.ExaminerService.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping
public class JavaController {
    QuestionService service;

    JavaController(QuestionService service) {

    }

    Question addQuestion(String question, String answer) {

    }

    Collection<Question> getQuestions() {

    }

    Question removeQuestion(String question, String answer) {

    }
}
