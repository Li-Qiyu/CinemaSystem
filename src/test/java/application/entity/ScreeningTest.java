package application.entity;

import application.entity.persistent.PersistentScreen;
import application.entity.persistent.PersistentScreening;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class ScreeningTest {

    private Screening screening = null;

    @Test
    public void testAddScreening() throws IOException {
        PersistentScreening persistentScreening = new PersistentScreening();
        persistentScreening.setDate("2020-1-30");
        persistentScreening.setTime("17:00-18:30");
        persistentScreening.setTicketSold(200);
        persistentScreening.setScreenId(1);

        screening = new Screening();
        screening.addScreening(persistentScreening);
    }

    @Test
    public void testDeleteScreening(){
        int screeningIdParam = 5;

        screening = new Screening();
        screening.deleteScreening(screeningIdParam);
    }

    @Test
    public void testUpdateScreening(){
        PersistentScreening persistentScreening = new PersistentScreening();
        persistentScreening.setScreeningId(1);
        persistentScreening.setDate("2020-2-30");
        persistentScreening.setTime("14:00-15:30");
        persistentScreening.setTicketSold(300);
        persistentScreening.setScreenId(2);

        screening = new Screening();
        screening.updateScreening(persistentScreening);
    }

    @Test
    public void testGetScreenings(){
        Map<String,Object> mapParam = new HashMap<String, Object>();

        mapParam.put("date","2020-2-30");
        mapParam.put("time","14:00-15:30");
        mapParam.put("ticketSold",300);
        mapParam.put("screenId",2);

        screening = new Screening();
        List<PersistentScreening> screeningList = screening.getScreenings(mapParam);
        System.out.println(screeningList);
    }

    @Test
    public void testGetAllScreenings(){
        screening = new Screening();
        List<PersistentScreening> allScreeningList = screening.getAllScreenings();
        System.out.println(allScreeningList);
        System.out.println(allScreeningList.get(0));
        System.out.println(allScreeningList.get(1));
    }

}
