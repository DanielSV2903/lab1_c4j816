package cr.ac.ucr.paraiso.lab1_c4j816.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.paraiso.lab1_c4j816.domain.Airline;

public class AirlineDataTest {
    @Autowired 
    private AirlineData airlineData;
    @Test
    @Transactional 
    @Sql(scripts = "/testAirlineData.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testFindAll() {
        //ARRANGE
        List<Airline> airlines;
        //ACT
        airlines = airlineData.findAll();
        //ASSERT
        assertTrue(airlines.size()>0);
    }
}
