package com.todocode.proyectobazartecnologico.service;

import com.todocode.proyectobazartecnologico.dto.MayorVenta;
import com.todocode.proyectobazartecnologico.model.Producto;
import com.todocode.proyectobazartecnologico.model.Venta;
import com.todocode.proyectobazartecnologico.repository.IProductoRepository;
import com.todocode.proyectobazartecnologico.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class VentaService implements IVentaService {
    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public String crearVenta(Venta venta) {
        ventaRepository.save(venta);
        return "Venta creada correctamente";
    }

    @Override
    public String eliminarVenta(Long idVenta) {
        return ventaRepository.findById(idVenta)
                .map(venta -> {
                    ventaRepository.delete(venta);
                    return "Venta eliminada correctamente";
                })
                .orElse("Venta no encontrada");
    }

    @Override
    public String actualizarVenta(Long idVenta, Venta venta) {
        return ventaRepository.findById(idVenta)
                .map(existingVenta -> {
                    existingVenta.setFecha(venta.getFecha());
                    existingVenta.setTotal(venta.getTotal());
                    existingVenta.setCliente(venta.getCliente());
                    existingVenta.setListaProductos(venta.getListaProductos());
                    ventaRepository.save(existingVenta);
                    return "Venta actualizada correctamente";
                })
                .orElse("Venta no encontrada");
    }

    @Override
    public Venta buscarVentaPorId(Long idVenta) {
        return ventaRepository.findById(idVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + idVenta));
    }

    @Override
    public List<Venta> buscarTodasLasVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public List<Venta> buscarVentasPorFecha(LocalDate fecha) {
        return ventaRepository.findVentaByFecha(fecha);
    }

    @Override
    public Venta buscarVentaMayorTotal() {
        return ventaRepository.findTopByOrderByTotalDesc();
    }

    @Override
    public Map<Double, Double> obtenerSumatoriaMontoYCantidadDeVentasPorFecha(LocalDate fecha) {
        List<Venta> ventas = this.buscarVentasPorFecha(fecha);
        double totalMonto = ventas.stream()
                .mapToDouble(Venta::getTotal)
                .sum();
        double totalCantidad = ventas.size();
        return Map.of(totalMonto, totalCantidad);
    }

    @Override
    public MayorVenta buscarVentaMasAlta() {
        Venta venta = ventaRepository.findTopByOrderByTotalDesc();
        MayorVenta mayorVenta = new MayorVenta();
        if (venta != null) {
            mayorVenta.setCodigoVenta(venta.getIdVenta());
            mayorVenta.setNombreCliente(venta.getCliente().getNombre());
            mayorVenta.setApellidoCliente(venta.getCliente().getApellido());
            mayorVenta.setTotalProductos(venta.getListaProductos().size());
        }
        return mayorVenta;
    }

    @Override
    public List<Producto> buscarProductosPorVenta(Long idVenta) {
        return ventaRepository.findById(idVenta)
                .map(Venta::getListaProductos)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con ID: " + idVenta));
    }
}
