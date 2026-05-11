package mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models;

import lombok.Data;

@Data

public class DirectorioDTO {

    private Long idArea;
    private Long idExtension;

    // Si existe trámite
    private Long idTramite;

    // Si es nuevo trámite
    private String nuevoTramite;

    private String descripcion;
    private String proceso;
    private String modalidad;

}
