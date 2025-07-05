package mx.gob.sev.api.LineaEducativaCiudadana.Prioridad.Models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_prioridad")
public class Prioridad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrioridad;

    @Column(name = "prioridad")
    private String prioridad;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

}