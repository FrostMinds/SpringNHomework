package skypro.com.springhomework.Courserwork.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import skypro.com.springhomework.Courserwork.Domain.Question;
import skypro.com.springhomework.Courserwork.Service.ExaminerService;

import java.util.Collection;
import java.util.Set;


@RestController
@RequestMapping("/exam")
public class ExamineController {
    private final ExaminerService examinerService;

    public ExamineController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return Set.copyOf(examinerService.getQuestions(amount));
    }
}