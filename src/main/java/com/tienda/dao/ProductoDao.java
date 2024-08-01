package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);

    // Métodos JPQL
    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.descripcion ASC")
    List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    // Métodos nativos
    @Query(value = "SELECT * FROM producto WHERE producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC", nativeQuery = true)
    List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    List<Producto> findByExistenciasBetweenOrderByDescripcion(int existenciasInf, int existenciasSup);

    // Nuevo método para encontrar productos por estado (activo/inactivo)
    List<Producto> findByActivoOrderByDescripcion(boolean activo);
}
