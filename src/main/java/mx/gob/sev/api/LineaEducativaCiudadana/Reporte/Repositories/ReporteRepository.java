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

        ISNULL(MIN(horaInicio), CAST('00:00:00' AS TIME)) AS primera_llamada,

        ISNULL(
            SUM(TRY_CAST(duracionMinutos AS DECIMAL(10,2))),
            0
        ) AS total_duracion,

        ISNULL(MAX(horaInicio), CAST('00:00:00' AS TIME)) AS ultima_llamada

    FROM vista_solicitud
    WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
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

    @Query(value
            = """
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

    @Query(value = """
WITH AreasRecursivas AS (

    SELECT
        idArea,
        nombre,
        idInterno,
        nivel
    FROM tbl_catalogoAreas
    WHERE idArea = :idArea

    UNION ALL

    SELECT
        a.idArea,
        a.nombre,
        a.idInterno,
        a.nivel
    FROM tbl_catalogoAreas a
    INNER JOIN AreasRecursivas ar
        ON a.idInterno = ar.idArea
    WHERE a.idArea <> ar.idArea
)

SELECT 
    COUNT(*) AS llamadas_recibidas,

    ISNULL(
        MIN(horaInicio),
        CAST('00:00:00' AS TIME)
    ) AS primera_llamada,

    ISNULL(
        SUM(TRY_CAST(duracionMinutos AS DECIMAL(10,2))),
        0
    ) AS total_duracion,

    ISNULL(
        MAX(horaInicio),
        CAST('00:00:00' AS TIME)
    ) AS ultima_llamada

FROM vista_solicitud
WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
  AND idAreaSolicitud IN (
        SELECT DISTINCT idArea
        FROM AreasRecursivas
  )

OPTION (MAXRECURSION 20)
""", nativeQuery = true)
    List<Object[]> findKpiSupervisor(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin,
            @Param("idArea") Long idArea);

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
        AND idAreaSolicitud = :idArea
        AND DATEPART(HOUR, horaInicio) BETWEEN 8 AND 19
        GROUP BY DATEPART(HOUR, horaInicio)
    )

    SELECT 
        h.hora,
        RIGHT('0' + CAST(h.hora AS VARCHAR), 2) + ':00' AS label,
        ISNULL(d.total, 0) AS total
    FROM horas h
    LEFT JOIN datos d ON h.hora = d.hora
    ORDER BY h.hora
    """, nativeQuery = true)
    List<Object[]> findLlamadasHoraSupervisor(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin,
            @Param("idArea") Long idArea);

    @Query(value = """
    WITH Totales AS (
        SELECT COUNT(*) AS total
        FROM vista_solicitud
        WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
        AND idAreaSolicitud = :idArea
    ),

    TopTramites AS (
        SELECT TOP 5
            tramite,
            COUNT(*) AS cantidad,

            CAST(
                COALESCE(
                    NULLIF((COUNT(*) * 100.0),0)
                    / NULLIF((SELECT total FROM Totales),0),
                0)
            AS DECIMAL(5,2)) AS porcentaje,

            SUM(CASE WHEN idEstatus = 1 THEN 1 ELSE 0 END) AS soliPendientes,
            SUM(CASE WHEN idEstatus = 2 THEN 1 ELSE 0 END) AS soliProceso,
            SUM(CASE WHEN idEstatus = 3 THEN 1 ELSE 0 END) AS soliTerminado

        FROM vista_solicitud

        WHERE CAST(fecha AS DATE) BETWEEN :fecha_inicio AND :fecha_fin
        AND idAreaSolicitud = :idArea

        GROUP BY tramite

        ORDER BY cantidad DESC
    )

    SELECT
        tramite AS nombre,
        porcentaje,
        cantidad,
        soliPendientes,
        soliProceso,
        soliTerminado

    FROM TopTramites
    """, nativeQuery = true)
    List<Object[]> findTopTramitesSupervisor(
            @Param("fecha_inicio") String fecha_inicio,
            @Param("fecha_fin") String fecha_fin,
            @Param("idArea") Long idArea);
}
