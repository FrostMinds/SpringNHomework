package skypro.com.springhomework.Courserwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.com.springhomework.Courserwork.Domain.Question;
import skypro.com.springhomework.Courserwork.Exception.NotValidAmountOfQuestionsException;
import skypro.com.springhomework.Courserwork.Service.ExaminerServiceImpl;
import skypro.com.springhomework.Courserwork.Service.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static skypro.com.springhomework.Courserwork.Constants.QuestionConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceTest {
    Collection<Question> expected = new HashSet<>();

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void setUp() {
        expected.add(QUESTION_1);
        expected.add(QUESTION_2);
        expected.add(QUESTION_3);
    }

    @Test
    void shouldGetQuestionWorkCorrectWhenAmountEqualsSizeOfSet() {
        Mockito.when(javaQuestionServiceMock.getAll())
                .thenReturn(expected);
        Assertions.assertEquals(expected, out.getQuestions(3));
        Mockito.verify(javaQuestionServiceMock, Mockito.times(3)).getAll();
    }

    @Test
    void shouldGetQuestionThrowsNotValidAmountOfQuestionsExceptionWhenAmountNotValid() {
        Mockito.when(javaQuestionServiceMock.getAll())
                .thenReturn(expected);
        Assertions.assertThrows(NotValidAmountOfQuestionsException.class, () -> out.getQuestions(-1));
        Assertions.assertThrows(NotValidAmountOfQuestionsException.class, () -> out.getQuestions(4));
    }

    @Test
    void shouldGetQuestionWorkCorrectWhenAmountDoNotEqualsSizeOfSet() {
        Collection<Question> expected2 = Set.of(QUESTION_1,QUESTION_2,QUESTION_3,QUESTION_4);
        Mockito.when(javaQuestionServiceMock.getAll())
                .thenReturn(expected2);
        Mockito.when(javaQuestionServiceMock.getRandomQuestion())
                .thenReturn(QUESTION_1, QUESTION_2, QUESTION_3);
        Assertions.assertEquals(expected, out.getQuestions(3));
        Mockito.verify(javaQuestionServiceMock, Mockito.times(3)).getRandomQuestion();
    }
}