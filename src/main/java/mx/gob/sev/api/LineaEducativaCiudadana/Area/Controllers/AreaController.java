package mx.gob.sev.api.LineaEducativaCiudadana.Area.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.sev.api.LineaEducativaCiudadana.Area.Models.Area;
import mx.gob.sev.api.LineaEducativaCiudadana.Area.Services.AreaService;

@RestController
@RequestMapping("/api/Area")
@CrossOrigin(origins = "*")
public class AreaController {
    
    @Autowired
    private AreaService areaService;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Area> findAll() {
        return areaService.findAll();
    }
    
}
