package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBitacora;

    @Column(name = "entidad")
    private String entidad;

    @Column(name = "idEntidad")
    private int idEntidad;

    @Column(name = "accion")
    private String accion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "activo")
    private int activo;
    
}
