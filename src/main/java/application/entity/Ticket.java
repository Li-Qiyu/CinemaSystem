package application.entity;

import application.entity.persistent.PersistentScreening;
import application.entity.persistent.PersistentTicket;
import application.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class Ticket {

    private SqlSession sqlSession = null;


    public void addTicket(PersistentTicket ticket){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.insert("application/entity/Ticket.addTicket",ticket);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish add");
    }

    public void deleteTicket(int ticketIdParam){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.delete("application/entity/Ticket.deleteTicket",ticketIdParam);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish delete");

    }

    public void updateTicket(PersistentTicket ticket){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        sqlSession.update("application/entity/Ticket.updateTicket",ticket);

        sqlSession.commit();
        sqlSession.close();

        System.out.println("finish update");

    }

    public List<PersistentTicket> getTickets(Map mapParam){

        sqlSession = MyBatisSqlSessionFactory.getSqlSession();

        List<PersistentTicket> ticketList = sqlSession.selectList("application/entity/Ticket.getTickets",mapParam);

        sqlSession.commit();
        sqlSession.close();

        return ticketList;

    }

}
