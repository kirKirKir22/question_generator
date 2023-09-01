package com.example.Examiner.service;

import com.example.Examiner.dto.Question;
import com.example.Examiner.exception.TooManyQuestionsException;
import com.example.Examiner.exception.InvalidParameterValueException;
import com.example.Examiner.service.interf.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    ExaminerServiceImpl underTest;

    private static Collection<Question> questionsTest() {
        return List.of(
                new Question("вопрос1", "ответ1"),
                new Question("вопрос2", "ответ2"),
                new Question("вопрос3", "ответ3"),
                new Question("вопрос4", "ответ3"),
                new Question("вопрос5", "ответ4")
        );
    }

    @Test
    void qetQuestions_amountMoreSize_thrownTooManyRequestException() {
        when(questionService.getAll()).thenReturn(questionsTest());
        assertThrows(TooManyQuestionsException.class, () -> underTest.getQuestions(6));
    }

    @Test
    void qetQuestions_amountLessZero_thrownInvalidParameterValueException() {
        assertThrows(InvalidParameterValueException.class, () -> underTest.getQuestions(-2));
    }

    @Test
    void qetQuestions_amountNoMoreSize_returnSetOfRandomQuestions() {
        when(questionService.getAll()).thenReturn(questionsTest());
        when(questionService.getRandomQuestion()).thenReturn(new Question("que1", "ans1"))
                .thenReturn(new Question("вопрос1", "ответ1"))
                .thenReturn(new Question("вопрос2", "ответ2"))
                .thenReturn(new Question("вопрос3", "ответ3"))
                .thenReturn(new Question("вопрос4", "ответ4"));

        Set<Question> result = (Set<Question>) underTest.getQuestions(3);
        Set<Question> expected = new HashSet<>(List.of(
                new Question("вопрос1", "ответ1"),
                new Question("вопрос2", "ответ2"),
                new Question("вопрос3", "ответ3")
        ));
        assertEquals(expected, result);
    }
}