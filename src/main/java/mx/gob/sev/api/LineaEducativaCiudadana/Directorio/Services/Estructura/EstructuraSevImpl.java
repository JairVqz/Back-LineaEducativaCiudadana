package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Estructura;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.EstructuraSev;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.EstructuraSevRepository;

@Service
public class EstructuraSevImpl implements EstructuraSevService {

    @Autowired
    private EstructuraSevRepository estructuraSevRepository;

    @Override
    public List<EstructuraSev> findAll() {
        return (List<EstructuraSev>) this.estructuraSevRepository.findAll();
    }

    @Override
    public List<EstructuraSev> findAllActive() {
        return (List<EstructuraSev>) this.estructuraSevRepository.findAllActive();
    }

    @Override
    public List<EstructuraSev> findAllInactive() {
        return (List<EstructuraSev>) this.estructuraSevRepository.findAllInactive();
    }

    @Override
    public EstructuraSev findById(Long idEstructura) {
        return this.estructuraSevRepository.findById(idEstructura)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado: " + idEstructura));
    }

    @Override
    public EstructuraSev save(EstructuraSev estructuraSev) {
        return this.estructuraSevRepository.save(estructuraSev);
    }

    @Override
    public EstructuraSev update(EstructuraSev estructuraSev) {
        Optional<EstructuraSev> estructuraOptional = this.estructuraSevRepository.findById(estructuraSev.getIdEstructura());

        if (estructuraOptional.isPresent()) {
            EstructuraSev estructuraExistente = estructuraOptional.get();
            estructuraExistente.setNombre(estructuraSev.getNombre());
            estructuraExistente.setNivel(estructuraSev.getNivel());
            estructuraExistente.setIdInterno(estructuraSev.getIdInterno());
            estructuraExistente.setOficial(estructuraSev.getOficial());
            estructuraExistente.setActivo(estructuraExistente.getActivo());

            return this.estructuraSevRepository.save(estructuraExistente);
        }
        throw new RuntimeException("Usuario no encontrado: " + estructuraSev.getIdEstructura());
    }

}
