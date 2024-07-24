
package com.tienda.tienda.service;

import com.tienda.tienda.domain.Producto;
import java.util.List;


public interface ProductoService {
  // Se obtiene un listado de Productos en un List
    public List<Producto> getProductos(boolean activos);
    
   // Se obtiene un Producto, a partir del id de un Producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo Producto si el id del Producto esta vacío
    // Se actualiza un Producto si el id del Producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el Producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
   public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
   public List<Producto> findByDescripcionContainingIgnoreCase(String texto);
 //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
//Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
    public List<Producto> findByExistenciasBetweenOrderByDescripcion(int existenciasInf, int existenciasSup);
}
