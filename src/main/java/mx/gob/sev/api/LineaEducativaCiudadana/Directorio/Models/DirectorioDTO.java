package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import lombok.Data;

@Data
public class DirectorioDTO {

    private Long idArea;

    // EXISTENTE
    private Long idExtension;

    // NUEVA
    private String nuevaExtension;
    private String responsable;

    // EXISTENTE
    private Long idTramite;

    // NUEVO
    private String nuevoTramite;

    private String descripcion;
    private String proceso;
    private String modalidad;

}
