package flightreservationsystem.models;

public class Airport {
    private String id;
    private String name;
    private String country;
    private String city;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Airport() {
    }

    public Airport(String id, String name, String country, String city, String address) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
    }
}
