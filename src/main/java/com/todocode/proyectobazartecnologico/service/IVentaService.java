package com.todocode.proyectobazartecnologico.service;

import com.todocode.proyectobazartecnologico.dto.MayorVenta;
import com.todocode.proyectobazartecnologico.model.Producto;
import com.todocode.proyectobazartecnologico.model.Venta;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IVentaService {
    String crearVenta(Venta venta);

    String eliminarVenta(Long idVenta);

    String actualizarVenta(Long idVenta, Venta venta);

    Venta buscarVentaPorId(Long idVenta);

    List<Venta> buscarTodasLasVentas();

    List<Venta> buscarVentasPorFecha(LocalDate fecha);
    Venta buscarVentaMayorTotal();
    Map<Double, Double> obtenerSumatoriaMontoYCantidadDeVentasPorFecha(LocalDate fecha);

    MayorVenta buscarVentaMasAlta();

    List<Producto> buscarProductosPorVenta(Long idVenta);
}
