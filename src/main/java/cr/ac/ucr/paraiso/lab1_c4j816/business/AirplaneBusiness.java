package cr.ac.ucr.paraiso.lab1_c4j816.business;

import java.util.List;

import org.springframework.stereotype.Service;

import cr.ac.ucr.paraiso.lab1_c4j816.data.AirplaneData;
import cr.ac.ucr.paraiso.lab1_c4j816.domain.Airplane;
@Service
public class AirplaneBusiness {
    private AirplaneData airplaneData;

    public AirplaneBusiness(AirplaneData airplaneData) {
        this.airplaneData = airplaneData;
    }
    
    public List<Airplane> findAirplanesByTypeId(int typeId) {
        return airplaneData.findAirplanesByTypeId(typeId);
    }

}
