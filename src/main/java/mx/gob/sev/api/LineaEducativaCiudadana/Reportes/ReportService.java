package mx.gob.sev.api.LineaEducativaCiudadana.Reportes;

import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportService {

    private final DataSource dataSource;

    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public byte[] generarReport(String reportName, String fechaInicio, String fechaFin) throws Exception {

        InputStream reportStream = this.getClass()
                .getResourceAsStream("/Reportes/" + reportName + ".jasper");

        if (reportStream == null) {
            throw new RuntimeException("No se encontró el .jasper");
        }

        Map<String, Object> params = new HashMap<>();

        params.put("fecha_inicio", Date.valueOf(fechaInicio));
        params.put("fecha_fin", Date.valueOf(fechaFin));

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                reportStream,
                params,
                dataSource.getConnection()
        );

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
