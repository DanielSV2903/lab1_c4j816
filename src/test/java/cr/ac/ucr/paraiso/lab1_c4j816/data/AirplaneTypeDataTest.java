package cr.ac.ucr.paraiso.lab1_c4j816.data;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import cr.ac.ucr.paraiso.lab1_c4j816.domain.AirplaneType;

@SpringBootTest 

public class AirplaneTypeDataTest {

    @Autowired
    private AirplaneTypeData airplaneTypeData;

    @Test
    @DisplayName("Given existing movies, when searching by title and genre, then return the movies")
    @Transactional // para que no se guarden cambios en la base de datos después de la prueba
    @Sql(scripts = "/testAirplaneTypeData.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    // Carga datos de prueba antes de ejecutar el método de prueba
    void testFindAvailableAirplaneTypes() {
        // Arrange
        List<AirplaneType> types;
        // Act
        types = airplaneTypeData.findAll();
        // Assert
        assertTrue(types.size() ==3);
    }
}
