package cr.ac.ucr.paraiso.lab1_c4j816.domain;

public class Airline {
    private int airlineId;
    private String iata;
    private String airlineName;

    public Airline() {
    }

    public Airline(int airlineId, String iata, String airlineName) {
        this.airlineId = airlineId;
        this.iata = iata;
        this.airlineName = airlineName;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

}
