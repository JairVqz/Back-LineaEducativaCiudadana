package mx.gob.sev.api.LineaEducativaCiudadana.Barrera.Models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_barrera")
public class Barrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ejecutado")
    private int nombre;

    @Column(name = "fecha")
    private LocalDate fecha;
}