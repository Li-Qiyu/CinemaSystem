package application.entity;

import application.entity.persistent.PersistentScreen;
import application.entity.persistent.PersistentScreening;
import application.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class Screening {

    private SqlSession sqlSession = null;


    public void addScreening(PersistentScreening screening){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.insert("application/entity/Screening.addScreening",screening);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish add");
    }

    public void deleteScreening(int screeningIdParam){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.delete("application/entity/Screening.deleteScreening",screeningIdParam);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish delete");

    }

    public void updateScreening(PersistentScreening screening){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.update("application/entity/Screening.updateScreening",screening);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish update");

    }

    public List<PersistentScreening> getScreenings(Map mapParam){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentScreening> screeningList = sqlSession.selectList("application/entity/Screening.getScreenings",mapParam);

        sqlSession.commit();
        sqlSession.close();

        return screeningList;

    }

    public List<PersistentScreening> getAllScreenings(){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentScreening> allScreeningList = sqlSession.selectList("application/entity/Screening.getAllScreenings");

        sqlSession.commit();
        sqlSession.close();

        return allScreeningList;

    }

}
