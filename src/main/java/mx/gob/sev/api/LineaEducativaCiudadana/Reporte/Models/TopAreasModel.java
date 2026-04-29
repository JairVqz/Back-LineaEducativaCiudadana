package mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TopAreasModel {

    private String nombre;
    private Double porcentaje;
    private int cantidad;
    private int soliPendientes;
    private int soliProceso;
    private int soliTerminado;
}
