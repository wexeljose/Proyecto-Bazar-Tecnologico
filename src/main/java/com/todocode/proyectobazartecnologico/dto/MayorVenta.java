package com.todocode.proyectobazartecnologico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MayorVenta {
    //Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el
    //apellido del cliente de la venta con el monto más alto de todas.
    private Long codigoVenta;
    private int totalProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
