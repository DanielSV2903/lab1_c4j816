package cr.ac.ucr.paraiso.lab1_c4j816.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cr.ac.ucr.paraiso.lab1_c4j816.business.AirplaneBusiness;
import cr.ac.ucr.paraiso.lab1_c4j816.business.AirplaneTypeBusiness;
import cr.ac.ucr.paraiso.lab1_c4j816.domain.Airplane;
import cr.ac.ucr.paraiso.lab1_c4j816.domain.AirplaneType;


@Controller 
public class AirplaneController {
    @Autowired 
    private AirplaneBusiness airplaneBusiness;
    @Autowired 
    private AirplaneTypeBusiness airplaneTypeBusiness;

@RequestMapping(value="/ver_tipos_avion",method=RequestMethod.GET)
public String iniciar(Model model){
    List<AirplaneType> tipos = airplaneTypeBusiness.findAvailableAirplaneTypes();
        model.addAttribute("tiposAvion", tipos);
    return "ver_tipos_avion";
}
@RequestMapping(value="/mostrar_aviones",method=RequestMethod.GET)
public String buscarPorTipo(Model model, @RequestParam("idTipo") int idTipo) {
    List<Airplane> planes= airplaneBusiness.findAirplanesByTypeId(idTipo);
    model.addAttribute("aviones", planes);
    AirplaneType tipoSeleccionado = airplaneTypeBusiness.findAvailableAirplaneTypes()
                .stream()
                .filter(t -> t.getTypeId() == idTipo)
                .findFirst()
                .orElse(null);

        model.addAttribute("tipoAvion", tipoSeleccionado);
    return "mostrar_aviones";
}

}
