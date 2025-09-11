package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoArea;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoAreaRepository;

@Service
public class CatalogoAreaImpl implements CatalogoAreaService {

    @Autowired
    private CatalogoAreaRepository catalogoAreaRepository;

    @Override
    public List<CatalogoArea> findAll() {
        return (List<CatalogoArea>) this.catalogoAreaRepository.findAll();
    }

    @Override
    public List<CatalogoArea> findAllActive() {
        return (List<CatalogoArea>) this.catalogoAreaRepository.findAllActive();
    }

    @Override
    public List<CatalogoArea> findAllInactive() {
        return (List<CatalogoArea>) this.catalogoAreaRepository.findAllInactive();
    }

    @Override
    public CatalogoArea findById(Long idArea) {
        return this.catalogoAreaRepository.findById(idArea)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + idArea));
    }

    @Override
    public CatalogoArea save(CatalogoArea catalogoArea) {
        return this.catalogoAreaRepository.save(catalogoArea);
    }

    @Override
    public CatalogoArea update(CatalogoArea catalogoArea) {
        Optional<CatalogoArea> catalogoAreaOptional = this.catalogoAreaRepository.findById(catalogoArea.getIdArea());

        if (catalogoAreaOptional.isPresent()) {
            CatalogoArea catalogoAreaExistente = catalogoAreaOptional.get();
            catalogoAreaExistente.setNombre(catalogoArea.getNombre());
            catalogoAreaExistente.setNivel(catalogoArea.getNivel());
            catalogoAreaExistente.setIdInterno(catalogoArea.getIdInterno());
            catalogoAreaExistente.setOficial(catalogoArea.getOficial());
            catalogoAreaExistente.setActivo(catalogoAreaExistente.getActivo());

            return this.catalogoAreaRepository.save(catalogoAreaExistente);
        }
        throw new RuntimeException("Usuario no encontrado: " + catalogoArea.getIdArea());
    }

}
