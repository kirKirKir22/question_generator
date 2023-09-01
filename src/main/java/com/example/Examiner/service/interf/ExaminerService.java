package com.example.Examiner.service.interf;

import com.example.Examiner.dto.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
