package com.example.Examiner.service;

import com.example.Examiner.dto.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService underTest;

    private Set<Question> questions;

    Question questionTest1 = new Question("вопрос1", "ответ1");
    Question questionTest2 = new Question("вопрос2", "ответ2");
    Question questionTest3 = new Question("вопрос3", "ответ3");

    @BeforeEach
    void setUp() {
        questions = new HashSet<>();
        questions.add(questionTest1);
        questions.add(questionTest2);
        questions.add(questionTest3);

        underTest = new JavaQuestionService();
    }

    @Test
    void add_questionsFieldsAddedAndReturned() {

        Question result = underTest.add(questionTest1.getQuestion(), questionTest1.getAnswer());
        assertTrue(underTest.getAll().contains(result));
        assertEquals(result, questionTest1);
    }
/*

    @Test
    public void shouldAddQuestion() {
        int beforeCount = questionService.getAll().size();

        assertThat(questionService.add(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }
*/

    @Test
    void add_questionAddedAndReturned() {
        Question result = underTest.add(questionTest1);
        assertTrue(questions.contains(result));
        assertEquals(result, questionTest1);

    }

    @Test
    void remove_questionRemovedAndReturned() {
        Question result = underTest.add("a","б");
        Question removedQuestion = underTest.remove(result);
        assertFalse(questions.contains(removedQuestion));


    }
/*
    @Test
    public void shouldRemoveQuestion() {
        int beforeCount = questionService.getAll().size();

        assertThat(questionService.remove(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isNotIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }*/

    @Test
    void getAll_setWithQuestions_setWithoutQuestions() {

        underTest.add(questionTest1);
        underTest.add(questionTest2);
        underTest.add(questionTest3);

        Collection<Question> result = underTest.getAll();

        assertEquals(result, questions);
        assertTrue(result.containsAll(questions));

        questions.clear();
        assertTrue(result.isEmpty());
    }

    @Test
    void getRandomQuestion_NotEmptySet() {

        underTest.add(questionTest1);
        underTest.add(questionTest2);
        underTest.add(questionTest3);

        Question result = underTest.getRandomQuestion();
        assertTrue(underTest.getAll().contains(result));

    }

    @Test
    void getRandomQuestion_EmptySet() {

        assertThrows(RuntimeException.class, () -> underTest.getRandomQuestion());
    }
}