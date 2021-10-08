package com.mycompany.dvdstore.core.controller;

import com.mycompany.dvdstore.core.controller.form.MovieForm;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dvdstore")
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/home")
    public String displayHome(Model model) {
        System.out.println("Display Home has been invoked");
        model.addAttribute("movie", movieService.getMovieList());
        return "dvdstore-home";
    }

    @GetMapping("/add-movie-form")
    public String displayMovieForm(@ModelAttribute MovieForm movie) {
        System.out.println("add-movie-form has been invoked");

        return "add-movie-form";
    }
}
