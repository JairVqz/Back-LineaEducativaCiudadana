package mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.gob.sev.api.LineaEducativaCiudadana.Directorio.Models.Directorio;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_relacionAcceso")
public class RelacionAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAcceso;

    @ManyToOne
    @JoinColumn(name = "idDirectorio")
    private Directorio directorio;

    @Column(name = "activo")
    private int activo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @JsonBackReference
    private Usuario usuario;

}
