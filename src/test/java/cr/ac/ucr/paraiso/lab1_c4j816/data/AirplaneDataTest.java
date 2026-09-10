package cr.ac.ucr.paraiso.lab1_c4j816.data;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.paraiso.lab1_c4j816.domain.Airplane;
@SpringBootTest 
public class AirplaneDataTest {
    @Autowired 
    private AirplaneData airplaneData;
    @Test
    @Transactional 
    @Sql(scripts = "/testAirplaneTypeData.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testFindAirplanesByTypeId() {
        //Arrange
        List<Airplane> planes;
        //Act
        planes=airplaneData.findAirplanesByTypeId(1);
        //Assert
        assertTrue(planes.getFirst().getType().getTypeId()==1);
    }
}
