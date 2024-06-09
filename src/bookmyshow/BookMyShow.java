package bookmyshow;


import bookmyshow.controller.MovieController;
import bookmyshow.controller.TheatreController;
import bookmyshow.entity.*;
import bookmyshow.enums.City;
import bookmyshow.enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
    }

    private void initialize() {
        createMovies();
        createTheatre();
    }

    private void createTheatre() {
        System.out.println("Creating Theatre");
        Movie movie = movieController.getMoviesByName("The Shawshank Redemption");
        Movie movie1 = movieController.getMoviesByName("Moneyball");

        Theatre inoxTheatre = new Theatre(1);
        inoxTheatre.setCity(City.BANGALORE);
        inoxTheatre.setName("INOX");
        inoxTheatre.setAddress("MG Road");
        inoxTheatre.setScreens(createScreens());
        Shows show1 = createShows(1, inoxTheatre.getScreens().get(0), movie, 8);
        Shows show2 = createShows(2, inoxTheatre.getScreens().get(0), movie1, 16);

        List<Shows> shows = new ArrayList<>();
        shows.add(show1);
        shows.add(show2);
        inoxTheatre.setShows(shows);

        Theatre pvr = new Theatre(2);
        pvr.setCity(City.BANGALORE);
        pvr.setName("PVR");
        pvr.setAddress("MG Road");
        pvr.setScreens(createScreens());
        Shows show11 = createShows(1, pvr.getScreens().get(0), movie, 8);
        Shows show12 = createShows(2, pvr.getScreens().get(0), movie1, 16);

        List<Shows> shows1 = new ArrayList<>();
        shows1.add(show11);
        shows1.add(show12);
        pvr.setShows(shows);

        theatreController.addTheatre(City.BANGALORE, inoxTheatre);
        theatreController.addTheatre(City.DELHI, pvr);
        System.out.println("Theatre created successfully");
    }

    private Shows createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Shows show = new Shows();
        show.setId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }


    private List<Screen> createScreens() {
        List<Screen> screenList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<Seat> seats = createSeats();
            Screen screen = new Screen(i, seats);
            screenList.add(screen);
        }
        return screenList;
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat(i, i+1, SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat(i, i+1, SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat(i, i+1, SeatCategory.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }


    private void createMovies() {
        Movie movie1 = new Movie(1, "The Shawshank Redemption", 142);
        Movie movie2 = new Movie(1, "Moneyball", 150);
        movieController.addMovie(City.BANGALORE, movie1);
        movieController.addMovie(City.BANGALORE, movie2);
        movieController.addMovie(City.DELHI, movie1);
        movieController.addMovie(City.DELHI, movie2);
    }

}
