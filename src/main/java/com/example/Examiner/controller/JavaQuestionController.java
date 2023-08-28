package com.example.Examiner.controller;

import com.example.Examiner.dto.Question;
import com.example.Examiner.service.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;

    }

    @RequestMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @RequestMapping()
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @RequestMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question questionForRemove = new Question(question, answer);
        return service.remove(questionForRemove);
    }
}



