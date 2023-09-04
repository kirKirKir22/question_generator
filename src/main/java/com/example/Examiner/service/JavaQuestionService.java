package com.example.Examiner.service;

import com.example.Examiner.dto.Question;
import com.example.Examiner.service.interf.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random = new Random();


    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
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
        return questions.toArray(Question[]::new)[random.nextInt(questions.size())];

    }
}
