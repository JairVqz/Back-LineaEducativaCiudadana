package mx.gob.sev.api.LineaEducativaCiudadana.Solicitud.Models.Llamada;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Column(name = "fecha")
    private LocalDate fecha;

    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "horaInicio")
    private LocalTime horaInicio;

    @JsonFormat(pattern = "HH:mm:ss")
    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "horaTermino")
    private LocalTime horaTermino;

    @Column(name = "duracionMinutos")
    private String duracionMinutos;

    @Column(name = "activo")
    private int activo;

}
