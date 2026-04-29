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

public class LlamadasHoraModel {

    private int hora;
    private String label;
    private int total;
}
