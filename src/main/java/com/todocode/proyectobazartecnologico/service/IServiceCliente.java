package com.todocode.proyectobazartecnologico.service;

import com.todocode.proyectobazartecnologico.model.Cliente;

import java.util.List;

public interface IServiceCliente {
    String crearCliente(Cliente cliente);
    Cliente buscarClientePorId(Long idCliente);
    List<Cliente> buscarTodosLosClientes();
    String eliminarCliente(Long idCliente);
    String actualizarCliente(Long idCliente, Cliente cliente);
}
