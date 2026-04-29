package mx.gob.sev.api.LineaEducativaCiudadana.Reporte.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.gob.sev.api.LineaEducativaCiudadana.Usuario.Models.Usuario;

public interface ReporteRepository extends JpaRepository<Usuario, Long> {

    @Query(value = """
                            SELECT 
    COUNT(*) AS llamadas_recibidas,

    ISNULL((
    SELECT TOP 1 horaInicio
    FROM vista_solicitud
    WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
    ORDER BY fecha ASC, horaInicio ASC
    ), CAST('00:00:00' AS TIME)) AS primera_llamada,

    ISNULL(SUM(CAST(duracionMinutos AS INT)), 0) AS total_duracion,

    ISNULL((
        SELECT TOP 1 horaInicio
        FROM vista_solicitud
        WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
        ORDER BY fecha DESC, horaInicio DESC
    ), CAST('00:00:00' AS TIME)) AS ultima_llamada

    FROM vista_solicitud
    WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin;

                        """, nativeQuery = true)
    List<Object[]> findKpi(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin);

    @Query(value = """
                            WITH horas AS (
    SELECT 8 AS hora UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL
    SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL
    SELECT 14 UNION ALL SELECT 15 UNION ALL SELECT 16 UNION ALL
    SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19
    ),
    datos AS (
        SELECT 
            DATEPART(HOUR, horaInicio) AS hora,
            COUNT(*) AS total
        FROM vista_solicitud
        WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
        AND DATEPART(HOUR, horaInicio) BETWEEN 8 AND 19
        GROUP BY DATEPART(HOUR, horaInicio)
    )

    SELECT 
        h.hora,
        RIGHT('0' + CAST(h.hora AS VARCHAR), 2) + ':00' AS label,
        ISNULL(d.total, 0) AS total
    FROM horas h
    LEFT JOIN datos d ON h.hora = d.hora
    ORDER BY h.hora;
    ;

                        """, nativeQuery = true)
    List<Object[]> findLlamadasHora(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin);

    @Query(value = 
  
    """
                            WITH Totales AS (SELECT COUNT(*) AS total FROM [vista_solicitud]
        WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin), 
            TopAreas AS (
                SELECT TOP 5 
                    areaSolicitud ,
                    COUNT(*) AS cantidad, 
                    CAST(COALESCE(NULLIF((COUNT(*) * 100.0),0) / NULLIF((SELECT total FROM Totales),0),0) AS DECIMAL(5,2)) AS porcentaje,
                    SUM(CASE WHEN idEstatus = 1 THEN 1 ELSE 0 END) AS soliPendientes,
                    SUM(CASE WHEN idEstatus = 2 THEN 1 ELSE 0 END) AS soliProceso,
                    SUM(CASE WHEN idEstatus = 3 THEN 1 ELSE 0 END) AS soliTerminado
                FROM [vista_solicitud]
				WHERE CAST(fecha AS DATE) BETWEEN  :fecha_inicio AND :fecha_fin
                GROUP BY areaSolicitud
                ORDER BY cantidad DESC
            )
            SELECT 
                areaSolicitud AS nombre, 
                porcentaje, 
                cantidad, 
                soliPendientes, 
                soliProceso, 
                soliTerminado
            FROM TopAreas;
                        """, nativeQuery = true)
    List<Object[]> findTopAreas(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin);
}
