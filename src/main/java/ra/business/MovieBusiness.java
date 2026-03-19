package ra.business;

import ra.entity.Movie;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieBusiness {
    private static MovieBusiness instance;
    private List<Movie> movieList;

    private MovieBusiness() {
        movieList = new ArrayList<>();
    }

    public static MovieBusiness getInstance() {
        if (instance == null) {
            instance = new MovieBusiness();
        }
        return instance;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void displayAll() {
        if (movieList.isEmpty()) {
            System.out.println("Danh sach phim dang trong");
            return;
        }
        movieList.forEach(Movie::displayData);
    }

    public Movie findById(String movieId) {
        return movieList.stream()
                .filter(m -> m.getMovieId().equalsIgnoreCase(movieId))
                .findFirst()
                .orElse(null);
    }

    public boolean addMovie(Movie movie) {
        boolean isExist = movieList.stream()
                .anyMatch(m -> m.getMovieId().equalsIgnoreCase(movie.getMovieId()));
        if (isExist) {
            System.out.println("Ma phim da ton tai");
            return false;
        }
        return movieList.add(movie);
    }

    public void searchMovieByName(String name) {
        List<Movie> results = movieList.stream()
                .filter(m -> m.getMovieName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if (results.isEmpty()) System.out.println("Khong tim thay phim");
        else results.forEach(Movie::displayData);
    }

    public boolean removeMovie(String movieId) {
        return movieList.removeIf(m -> m.getMovieId().equals(movieId));
    }

    public void sortMovieByView() {
        movieList.sort(Comparator.comparingInt(Movie::getViews).reversed());
        System.out.println("Da sap xep giam dan theo luot xem");
    }

    public void filterPopularMovies() {
    }
}