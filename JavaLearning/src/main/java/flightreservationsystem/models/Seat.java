package flightreservationsystem.models;

import java.math.BigDecimal;

public class Seat {
    private String id;
    private boolean isSmoking;
    private boolean isPremium;
    private boolean isBusy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public Seat() {
    }

    public Seat(String id, boolean isSmoking, boolean isPremium, boolean isBusy) {
        this.id = id;
        this.isSmoking = isSmoking;
        this.isPremium = isPremium;
        this.isBusy = isBusy;
    }
}
