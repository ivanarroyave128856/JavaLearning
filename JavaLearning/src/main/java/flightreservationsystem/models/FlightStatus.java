package flightreservationsystem.models;

public class FlightStatus {
    private short id;
    private Seat seat;
    private Person person;
    private TechnicalFlightDetails technicalFlightDetails;
    private Airport airport;
    private FlightInfo flightInfo;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TechnicalFlightDetails getTechnicalFlightDetails() {
        return technicalFlightDetails;
    }

    public void setTechnicalFlightDetails(TechnicalFlightDetails technicalFlightDetails) {
        this.technicalFlightDetails = technicalFlightDetails;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    public FlightStatus() {
    }

    public FlightStatus(short id, Seat seat, Person person, TechnicalFlightDetails technicalFlightDetails,
                        Airport airport, FlightInfo flightInfo) {
        this.id = id;
        this.seat = seat;
        this.person = person;
        this.technicalFlightDetails = technicalFlightDetails;
        this.airport = airport;
        this.flightInfo = flightInfo;
    }
}
