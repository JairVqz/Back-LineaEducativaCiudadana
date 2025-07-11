package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_ubicacionSolicitud")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;

    @Column(name = "folio")
    private String folio;

    @Column(name = "cct")
    private int nivelCct;

    @Column(name = "nombrePlantel", columnDefinition = "TEXT")
    private String nombrePlantel;

    @Column(name = "nombreDirector")
    private String nombreDirector;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "direccionCct", columnDefinition = "TEXT")
    private String direccionCct;

    @Column(name = "activo")
    private int activo;
    
}
