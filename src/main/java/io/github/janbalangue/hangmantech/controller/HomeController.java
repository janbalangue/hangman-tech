package io.github.janbalangue.hangmantech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.github.janbalangue.hangmantech.entity.Solution;
import io.github.janbalangue.hangmantech.repository.SolutionRepository;

@RestController
@RequestMapping("/")
public class HomeController implements ErrorController {

    @Autowired
    private SolutionRepository solutionRepository;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @PostMapping()
    public String getSolution(Model model) {
        return solutionRepository.findSolution();
    }    
    
}
