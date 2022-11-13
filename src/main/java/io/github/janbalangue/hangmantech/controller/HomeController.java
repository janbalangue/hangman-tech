package io.github.janbalangue.hangmantech.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.github.janbalangue.hangmantech.repository.SolutionRepository;

@RestController
@RequestMapping("/")
public class HomeController implements ErrorController {

    @Autowired
    private SolutionRepository solutionRepository;

    Map<String, String> solutionMap;
    ModelAndView modelAndView;

    @GetMapping("/")
    public ModelAndView home() {
        modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView getSolutionAndStartGame(Model model) {
        getSolution();
        modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + solutionMap.get("youtube"));
        return modelAndView;
    }
    
    public void getSolution() {
        String solution = solutionRepository.findSolution();
        String[] solutionParts = solution.split(",");
        solutionMap = new HashMap<>();
        solutionMap.put("name", solutionParts[1]);
        solutionMap.put("wiki", solutionParts[2]);
        solutionMap.put("youtube", solutionParts[3]);
    }
    
}
