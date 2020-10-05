package com.DiplomskiRad.Videoteka.bootstrap;


import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.repositories.CartoonRepository;
import com.DiplomskiRad.Videoteka.repositories.GenreRepository;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import com.DiplomskiRad.Videoteka.repositories.SeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootStrap implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final SeriesRepository seriesRepository;
    private final CartoonRepository cartoonRepository;

    public BootStrap(MovieRepository movieRepository,
                     GenreRepository genreRepository,
                     SeriesRepository seriesRepository,
                     CartoonRepository cartoonRepository){
        this.movieRepository=movieRepository;
        this.genreRepository=genreRepository;
        this.seriesRepository=seriesRepository;
        this.cartoonRepository=cartoonRepository;
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

        Series series = new Series("Test1",1999,20);
        Series series1 = new Series("Test2",2002,40);
        Series series2 = new Series("Test3",2001,21);
        Series series3 = new Series("KKK",2010,10);

        seriesRepository.save(series);
        seriesRepository.save(series1);
        seriesRepository.save(series2);
        seriesRepository.save(series3);

        Cartoon cartoon = new Cartoon("Test1",1999,20);
        Cartoon cartoon1 = new Cartoon("Test2",2002,10);
        Cartoon cartoon2 = new Cartoon("Test3",2007,4);
        Cartoon cartoon3 = new Cartoon("KKK",2011,7);

        cartoonRepository.save(cartoon);
        cartoonRepository.save(cartoon1);
        cartoonRepository.save(cartoon2);
        cartoonRepository.save(cartoon3);
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

        series.getGenres().addAll(Arrays.asList(g1,g2,g3));
        series1.getGenres().addAll(Arrays.asList(g1,g3));
        series2.getGenres().addAll(Arrays.asList(g1));
        series3.getGenres().addAll(Arrays.asList(g5));


        seriesRepository.save(series);
        seriesRepository.save(series1);
        seriesRepository.save(series2);
        seriesRepository.save(series3);

        cartoon.getGenres().addAll(Arrays.asList(g1,g2,g3));
        cartoon1.getGenres().addAll(Arrays.asList(g1,g3));
        cartoon2.getGenres().addAll(Arrays.asList(g1));
        cartoon3.getGenres().addAll(Arrays.asList(g5,g6));

        cartoonRepository.save(cartoon);
        cartoonRepository.save(cartoon1);
        cartoonRepository.save(cartoon2);
        cartoonRepository.save(cartoon3);


        System.out.println("Bootsrap ended!");


    }
}
