package application.entity.persistent;

public class PersistentScreen {

    private int screenId;
    private int capacity;

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "screenId=" + screenId +
                ", capacity=" + capacity +
                '}';
    }
}
