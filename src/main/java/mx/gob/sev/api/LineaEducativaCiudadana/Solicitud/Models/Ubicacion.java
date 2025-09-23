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
    private String cct;

    @Column(name = "nombrePlantel", columnDefinition = "TEXT")
    private String nombrePlantel;

    @Column(name = "nivelEducativo")
    private String nivelEducativo;

    @Column(name = "sostenimiento")
    private String sostenimiento;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "tipoEducacion")
    private String tipoEducacion;

    @Column(name = "activo")
    private int activo;
    
}
