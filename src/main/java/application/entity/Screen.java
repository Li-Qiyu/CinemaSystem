package application.entity;

import application.entity.persistent.PersistentMovie;
import application.entity.persistent.PersistentScreen;
import application.entity.persistent.PersistentScreening;
import application.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Screen {

    private SqlSession sqlSession = null;


    public void addScreen(PersistentScreen screen){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.insert("application/entity/Screen.addScreen",screen);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish add");
    }

    public void deleteScreen(int screenIdParam){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.delete("application/entity/Screen.deleteScreen",screenIdParam);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish delete");

    }

    public void updateScreen(PersistentScreen screen){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.update("application/entity/Screen.updateScreen",screen);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish update");

    }

    public List<PersistentScreen> getScreens(Map mapParam){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentScreen> screenList = sqlSession.selectList("application/entity/Screen.getScreens",mapParam);

        sqlSession.commit();
        sqlSession.close();

        return screenList;

    }

    public List<PersistentScreen> getAllScreens(){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentScreen> allScreenList = sqlSession.selectList("application/entity/Screen.getAllScreens");

        sqlSession.commit();
        sqlSession.close();

        return allScreenList;

    }

}
