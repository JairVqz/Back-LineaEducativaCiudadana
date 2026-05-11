package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoArea;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoExtension;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.CatalogoTramite;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.DirectorioDTO;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.VistaDirectorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoAreaRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoExtensionRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.CatalogoTramiteRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.DirectorioRepository;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

@Service
public class DirectorioImpl implements DirectorioService {

    @Autowired
    private DirectorioRepository relacionDirectorioRepository;
    private CatalogoAreaRepository areaRepository;
    private CatalogoExtensionRepository extensionRepository;
    private CatalogoTramiteRepository tramiteRepository;

    @Override
    public List<Directorio> findAll() {
        return (List<Directorio>) this.relacionDirectorioRepository.findAll();
    }

    @Override
    public Directorio save(Directorio relacionDirectorio) {
        return this.relacionDirectorioRepository.save(relacionDirectorio);
    }

    @Override
    public List<VistaDirectorio> findAllVistaDActivo() {
        List<Object[]> resultados = relacionDirectorioRepository.findAllVistaDActivo();
        List<VistaDirectorio> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            // area
            Number idDirectorioNum = (Number) fila[0];
            Number idAreaNum = (Number) fila[1];
            String nombreAreaSt = (String) fila[2];
            Number areaActivaNum = (Number) fila[3];
            Number idInternoAreaNum = (Number) fila[4];
            String nombreAreaInternaSt = (String) fila[5];
            // tramite
            Number idTramiteNum = (Number) fila[6];
            String nombreTramiteSt = (String) fila[7];
            Number tramiteActivoNum = (Number) fila[8];
            // extension
            Number idExtensionNum = (Number) fila[9];
            String extensionSt = (String) fila[10];
            String responsableSt = (String) fila[11];
            Number extensionActivaNum = (Number) fila[12];
            // directorio
            Number directoroActivoNum = (Number) fila[13];

            // area
            Long idDirectorio = idDirectorioNum != null ? idDirectorioNum.longValue() : null;
            Long idArea = idAreaNum != null ? idAreaNum.longValue() : null;
            String nombreArea = nombreAreaSt != null ? nombreAreaSt : null;
            Long areaActiva = areaActivaNum != null ? areaActivaNum.longValue() : null;
            Long idInterno = idInternoAreaNum != null ? idInternoAreaNum.longValue() : null;
            String nombreAreaInterna = nombreAreaInternaSt != null ? nombreAreaInternaSt : null;
            // tramite
            Long idTramite = idTramiteNum != null ? idTramiteNum.longValue() : null;
            String nombreTramite = nombreTramiteSt != null ? nombreTramiteSt : null;
            Long tramiteActivo = tramiteActivoNum != null ? tramiteActivoNum.longValue() : null;
            // extension
            Long idExtension = idExtensionNum != null ? idExtensionNum.longValue() : null;
            String extension = extensionSt != null ? extensionSt : null;
            String responsable = responsableSt != null ? responsableSt : null;
            Long extensionActiva = extensionActivaNum != null ? extensionActivaNum.longValue() : null;
            // directorio
            Long directorioActivo = directoroActivoNum != null ? directoroActivoNum.longValue() : null;

            lista.add(new VistaDirectorio(
                    idDirectorio,
                    idArea,
                    nombreArea,
                    areaActiva,
                    idInterno,
                    nombreAreaInterna,
                    idTramite,
                    nombreTramite,
                    tramiteActivo,
                    idExtension,
                    extension,
                    responsable,
                    extensionActiva,
                    directorioActivo));
        }
        return lista;
    }

    @Override
    public List<VistaDirectorio> findAllVistaDInactivo() {
        List<Object[]> resultados = relacionDirectorioRepository.findAllVistaDInactivo();
        List<VistaDirectorio> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            // area
            Number idDirectorioNum = (Number) fila[0];
            Number idAreaNum = (Number) fila[1];
            String nombreAreaSt = (String) fila[2];
            Number areaActivaNum = (Number) fila[3];
            Number idInternoAreaNum = (Number) fila[4];
            String nombreAreaInternaSt = (String) fila[5];
            // tramite
            Number idTramiteNum = (Number) fila[6];
            String nombreTramiteSt = (String) fila[7];
            Number tramiteActivoNum = (Number) fila[8];
            // extension
            Number idExtensionNum = (Number) fila[9];
            String extensionSt = (String) fila[10];
            String responsableSt = (String) fila[11];
            Number extensionActivaNum = (Number) fila[12];
            // directorio
            Number directoroActivoNum = (Number) fila[13];

            // area
            Long idDirectorio = idDirectorioNum != null ? idDirectorioNum.longValue() : null;
            Long idArea = idAreaNum != null ? idAreaNum.longValue() : null;
            String nombreArea = nombreAreaSt != null ? nombreAreaSt : null;
            Long areaActiva = areaActivaNum != null ? areaActivaNum.longValue() : null;
            Long idInterno = idInternoAreaNum != null ? idInternoAreaNum.longValue() : null;
            String nombreAreaInterna = nombreAreaInternaSt != null ? nombreAreaInternaSt : null;
            // tramite
            Long idTramite = idTramiteNum != null ? idTramiteNum.longValue() : null;
            String nombreTramite = nombreTramiteSt != null ? nombreTramiteSt : null;
            Long tramiteActivo = tramiteActivoNum != null ? tramiteActivoNum.longValue() : null;
            // extension
            Long idExtension = idExtensionNum != null ? idExtensionNum.longValue() : null;
            String extension = extensionSt != null ? extensionSt : null;
            String responsable = responsableSt != null ? responsableSt : null;
            Long extensionActiva = extensionActivaNum != null ? extensionActivaNum.longValue() : null;
            // directorio
            Long directorioActivo = directoroActivoNum != null ? directoroActivoNum.longValue() : null;

            lista.add(new VistaDirectorio(
                    idDirectorio,
                    idArea,
                    nombreArea,
                    areaActiva,
                    idInterno,
                    nombreAreaInterna,
                    idTramite,
                    nombreTramite,
                    tramiteActivo,
                    idExtension,
                    extension,
                    responsable,
                    extensionActiva,
                    directorioActivo));
        }
        return lista;
    }

    @Override
    public List<VistaDirectorio> findTramitesByAreaActivo(Long idAreaa) {
        List<Object[]> resultados = relacionDirectorioRepository.findTramitesByAreaActivo(idAreaa);
        List<VistaDirectorio> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            // area
            Number idDirectorioNum = (Number) fila[0];
            Number idAreaNum = (Number) fila[1];
            String nombreAreaSt = (String) fila[2];
            Number areaActivaNum = (Number) fila[3];
            Number idInternoAreaNum = (Number) fila[4];
            String nombreAreaInternaSt = (String) fila[5];
            // tramite
            Number idTramiteNum = (Number) fila[6];
            String nombreTramiteSt = (String) fila[7];
            Number tramiteActivoNum = (Number) fila[8];
            // extension
            Number idExtensionNum = (Number) fila[9];
            String extensionSt = (String) fila[10];
            String responsableSt = (String) fila[11];
            Number extensionActivaNum = (Number) fila[12];
            // directorio
            Number directoroActivoNum = (Number) fila[13];

            // area
            Long idDirectorio = idDirectorioNum != null ? idDirectorioNum.longValue() : null;
            Long idArea = idAreaNum != null ? idAreaNum.longValue() : null;
            String nombreArea = nombreAreaSt != null ? nombreAreaSt : null;
            Long areaActiva = areaActivaNum != null ? areaActivaNum.longValue() : null;
            Long idInterno = idInternoAreaNum != null ? idInternoAreaNum.longValue() : null;
            String nombreAreaInterna = nombreAreaInternaSt != null ? nombreAreaInternaSt : null;
            // tramite
            Long idTramite = idTramiteNum != null ? idTramiteNum.longValue() : null;
            String nombreTramite = nombreTramiteSt != null ? nombreTramiteSt : null;
            Long tramiteActivo = tramiteActivoNum != null ? tramiteActivoNum.longValue() : null;
            // extension
            Long idExtension = idExtensionNum != null ? idExtensionNum.longValue() : null;
            String extension = extensionSt != null ? extensionSt : null;
            String responsable = responsableSt != null ? responsableSt : null;
            Long extensionActiva = extensionActivaNum != null ? extensionActivaNum.longValue() : null;
            // directorio
            Long directorioActivo = directoroActivoNum != null ? directoroActivoNum.longValue() : null;

            lista.add(new VistaDirectorio(
                    idDirectorio,
                    idArea,
                    nombreArea,
                    areaActiva,
                    idInterno,
                    nombreAreaInterna,
                    idTramite,
                    nombreTramite,
                    tramiteActivo,
                    idExtension,
                    extension,
                    responsable,
                    extensionActiva,
                    directorioActivo));
        }
        return lista;
    }

    @Override
    public List<VistaDirectorio> findTramitesByAreaInactivo(Long idAreaa) {
        List<Object[]> resultados = relacionDirectorioRepository.findTramitesByAreaInactivo(idAreaa);
        List<VistaDirectorio> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            // area
            Number idDirectorioNum = (Number) fila[0];
            Number idAreaNum = (Number) fila[1];
            String nombreAreaSt = (String) fila[2];
            Number areaActivaNum = (Number) fila[3];
            Number idInternoAreaNum = (Number) fila[4];
            String nombreAreaInternaSt = (String) fila[5];
            // tramite
            Number idTramiteNum = (Number) fila[6];
            String nombreTramiteSt = (String) fila[7];
            Number tramiteActivoNum = (Number) fila[8];
            // extension
            Number idExtensionNum = (Number) fila[9];
            String extensionSt = (String) fila[10];
            String responsableSt = (String) fila[11];
            Number extensionActivaNum = (Number) fila[12];
            // directorio
            Number directoroActivoNum = (Number) fila[13];

            // area
            Long idDirectorio = idDirectorioNum != null ? idDirectorioNum.longValue() : null;
            Long idArea = idAreaNum != null ? idAreaNum.longValue() : null;
            String nombreArea = nombreAreaSt != null ? nombreAreaSt : null;
            Long areaActiva = areaActivaNum != null ? areaActivaNum.longValue() : null;
            Long idInterno = idInternoAreaNum != null ? idInternoAreaNum.longValue() : null;
            String nombreAreaInterna = nombreAreaInternaSt != null ? nombreAreaInternaSt : null;
            // tramite
            Long idTramite = idTramiteNum != null ? idTramiteNum.longValue() : null;
            String nombreTramite = nombreTramiteSt != null ? nombreTramiteSt : null;
            Long tramiteActivo = tramiteActivoNum != null ? tramiteActivoNum.longValue() : null;
            // extension
            Long idExtension = idExtensionNum != null ? idExtensionNum.longValue() : null;
            String extension = extensionSt != null ? extensionSt : null;
            String responsable = responsableSt != null ? responsableSt : null;
            Long extensionActiva = extensionActivaNum != null ? extensionActivaNum.longValue() : null;
            // directorio
            Long directorioActivo = directoroActivoNum != null ? directoroActivoNum.longValue() : null;

            lista.add(new VistaDirectorio(
                    idDirectorio,
                    idArea,
                    nombreArea,
                    areaActiva,
                    idInterno,
                    nombreAreaInterna,
                    idTramite,
                    nombreTramite,
                    tramiteActivo,
                    idExtension,
                    extension,
                    responsable,
                    extensionActiva,
                    directorioActivo));
        }
        return lista;
    }

    @Override
    public List<Map<String, Object>> findAllExtensiones() {
        return relacionDirectorioRepository.findAllExtensiones().stream()
                .map(fila -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("idDirectorio", fila[0] != null ? ((Number) fila[0]).longValue() : null);
                    map.put("nombreArea", fila[1] != null ? (String) fila[1] : null);
                    map.put("extension", fila[2] != null ? (String) fila[2] : null);
                    map.put("nombreTramite", fila[3] != null ? (String) fila[3] : null);
                    map.put("responsable", fila[4] != null ? (String) fila[4] : null);
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void reactivateByIdDirectorio(Long idDirectorio) {
        Optional<Directorio> suministro = this.relacionDirectorioRepository.findById(idDirectorio);
        if (suministro.isPresent()) {
            this.relacionDirectorioRepository.reactivateByIdDirectorio(idDirectorio);
        } else {
            throw new RuntimeException("Directorio no encontrado con el id: " + idDirectorio);
        }
    }

    @Override
    public void desactivateByIdDirectorio(Long idDirectorio) {
        Optional<Directorio> suministro = this.relacionDirectorioRepository.findById(idDirectorio);
        if (suministro.isPresent()) {
            this.relacionDirectorioRepository.desactivateByIdDirectorio(idDirectorio);
        } else {
            throw new RuntimeException("Directorio no encontrado con el id: " + idDirectorio);
        }
    }
    
    @Transactional
    public Directorio guardar(DirectorioDTO dto) {

        CatalogoTramite tramite;

        // ✅ EXISTE EL TRÁMITE
        if (dto.getIdTramite() != null) {

            tramite = tramiteRepository.findById(dto.getIdTramite())
                    .orElseThrow(() -> new RuntimeException("Trámite no encontrado"));

        } else {

            // ✅ ES NUEVO TRÁMITE
            tramite = tramiteRepository
                    .findByTramiteIgnoreCase(dto.getNuevoTramite())
                    .orElseGet(() -> {

                        CatalogoTramite nuevo = new CatalogoTramite();

                        nuevo.setTramite(dto.getNuevoTramite());
                        nuevo.setActivo(1);

                        return tramiteRepository.save(nuevo);
                    });
        }

        CatalogoArea area = areaRepository.findById(dto.getIdArea())
                .orElseThrow(() -> new RuntimeException("Área no encontrada"));

        CatalogoExtension extension = extensionRepository.findById(dto.getIdExtension())
                .orElseThrow(() -> new RuntimeException("Extensión no encontrada"));

        Directorio directorio = new Directorio();

        directorio.setCatalogoArea(area);
        directorio.setCatalogoExtension(extension);
        directorio.setCatalogoTramite(tramite);

        directorio.setDescripcion(dto.getDescripcion());
        directorio.setProceso(dto.getProceso());
        directorio.setModalidad(dto.getModalidad());

        directorio.setActivo(1);

        return this.relacionDirectorioRepository.save(directorio);
    }

}
