package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.CatalogoTramite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoTramiteRepository;

@Service
public class CatalogoTramiteImpl implements CatalogoTramiteService {

    @Autowired
    private CatalogoTramiteRepository catalogoTramiteRepository;

    @Override
    public List<CatalogoTramite> findAll() {
        return (List<CatalogoTramite>) this.catalogoTramiteRepository.findAll();
    }

    @Override
    public List<CatalogoTramite> findAllActive() {
        return (List<CatalogoTramite>) this.catalogoTramiteRepository.findAllActive();
    }

    @Override
    public List<CatalogoTramite> findAllInactive() {
        return (List<CatalogoTramite>) this.catalogoTramiteRepository.findAllInactive();
    }

    @Override
    public CatalogoTramite findById(Long idTramite) {
        return this.catalogoTramiteRepository.findById(idTramite)
                .orElseThrow(() -> new EntityNotFoundException("Trámite no encontrado: " + idTramite));
    }

    @Override
    public List<CatalogoTramite> findTramiteByArea(Long idArea) {
        return (List<CatalogoTramite>) this.catalogoTramiteRepository.findTramiteByArea(idArea);
    }

    @Override
    public CatalogoTramite save(CatalogoTramite catalogoTramite) {
        return this.catalogoTramiteRepository.save(catalogoTramite);
    }

    @Override
    public CatalogoTramite update(CatalogoTramite tramite) {
        Optional<CatalogoTramite> tramiteOptional = this.catalogoTramiteRepository.findById(tramite.getIdTramite());
        if (tramiteOptional.isPresent()) {
            CatalogoTramite tramiteExistente = tramiteOptional.get();
            tramiteExistente.setTramite(tramite.getTramite());
            if (tramiteExistente.getCatalogoArea() != null) {
                tramiteExistente.setCatalogoArea(tramite.getCatalogoArea());
            }
            tramiteExistente.setActivo(tramite.getActivo());

            return this.catalogoTramiteRepository.save(tramiteExistente);
        }
        throw new RuntimeException("Trámite no encontrado: " + tramite.getIdTramite());
    }

    @Override
    public List<CatalogoTramite> findAllActiveTramitesByUsuario(List<Integer> idsTramites) {
        return catalogoTramiteRepository.findAllActiveTramitesByUsuario(idsTramites);
    }

}
