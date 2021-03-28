package flightreservationsystem.models;

import java.sql.Time;
import java.util.Date;

public class FlightInfo {
    private String id;
    private String airport;
    private String fromCountry;
    private String toCountry;
    private String fromCity;
    private String toCity;
    private boolean isLocal;
    private String date;
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
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

    public FlightInfo() {
    }

    public FlightInfo(String id, String airport, String fromCountry, String toCountry, String fromCity, String toCity,
                      boolean isLocal, String date, String time) {
        this.id = id;
        this.airport = airport;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.isLocal = isLocal;
        this.date = date;
        this.time = time;
    }
}
