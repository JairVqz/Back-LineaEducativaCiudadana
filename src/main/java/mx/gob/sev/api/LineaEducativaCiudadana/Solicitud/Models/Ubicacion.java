package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "cct")
    private int nivelCct;

    @Column(name = "nombrePlantel", columnDefinition = "TEXT")
    private String nombrePlantel;

    @Column(name = "nivelEducativo")
    private String nivelEducativo;

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
