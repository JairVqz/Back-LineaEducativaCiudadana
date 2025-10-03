package mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Models.Bitacora;
import mx.gob.sev.api.LineaEducativaCiudadana.Bitacora.Services.BitacoraImpl;

@RestController
@RequestMapping("api/Bitacora")
@CrossOrigin("*")

public class BitacoraController {

    @Autowired
    private BitacoraImpl bitacoraImpl;

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public List<Bitacora> findAll() {
        return this.bitacoraImpl.findAll();
    }

    @GetMapping("/findAllActiveByRange")
    @Transactional(readOnly = true)
    public ResponseEntity<List<Object[]>> findAllActiveByRange(
            @RequestParam String fecha_inicio,
            @RequestParam String fecha_fin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime fechaInicio = LocalDate.parse(fecha_inicio, formatter).atStartOfDay(); // 2025-09-30T00:00:00
        LocalDateTime fechaFin = LocalDate.parse(fecha_fin, formatter).atTime(23, 59, 59); // 2025-10-02T23:59:59

        List<Object[]> resultados = bitacoraImpl.findAllActiveByRange(fechaInicio, fechaFin);

        if (resultados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(resultados);
    }

    @PostMapping
    @Transactional
    public Bitacora save(@RequestBody Bitacora bitacora) {
        return this.bitacoraImpl.save(bitacora);
    }

}
