package application.entity;

import application.entity.persistent.PersistentMovie;
import application.entity.persistent.PersistentScreen;
import application.entity.persistent.PersistentScreening;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreenTest {

    private Screen screen = null;

    @Test
    public void testAddScreen() throws IOException {
        PersistentScreen persistentScreen = new PersistentScreen();
        persistentScreen.setCapacity(80);

        screen = new Screen();
        screen.addScreen(persistentScreen);

    }

    @Test
    public void testDeleteScreen(){
        int screenIdParam = 3;

        screen = new Screen();
        screen.deleteScreen(screenIdParam);
    }

    @Test
    public void testUpdateScreen(){
        PersistentScreen persistentScreen = new PersistentScreen();
        persistentScreen.setScreenId(1);
        persistentScreen.setCapacity(60);

        screen = new Screen();
        screen.updateScreen(persistentScreen);
    }

    @Test
    public void testGetScreens(){
        Map<String,Object> mapParam = new HashMap<String, Object>();

        mapParam.put("screenId",1);
        mapParam.put("capacity",60);

        screen = new Screen();
        List<PersistentScreen> screenList = screen.getScreens(mapParam);
        System.out.println(screenList);
    }

    @Test
    public void testGetAllScreens(){
        screen = new Screen();
        List<PersistentScreen> allScreenList = screen.getAllScreens();
        System.out.println(allScreenList);
        System.out.println(allScreenList.get(0));
        System.out.println(allScreenList.get(1));
    }
}
