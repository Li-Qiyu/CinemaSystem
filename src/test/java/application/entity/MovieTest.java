package application.entity;

import application.entity.persistent.PersistentMovie;
import application.entity.persistent.PersistentScreening;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTest {

    private Movie movie = null;

    @Test
    public void testAddMovie() throws IOException {
        PersistentMovie persistentMovie = new PersistentMovie();
        persistentMovie.setTitle("xcv");
        persistentMovie.setRunningTime("90min");
        persistentMovie.setYear(2000);

        movie = new Movie();
        movie.addMovie(persistentMovie);

    }

    @Test
    public void testDeleteMovie(){
        String titleParam = "asd";

        movie = new Movie();
        movie.deleteMovie(titleParam);
    }

    @Test
    public void testUpdateMovie(){
        PersistentMovie persistentMovie = new PersistentMovie();
        persistentMovie.setTitle("qwe");
        persistentMovie.setRunningTime("80min");
        persistentMovie.setYear(2000);

        movie = new Movie();
        movie.updateMovie(persistentMovie);
    }

    @Test
    public void testGetMovies(){
        Map<String,Object> mapParam = new HashMap<String, Object>();

        mapParam.put("title","rty");
//        mapParam.put("runningTime","90min");
//        mapParam.put("year",2000);

        movie = new Movie();
        List<PersistentMovie> movieList = movie.getMovies(mapParam);
        System.out.println(movieList);
    }

    @Test
    public void testGetRowNum(){
        movie = new Movie();
        int rowNum = movie.getRowNum();
        System.out.println(rowNum);
    }

    @Test
    public void testGetAllMovies(){
        movie = new Movie();
        List<PersistentMovie> allMovieList = movie.getAllMovies();
        System.out.println(allMovieList);
        System.out.println(allMovieList.get(0));
        System.out.println(allMovieList.get(1));
    }
}
