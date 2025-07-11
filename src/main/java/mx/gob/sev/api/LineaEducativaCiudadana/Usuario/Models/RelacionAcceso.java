package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_usuarios")
public class RelacionAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;

    @Column(name =  "idEstructura")
    private Long idEstructura;

    @Column(name = "idAreaTramite")
    private Long idAreaTramite;

    @Column(name = "activo")
    private int activo;
    
}
