package mx.gob.sev.api.LineaEducativaCiudadana.Area.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Area.Models.Area;
import mx.gob.sev.api.LineaEducativaCiudadana.Area.Repositories.AreaRepository;

@Service
public class AreaImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> findAll() {
        return (List<Area>) areaRepository.findAll();
    }
    
}
