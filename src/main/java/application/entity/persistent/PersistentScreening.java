package application.entity.persistent;

public class PersistentScreening {

    private int screeningId;
    private String date;
    private String time;
    private int ticketSold;
    private int screenId;

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeingId) {
        this.screeningId = screeingId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "screeningId=" + screeningId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ticketSold=" + ticketSold +
                ", screenId=" + screenId +
                '}';
    }
}
