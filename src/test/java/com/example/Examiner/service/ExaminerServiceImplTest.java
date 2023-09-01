package com.example.Examiner.service;

import com.example.Examiner.dto.Question;


import com.example.Examiner.service.interf.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    Question question1 = new Question("Question 1", "Answer 1");
    Question question2 = new Question("Question 2", "Answer 2");


    @Test
    void getQuestions() {
        int amount = 1;
        when(questionService.getAll()).thenReturn(List.of(question1, question2));
        Collection<Question> result = underTest.getQuestions(amount);
        assertEquals(amount, result.size());

    }

}