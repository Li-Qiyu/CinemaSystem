package application.entity.persistent;

public class PersistentTicket {

    private int ticketId;
    private String date;
    private String time;
    private String movieTitle;
    private int screenId;
    private int seatId;
    private double price;
    private boolean status;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PersistentTicket{" +
                "ticketId=" + ticketId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", screenId=" + screenId +
                ", seatId=" + seatId +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
