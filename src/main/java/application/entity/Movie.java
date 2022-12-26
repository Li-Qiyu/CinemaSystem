package application.entity;

import application.entity.persistent.PersistentMovie;
import application.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;



public class Movie {

    private SqlSession sqlSession = null;


    public void addMovie(PersistentMovie movie) {

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.insert("application/entity/Movie.addMovie", movie);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish add");
    }

    public void deleteMovie(String titleParam) {

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.delete("application/entity/Movie.deleteMovie", titleParam);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish delete");

    }

    public void updateMovie(PersistentMovie movie) {

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.update("application/entity/Movie.updateMovie", movie);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish update");

    }

    public List<PersistentMovie> getMovies(Map mapParam) {

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentMovie> movieList = sqlSession.selectList("application/entity/Movie.getMovies", mapParam);

        sqlSession.commit();
        sqlSession.close();

        return movieList;

    }

    public int getRowNum() {

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        int rowNum = sqlSession.selectOne("application/entity/Movie.getRowNum");

        sqlSession.commit();
        sqlSession.close();

        return rowNum;
    }

    public List<PersistentMovie> getAllMovies(){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentMovie> allMovieList = sqlSession.selectList("application/entity/Movie.getAllMovies");

        sqlSession.commit();
        sqlSession.close();

        return allMovieList;

    }

}