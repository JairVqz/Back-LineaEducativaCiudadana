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

public class KpiModel {

    private int llamadas_recibidas;
    private LocalTime primera_llamada;
    private int total_duracion;
    private LocalTime ultima_llamada;
}
