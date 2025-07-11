package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "folio")
    private String folio;

    @Column(name = "horaInicio")
    private LocalDateTime horaInicio;

    @Column(name = "horaTermino")
    private LocalDateTime horaTermino;

    @Column(name = "duracionMinutos")
    private String duracionMinutos;

    @Column(name = "activo")
    private int activo;

}
