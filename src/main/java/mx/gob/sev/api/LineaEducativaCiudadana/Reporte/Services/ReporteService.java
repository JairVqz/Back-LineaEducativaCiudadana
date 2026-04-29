package mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Services;

import java.util.List;

import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.KpiModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.LlamadasHoraModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.TopAreasModel;

public interface ReporteService {

    byte[] generarReport(String reportName, String fechaInicio, String fechaFin) throws Exception;

    List<KpiModel> findKpi(String fecha_inicio, String fecha_fin);

    List<LlamadasHoraModel> findLlamadasHora(String fecha_inicio, String fecha_fin);

    List<TopAreasModel> findTopAreas(String fecha_inicio, String fecha_fin);

}
