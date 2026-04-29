package mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.KpiModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.LlamadasHoraModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Models.TopAreasModel;
import mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Services.ReporteImpl;

@RestController
@RequestMapping("/api/Reportes")
@CrossOrigin("*")

public class ReporteController {

    private ReporteImpl reportService;

    public ReporteController(ReporteImpl reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/reportePeriodo")
    public ResponseEntity<byte[]> generarReporte(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {
        try {
            byte[] report = reportService.generarReport(
                    "reportePeriodo",
                    fechaInicio,
                    fechaFin
            );

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");

            String fechaInicioFmt = LocalDate.parse(fechaInicio).format(formatter);
            String fechaFinFmt = LocalDate.parse(fechaFin).format(formatter);

            String fileName = "LEC_ReportePeriodo_"
                    + fechaInicioFmt + "_"
                    + fechaFinFmt + ".pdf";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=" + fileName);

            return new ResponseEntity<>(report, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/kpi")
    public ResponseEntity<List<KpiModel>> findKpi(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {

        List<KpiModel> kpi = this.reportService.findKpi(fechaInicio, fechaFin);
        if (kpi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(kpi);
    }

    @GetMapping("/llamadasHora")
    public ResponseEntity<List<LlamadasHoraModel>> findLlamadasHora(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {

        List<LlamadasHoraModel> llamadasHora = this.reportService.findLlamadasHora(fechaInicio, fechaFin);
        if (llamadasHora.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(llamadasHora);
    }

    @GetMapping("/topAreas")
    public ResponseEntity<List<TopAreasModel>> findTopAreas(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {
        List<TopAreasModel> topAreas = this.reportService.findTopAreas(fechaInicio, fechaFin);
        if (topAreas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(topAreas);
    }
}
