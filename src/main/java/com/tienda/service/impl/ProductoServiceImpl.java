package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByDescripcionContainingIgnoreCase(String texto) {
        return productoDao.findByDescripcionContainingIgnoreCase(texto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByExistenciasBetweenOrderByDescripcion(int existenciasInf, int existenciasSup) {
        return productoDao.findByExistenciasBetweenOrderByDescripcion(existenciasInf, existenciasSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByActivoOrderByDescripcion(boolean activo) {
        return productoDao.findByActivoOrderByDescripcion(activo);
    }

    @Override
    public List<Producto> findByCategoriaAndInStock(Categoria categoria, boolean inStock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
