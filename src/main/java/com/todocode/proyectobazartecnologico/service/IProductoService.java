package com.todocode.proyectobazartecnologico.service;

import com.todocode.proyectobazartecnologico.model.Producto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public interface IProductoService {
    String crearProducto(Producto producto);
    Producto buscarProductoPorId(Long idProducto);
    String eliminarProducto(Long idProducto);
    String actualizarProducto(Long idProducto, Producto producto);
    List<Producto> buscarTodosLosProductos();

    List<Producto> cantidadProductosMenorA(Double cantidad);
}
