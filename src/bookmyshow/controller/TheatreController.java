package bookmyshow.controller;

import bookmyshow.entity.Theatre;
import bookmyshow.enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityToTheatre = new HashMap<>();
    List<Theatre> allTheatres = new ArrayList<>();

    public List<Theatre> getTheatresByCity(City city) {
        return cityToTheatre.get(city);
    }

    public void addTheatre(City city, Theatre theatre) {
        List<Theatre> theatreList = cityToTheatre.getOrDefault(city, new ArrayList<>());
        theatreList.add(theatre);
        cityToTheatre.put(city, theatreList);
        if (Boolean.TRUE.equals(allTheatres.stream().noneMatch(t -> t.getId() == theatre.getId()))) {
            allTheatres.add(theatre);
        }
    }
}
