package com.todocode.proyectobazartecnologico.repository;

import com.todocode.proyectobazartecnologico.model.Producto;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findAllByCantidadDisponible(Double cantidadDisponible);

    List<Producto> findAllByCantidadDisponibleLessThan(Double cantidadDisponible);


}
