package com.todocode.proyectobazartecnologico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVenta;
    private LocalDate fecha;
    private Double total;
    @OneToMany
    private List<Producto> listaProductos;
    @ManyToOne
    private Cliente cliente;
}
