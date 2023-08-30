package com.example.Examiner.service;

import com.example.Examiner.dto.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;

    private Random random = new Random();

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;

    }


    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new RuntimeException("список вопросов пуст");
        }
        return questions.stream().toArray(Question[]::new)[random.nextInt(questions.size())];
    }
}
