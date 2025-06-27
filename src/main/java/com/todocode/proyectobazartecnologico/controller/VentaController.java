package com.todocode.proyectobazartecnologico.controller;

import com.todocode.proyectobazartecnologico.model.Producto;
import com.todocode.proyectobazartecnologico.model.Venta;
import com.todocode.proyectobazartecnologico.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    @GetMapping("/ventas/listar")
    public List<Venta> getVentas() {
        return ventaService.buscarTodasLasVentas();
    }

    @PostMapping("/venta/crear")
    public String createVenta(@RequestBody Venta venta) {
        return ventaService.crearVenta(venta);
    }

    @GetMapping("/venta/encontrar/{id}")
    public Venta findVentaById(@PathVariable Long id) {
        return ventaService.buscarVentaPorId(id);
    }

    @DeleteMapping("/venta/eliminar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        return ventaService.eliminarVenta(id);
    }

    @PutMapping("/venta/editar/{id}")
    public String updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return ventaService.actualizarVenta(id, venta);
    }

    @GetMapping("/venta/productos/{codigoVenta}")
    public List<Producto> getProductosByCodigoVenta(@PathVariable Long codigoVenta) {
        return ventaService.buscarProductosPorVenta(codigoVenta);
    }

    @GetMapping("/ventas/fecha/{fecha}")
    public Map<Double, Double> getVentasByFecha(@PathVariable LocalDate fecha) {
        return ventaService.obtenerSumatoriaMontoYCantidadDeVentasPorFecha(fecha);
    }

    @GetMapping("/ventas/mayor-venta")
    public Venta getVentaMayorTotal() {
        return ventaService.buscarVentaMayorTotal();
    }

}
