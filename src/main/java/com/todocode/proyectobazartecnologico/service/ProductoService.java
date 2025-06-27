package com.todocode.proyectobazartecnologico.service;

import com.todocode.proyectobazartecnologico.model.Producto;
import com.todocode.proyectobazartecnologico.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public String crearProducto(Producto producto) {
        productoRepository.save(producto);
        return "Producto creado correctamente";
    }

    @Override
    public Producto buscarProductoPorId(Long idProducto) {
        return productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + idProducto));
    }

    @Override
    public String eliminarProducto(Long idProducto) {
        return productoRepository.findById(idProducto)
                .map(producto -> {
                    productoRepository.delete(producto);
                    return "Producto eliminado correctamente";
                })
                .orElse("Producto no encontrado");
    }

    @Override
    public String actualizarProducto(Long idProducto, Producto producto) {
        return productoRepository.findById(idProducto)
                .map(existingProducto -> {
                    existingProducto.setNombre(producto.getNombre());
                    existingProducto.setCosto(producto.getCosto());
                    existingProducto.setCantidadDisponible(producto.getCantidadDisponible());
                    existingProducto.setMarca(producto.getMarca());
                    productoRepository.save(existingProducto);
                    return "Producto actualizado correctamente";
                })
                .orElse("Producto no encontrado");
    }

    @Override
    public List<Producto> buscarTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> cantidadProductosMenorA(Double cantidad) {
        return productoRepository.findAllByCantidadDisponible(cantidad);
    }
}
