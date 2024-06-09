package bookmyshow.controller;

import bookmyshow.entity.Movie;
import bookmyshow.enums.City;

import java.util.*;

public class MovieController {
    Map<City, List<Movie>> cityToMovies = new HashMap<>();
    List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMoviesByCity(City city) {
        return cityToMovies.get(city);
    }

    public void addMovie(City city, Movie movie) {
        List<Movie> movies = cityToMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityToMovies.put(city, movies);
        if (Boolean.TRUE.equals(movieList.stream().noneMatch(m -> m.getId() == movie.getId()))) {
            movieList.add(movie);
        }
    }

    public void removeMovie(City city, Movie movie) {
        if (cityToMovies.containsKey(city)) cityToMovies.get(city).remove(movie);
        movieList.remove(movie);
    }

    public Movie getMoviesByName(String movie) {
        return movieList.stream().filter(m -> m.getName().equals(movie)).findFirst().orElse(null);
    }
}
