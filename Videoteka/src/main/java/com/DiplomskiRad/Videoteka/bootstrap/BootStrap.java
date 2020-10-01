package com.DiplomskiRad.Videoteka.bootstrap;


import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.repositories.GenreRepository;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootStrap implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public BootStrap(MovieRepository movieRepository,GenreRepository genreRepository){
        this.movieRepository=movieRepository;
        this.genreRepository=genreRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap started!");

        //create movie
        Movie movie = new Movie("Test1",1,20);
        Movie movie1 = new Movie("Test2",2,40);
        Movie movie2 = new Movie("KKK",3,30);
        //save movie
        movieRepository.save(movie);
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        //create genres
        Genre g1 = new Genre("g1");
        Genre g2 = new Genre("g2");
        Genre g3 = new Genre("g3");

        //save genres
        genreRepository.saveAll(Arrays.asList(g1,g2,g3));

        //add genres to movie
        movie.getGenres().addAll(Arrays.asList(g1,g2,g3));
        movie1.getGenres().addAll(Arrays.asList(g1,g3));
        movie2.getGenres().addAll(Arrays.asList(g1));
        //update movie
        movieRepository.save(movie);
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        System.out.println("Bootsrap ended!");


    }
}
