package cr.ac.ucr.paraiso.lab1_c4j816.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.paraiso.lab1_c4j816.domain.Airline;
import cr.ac.ucr.paraiso.lab1_c4j816.domain.Airplane;
import cr.ac.ucr.paraiso.lab1_c4j816.domain.AirplaneType;

@Repository
public class AirplaneData {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AirplaneTypeData airplaneTypeData;
    @Autowired 
    AirlineData airlineData;

    public List<Airplane> findAirplanesByTypeId(int typeId) {
        String query = """
                    SELECT a.airplane_id, a.capacity, a.airline_id, a.type_id
                    FROM airplane a
                    INNER JOIN airplane_type at ON a.type_id = at.type_id
                    WHERE a.type_id = ?
                """;
        List<Airplane> planes = jdbcTemplate.query(query, new AirplaneExtractor(), typeId);
        linkAirplaneTypes(planes);
        linkAirlines(planes);
        return planes;
    }

    private void linkAirplaneTypes(List<Airplane> planes) {
       //Verifico si la lista esta vacia 
    if (planes == null || planes.isEmpty()) {
        return;
    }
    List<AirplaneType> types = airplaneTypeData.findAll();
    int targetTypeId = planes.getFirst().getType().getTypeId();
    AirplaneType matchedType = null;
    for (AirplaneType t : types) {
        if (t.getTypeId() == targetTypeId) {
            matchedType = t;
            break;//sale de la busqueda al encontrar match
        }
    }
    if (matchedType != null) {
        for (Airplane p : planes) {
            p.setType(matchedType);
        }
    }
}
public void linkAirlines(List<Airplane> planes){
if (planes == null || planes.isEmpty()) {
        return;
    }
    List<Airline> airlines=airlineData.findAllAirlines();
    for(Airplane airplane:planes){
        for(Airline airline:airlines){
            if (airplane.getAirline().getAirlineId()==airline.getAirlineId()) {
                airplane.setAirline(airline);                
            }
        }
    }

}
}

class AirplaneExtractor implements ResultSetExtractor<List<Airplane>> {
    @Override
    public List<Airplane> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Airplane> airplanes = new ArrayList<>();

        while (rs.next()) {
            Airplane plane = new Airplane();
            plane.setAirplaneId(rs.getInt("airplane_id"));
            plane.setCapacity(rs.getInt("capacity"));
            AirplaneType type = new AirplaneType();
            Airline airline=new Airline();
            type.setTypeId(rs.getInt("type_id"));
            airline.setAirlineId(rs.getInt("airline_id"));
            plane.setType(type);
            plane.setAirline(airline);
            airplanes.add(plane);
        }

        return airplanes;
    }
}
