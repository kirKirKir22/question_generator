package com.example.Examiner.service;

import com.example.Examiner.dto.Question;
import com.example.Examiner.exception.TooManyQuestionsException;
import com.example.Examiner.service.interf.ExaminerService;
import com.example.Examiner.service.interf.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new TooManyQuestionsException("Запрошенное количество вопросов превышает количество доступных вопросов.");
        }
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }


        return questions;
    }
}
