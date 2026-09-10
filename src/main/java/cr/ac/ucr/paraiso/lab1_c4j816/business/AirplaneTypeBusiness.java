package cr.ac.ucr.paraiso.lab1_c4j816.business;

import java.util.List;

import org.springframework.stereotype.Service;

import cr.ac.ucr.paraiso.lab1_c4j816.data.AirplaneTypeData;
import cr.ac.ucr.paraiso.lab1_c4j816.domain.AirplaneType;
@Service
public class AirplaneTypeBusiness {
    private final AirplaneTypeData airplaneTypeData;

    public AirplaneTypeBusiness(AirplaneTypeData airplaneTypeData) {
        this.airplaneTypeData = airplaneTypeData;
    }
    public List<AirplaneType> findAvailableAirplaneTypes() {
        return airplaneTypeData.findAll();
    }

}
