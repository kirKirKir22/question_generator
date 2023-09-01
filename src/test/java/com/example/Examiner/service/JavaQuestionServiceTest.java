package com.example.Examiner.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Examiner.dto.Question;
import com.example.Examiner.service.interf.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


class JavaQuestionServiceTest {
    private QuestionService underTest;
    private Set<Question> questions;
    Question questionTest1 = new Question("вопрос1", "ответ1");
    Question questionTest2 = new Question("вопрос2", "ответ2");
    Question questionTest3 = new Question("вопрос3", "ответ3");



    @BeforeEach
    void setUp() {
        questions = new HashSet<>();
        underTest = new JavaQuestionService(questions);
    }

    @Test
    void add_questionsFieldsAddedAndReturned() {

        Question result = underTest.add(questionTest1.getQuestion(), questionTest1.getAnswer());
        assertTrue(questions.contains(result));
        assertEquals(result, underTest.add(questionTest1));
    }

    @Test
    void add_questionAddedAndReturned() {
        Question result = underTest.add(questionTest1);
        assertTrue(questions.contains(result));
        assertEquals(result, questionTest1);

    }

    @Test
    void remove_questionRemovedAndReturned() {
        Question result = underTest.add(questionTest1);
        Question removedQuestion = underTest.remove(result);
        assertFalse(questions.contains(removedQuestion));


    }

    @Test
    void getAll_setWithQuestions_setWithoutQuestions() {

        underTest.add(questionTest1);
        underTest.add(questionTest2);

        Collection<Question> result = underTest.getAll();

        assertEquals(result, questions);
        assertTrue(result.containsAll(questions));

        questions.clear();
        assertTrue(questions.isEmpty());
    }

    @Test
    void getRandomQuestion() {

        questions.add(questionTest1);
        questions.add(questionTest2);
        questions.add(questionTest3);

        Question result = underTest.getRandomQuestion();
        assertTrue(result,questions.containsAll());

    }

}