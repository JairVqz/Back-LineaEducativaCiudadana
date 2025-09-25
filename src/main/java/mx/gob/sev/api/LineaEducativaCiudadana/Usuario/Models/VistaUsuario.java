package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VistaUsuario {
    private Long idUsuario;
    private String nombre;
    private String curp;
    private String email;
    private Long idRol;
    private String rol;
    private Long activo;
    private Long idDirectorio;
    private Long idArea;
    private String nombreArea;
    private Long idInternoArea;
    private String nombreAreaInterna;
    private Long idTramite;
    private String nombreTramite;
    private Long idExtension;
    private String extension;
    private String responsable;
}
