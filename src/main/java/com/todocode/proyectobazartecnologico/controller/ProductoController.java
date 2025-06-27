package com.todocode.proyectobazartecnologico.controller;

import com.todocode.proyectobazartecnologico.model.Producto;
import com.todocode.proyectobazartecnologico.service.IProductoService;
import com.todocode.proyectobazartecnologico.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoService.buscarTodosLosProductos();
    }

    @PostMapping("/producto/crear")
    public String crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @GetMapping("/producto/buscar/{idProducto}")
    public Producto buscarProductoPorId(@PathVariable Long idProducto) {
        return productoService.buscarProductoPorId(idProducto);
    }

    @DeleteMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(@PathVariable Long idProducto) {
        return productoService.eliminarProducto(idProducto);
    }

    @PutMapping("/producto/editar/{idProducto}")
    public String actualizarProducto(@PathVariable Long idProducto, @RequestBody Producto producto) {
        return productoService.actualizarProducto(idProducto, producto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> cantidadProductosMenorA() {
        return productoService.cantidadProductosMenorA(5D);
    }
}
