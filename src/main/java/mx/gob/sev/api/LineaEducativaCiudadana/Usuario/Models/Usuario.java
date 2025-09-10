package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "curp")
    private String curp;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idAcceso")
    private RelacionAcceso relacionAcceso;

    @Column(name = "activo")
    private int activo;

}
