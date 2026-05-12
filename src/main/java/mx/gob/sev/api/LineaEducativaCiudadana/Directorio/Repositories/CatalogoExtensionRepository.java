package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoExtension;

public interface CatalogoExtensionRepository extends JpaRepository<CatalogoExtension, Long> {

    Optional<CatalogoExtension> findByExtensionIgnoreCase(String extension);

}
