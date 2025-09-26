package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VistaDirectorio {
    private Long idDirectorio;
    private Long idArea;
    private String nombreArea;
    private Long areaActiva;
    private Long idInternoArea;
    private String nombreAreaInterna;
    private Long idTramite;
    private String nombreTramite;
    private Long tramiteActivo;
    private Long idExtension;
    private String extension;
    private String responsable;
    private Long extensionActiva;
    private Long directorioActivo;
}
