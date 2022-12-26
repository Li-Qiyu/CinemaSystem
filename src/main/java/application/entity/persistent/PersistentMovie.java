package application.entity.persistent;

public class PersistentMovie {

    private String title;
    private String runningTime;
    private int year;
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersistentMovie{" +
                "title='" + title + '\'' +
                ", runningTime='" + runningTime + '\'' +
                ", year=" + year +
                ", id=" + id +
                '}';
    }

    public PersistentMovie(){

    }

    public PersistentMovie(String title, String runningTime, int year) {
        this.title = title;
        this.runningTime = runningTime;
        this.year = year;
    }
}
