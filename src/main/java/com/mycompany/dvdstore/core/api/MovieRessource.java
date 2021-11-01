package com.mycompany.dvdstore.core.api;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieRessource {

    @Autowired
    private MovieServiceInterface movieService;

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> list() {
        System.out.println("Display Home has been invoked");
        return movieService.getMovieList();
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie) {
        return movieService.registerMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable("id") Long idMovie) {
        System.out.println("La methode displayMovieCart a été invoquée !");
        return movieService.getMovieById(idMovie);
    }
}
