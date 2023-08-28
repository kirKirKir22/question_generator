package com.example.Examiner.service;

import com.example.Examiner.dto.Question;
import com.example.Examiner.exception.TooManyQuestionsException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int limit = 15;

        if (amount > limit) {
            throw new TooManyQuestionsException("Requested more questions than available.");
        }
        Collection<Question> questions = new HashSet<>();


        for (int i = 0; i < amount; i++) {
            Question randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }

        return questions;
    }
}
