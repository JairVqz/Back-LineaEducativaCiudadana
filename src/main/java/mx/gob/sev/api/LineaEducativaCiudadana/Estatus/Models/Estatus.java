package mx.gob.sev.api.LineaEducativaCiudadana.Estatus.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_estatus")
public class Estatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstatus;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "activo")
    private int activo;

}
