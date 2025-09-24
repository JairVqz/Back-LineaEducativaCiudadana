package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite;

import java.util.List;

import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;

public interface CatalogoTramiteService {

    List<CatalogoTramite> findAll();

    List<CatalogoTramite> findAllActive();

    List<CatalogoTramite> findAllInactive();

    CatalogoTramite findById(Long idTramite);

    List<CatalogoTramite> findTramiteByArea(Long idArea);

    CatalogoTramite save(CatalogoTramite catalogoTramite);

    CatalogoTramite update(CatalogoTramite catalogoTramite);
}
