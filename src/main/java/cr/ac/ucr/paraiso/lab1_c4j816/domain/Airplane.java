package cr.ac.ucr.paraiso.lab1_c4j816.domain;

public class Airplane {
    private int airplaneId;
    private int capacity;
    private AirplaneType type;
    private Airline airline;

    public Airplane() {
        this.airline=new Airline();
        this.type=new AirplaneType();
    }

    public Airplane(int airplaneId, int capacity, AirplaneType type, Airline airline) {
        this.airplaneId = airplaneId;
        this.capacity = capacity;
        this.type = type;
        this.airline = airline;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

}
