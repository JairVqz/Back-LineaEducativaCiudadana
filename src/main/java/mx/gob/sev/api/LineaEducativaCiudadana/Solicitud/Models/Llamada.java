package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import java.time.LocalDateTime;

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
@Table(name = "tbl_llamadaSolicitud")
public class Llamada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLlamada;

    @Column(name = "horaInicio")
    private LocalDateTime horaInicio;

    @Column(name = "horaTermino")
    private LocalDateTime horaTermino;

    @Column(name = "duracionMinutos")
    private String duracionMinutos;

    @Column(name = "activo")
    private int activo;

}
