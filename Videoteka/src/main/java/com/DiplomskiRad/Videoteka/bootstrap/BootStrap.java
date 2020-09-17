package com.DiplomskiRad.Videoteka.bootstrap;

import com.DiplomskiRad.Videoteka.repositories.CartoonRepository;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import com.DiplomskiRad.Videoteka.repositories.SeriesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private MovieRepository movieRepository;
    private SeriesRepository seriesRepository;
    private CartoonRepository cartoonRepository;

    public BootStrap(MovieRepository movieRepository,
                     SeriesRepository seriesRepository,
                     CartoonRepository cartoonRepository){
        this.movieRepository=movieRepository;
        this.seriesRepository=seriesRepository;
        this.cartoonRepository=cartoonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
