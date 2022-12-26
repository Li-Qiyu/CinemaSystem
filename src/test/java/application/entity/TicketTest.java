package application.entity;

import application.entity.persistent.PersistentScreening;
import application.entity.persistent.PersistentTicket;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketTest {

    private Ticket ticket = null;

    @Test
    public void testAddTicket() throws IOException {
        PersistentTicket persistentTicket = new PersistentTicket();
        persistentTicket.setDate("2020-3-20");
        persistentTicket.setTime("19:00-20:30");
        persistentTicket.setMovieTitle("qwe");
        persistentTicket.setScreenId(1);
        persistentTicket.setSeatId(44);
        persistentTicket.setPrice(30.00);
        persistentTicket.setStatus(false);

        ticket = new Ticket();
        ticket.addTicket(persistentTicket);

    }

    @Test
    public void testDeleteTicket(){
        int ticketIdParam = 3;

        ticket = new Ticket();
        ticket.deleteTicket(ticketIdParam);
    }

    @Test
    public void testUpdateTicket(){
        PersistentTicket persistentTicket = new PersistentTicket();
        persistentTicket.setTicketId(1);
        persistentTicket.setDate("2020-1-30");
        persistentTicket.setTime("17:00-18:30");
        persistentTicket.setMovieTitle("qwe");
        persistentTicket.setScreenId(1);
        persistentTicket.setSeatId(22);
        persistentTicket.setPrice(30.00);
        persistentTicket.setStatus(true);

        ticket = new Ticket();
        ticket.updateTicket(persistentTicket);
    }

    @Test
    public void testGetTickets(){
        Map<String,Object> mapParam = new HashMap<String, Object>();

        mapParam.put("ticketId",1);
        mapParam.put("date","2020-1-30");
        mapParam.put("time","17:00-18:30");
        mapParam.put("movieTitle","qwe");
        mapParam.put("screenId",1);
        mapParam.put("seatId",22);
        mapParam.put("price",30.00);
        mapParam.put("status",true);

        ticket = new Ticket();
        List<PersistentTicket> ticketList = ticket.getTickets(mapParam);
        System.out.println(ticketList);
    }

}
