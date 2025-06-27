package com.todocode.proyectobazartecnologico.repository;

import com.todocode.proyectobazartecnologico.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    List<Venta> findVentaByFecha(LocalDate fecha);

    Venta findTopByOrderByTotalDesc();
}
