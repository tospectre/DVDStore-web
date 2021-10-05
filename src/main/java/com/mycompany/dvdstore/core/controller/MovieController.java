package com.mycompany.dvdstore.core.controller;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.DefaultMovieService;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.registerMovie(movie);
        return "movie-added";
    }

    @GetMapping("/{id}")
    public String displayMovieCard(@PathVariable(value = "id") Long idMovie, Model model) {
        System.out.println("La methode displayMovieCart a été invoquée !");
        model.addAttribute("movie", movieService.getMovieById(idMovie));
        return "movie-details";
    }
}
