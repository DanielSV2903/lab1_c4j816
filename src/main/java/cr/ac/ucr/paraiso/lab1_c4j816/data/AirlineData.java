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

@Repository 
public class AirlineData {
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    public List<Airline> findAllAirlines(){
        String query="""
                SELECT * FROM airline
                """;

        return jdbcTemplate.query(query,new AirlineExtractor());

    }

}

class AirlineExtractor implements ResultSetExtractor<List<Airline>> {

    @Override
    public List<Airline> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Airline> airlines=new ArrayList<>();
       while (rs.next()) {
        Airline airline=new Airline();
        airline.setAirlineId(rs.getInt("airline_id"));
        airline.setIata(rs.getString("iata"));
        airline.setAirlineName(rs.getString("airlinename"));
        airlines.add(airline);
       }
        return airlines;
    }
    

    
}
