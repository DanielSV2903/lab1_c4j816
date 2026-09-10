package cr.ac.ucr.paraiso.lab1_c4j816.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cr.ac.ucr.paraiso.lab1_c4j816.domain.AirplaneType;
@Repository 
public class AirplaneTypeData {
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    public AirplaneTypeData() {
    }

    public List<AirplaneType> findAll() {

        String sqlQuery = """
                SELECT * FROM airplane_type
                """;
        return jdbcTemplate.query(sqlQuery, BeanPropertyRowMapper.newInstance(AirplaneType.class));
    }
}