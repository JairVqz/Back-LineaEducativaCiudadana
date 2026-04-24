package mx.gob.sev.api.LineaEducativaCiudadana.Reportes;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportService {

    private final DataSource dataSource; 

    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public byte [] generarReport(String reportName) throws Exception {
        //Cargar el reporte
        InputStream reportStream = this.getClass().getResourceAsStream("/Reportes/" + reportName + ".jasper");
        Map<String, Object> params = null;
        //Llenar el reporte
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, dataSource.getConnection());
        //Exporta a un reporte de tipo PDF
        return JasperExportManager.exportReportToPdf(jasperPrint);
    
    }

}
