package mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Services;

import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.KpiModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.LlamadasHoraModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.TopAreasModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Repositories.ReporteRepository;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReporteImpl implements ReporteService {

    private final DataSource dataSource;

    public ReporteImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public byte[] generarReport(String reportName, String fechaInicio, String fechaFin) throws Exception {

        InputStream reportStream = this.getClass()
                .getResourceAsStream("/Reportes/" + reportName + ".jasper");

        if (reportStream == null) {
            throw new RuntimeException("No se encontró el .jasper");
        }

        Map<String, Object> params = new HashMap<>();

        params.put("fecha_inicio", Date.valueOf(fechaInicio));
        params.put("fecha_fin", Date.valueOf(fechaFin));

        InputStream membrete = getClass().getResourceAsStream("/Images/membrete.png");
        params.put("membrete", membrete);

        InputStream lec = getClass().getResourceAsStream("/Images/LEC.png");
        params.put("lec", lec);

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                reportStream,
                params,
                dataSource.getConnection()
        );

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    @Override
    public List<KpiModel> findKpi(String fecha_inicio, String fecha_fin) {
        List<Object[]> resultados = reporteRepository.findKpi(fecha_inicio, fecha_fin);

        List<KpiModel> lista = new ArrayList<>();

        for (Object[] fila : resultados) {

            int llamadas_recibidas = fila[0] != null ? ((Number) fila[0]).intValue() : 0;
            LocalTime primera_llamada = fila[1] != null
                    ? ((java.sql.Time) fila[1]).toLocalTime()
                    : null;

            LocalTime ultima_llamada = fila[3] != null
                    ? ((java.sql.Time) fila[3]).toLocalTime()
                    : null;
            int total_duracion = fila[2] != null ? ((Number) fila[2]).intValue() : 0;

            KpiModel kpi = new KpiModel(
                    llamadas_recibidas,
                    primera_llamada,
                    total_duracion,
                    ultima_llamada
            );
            lista.add(kpi);
        }
        return lista;

    }

    @Override
    public List<LlamadasHoraModel> findLlamadasHora(String fecha_inicio, String fecha_fin) {
        List<Object[]> resultados = reporteRepository.findLlamadasHora(fecha_inicio, fecha_fin);
        List<LlamadasHoraModel> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            int hora = fila[0] != null ? ((Number) fila[0]).intValue() : 0;
            String label = fila[1] != null ? (String) fila[1] : "";
            int total = fila[2] != null ? ((Number) fila[2]).intValue() : 0;

            LlamadasHoraModel llamadaHora = new LlamadasHoraModel(hora, label, total);
            lista.add(llamadaHora);
        }
        return lista;
    }

    @Override
    public List<TopAreasModel> findTopAreas(String fecha_inicio, String fecha_fin) {
        List<Object[]> resultados = reporteRepository.findTopAreas(fecha_inicio, fecha_fin);
        List<TopAreasModel> lista = new ArrayList<>();
        for (Object[] fila : resultados) {
            String area = fila[0] != null ? (String) fila[0] : "";
            double porcentaje = fila[1] != null ? ((Number) fila[1]).doubleValue() : 0.0;
            int cantidad = fila[2] != null ? ((Number) fila[2]).intValue() : 0;
            int soliPendientes = fila[3] != null ? ((Number) fila[3]).intValue() : 0;
            int soliProceso = fila[4] != null ? ((Number) fila[4]).intValue() : 0;
            int soliTerminado = fila[5] != null ? ((Number) fila[5]).intValue() : 0;

            TopAreasModel topArea = new TopAreasModel(area, porcentaje, cantidad, soliPendientes, soliProceso, soliTerminado);
            lista.add(topArea);
        }
        return lista;
    }
}
