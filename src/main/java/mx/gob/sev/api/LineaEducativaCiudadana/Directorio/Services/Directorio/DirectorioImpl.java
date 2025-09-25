package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Services.Directorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.VistaDirectorio;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Repositories.DirectorioRepository;

@Service
public class DirectorioImpl implements DirectorioService {

    @Autowired
    private DirectorioRepository relacionDirectorioRepository;

    @Override
    public List<Directorio> findAll() {
        return (List<Directorio>) this.relacionDirectorioRepository.findAll();
    }

    @Override
    public Directorio save(Directorio relacionDirectorio) {
        return this.relacionDirectorioRepository.save(relacionDirectorio);
    }

    @Override
    public List<VistaDirectorio> findAllVistaD() {
        List<Object[]> resultados = relacionDirectorioRepository.findAllVistaD();
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
            Number tramitePublicoNum = (Number) fila[8];
            Number tramiteActivoNum = (Number) fila[9];
            // extension
            Number idExtensionNum = (Number) fila[10];
            String extensionSt = (String) fila[11];
            String responsableSt = (String) fila[12];
            Number extensionActivaNum = (Number) fila[13];
            // directorio
            Number directoroActivoNum = (Number) fila[14];

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
            Long tramitePublico = tramitePublicoNum != null ? tramitePublicoNum.longValue() : null;
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
                    tramitePublico,
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
                    map.put("idArea", fila[1] != null ? ((Number) fila[1]).longValue() : null);
                    map.put("nombreArea", fila[2] != null ? (String) fila[2] : null);
                    map.put("extension", fila[3] != null ? (String) fila[3] : null);
                    map.put("responsable", fila[4] != null ? (String) fila[4] : null);
                    return map;
                })
                .collect(Collectors.toList());
    }

}
