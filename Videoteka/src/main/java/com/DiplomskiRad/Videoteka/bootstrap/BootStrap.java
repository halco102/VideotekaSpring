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
        Movie movie = new Movie("Test1",1999,20);
        Movie movie1 = new Movie("Test2",2002,40);
        Movie movie2 = new Movie("KKK",2003,30);
        Movie movie3 = new Movie("Test3",2004,50);
        //save movie
        movieRepository.save(movie);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        //create genres
        Genre g1 = new Genre("g1");
        Genre g2 = new Genre("g2");
        Genre g3 = new Genre("g3");
        Genre g4 = new Genre("g4");
        Genre g5 = new Genre("g5");
        Genre g6 = new Genre("g6");
        Genre g7 = new Genre("g7");
        Genre g8 = new Genre("g8");
        Genre g9 = new Genre("g9");
        Genre g10 = new Genre("g10");
        Genre g11 = new Genre("g11");
        Genre g12= new Genre("g12");

        //save genres
        genreRepository.saveAll(Arrays.asList(g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12));

        //add genres to movie
        movie.getGenres().addAll(Arrays.asList(g1,g2,g3));
        movie1.getGenres().addAll(Arrays.asList(g1,g3));
        movie2.getGenres().addAll(Arrays.asList(g1));
        movie3.getGenres().addAll(Arrays.asList(g5));
        //update movie
        movieRepository.save(movie);
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        System.out.println("Bootsrap ended!");


    }
}
