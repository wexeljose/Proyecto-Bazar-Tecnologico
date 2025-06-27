package com.todocode.proyectobazartecnologico.controller;

import com.todocode.proyectobazartecnologico.model.Cliente;
import com.todocode.proyectobazartecnologico.service.IServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IServiceCliente serviceCliente;

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente) {
        return serviceCliente.crearCliente(cliente);
    }

    @GetMapping("/clientes/buscar/{idCliente}")
    public Cliente buscarClientePorId(@PathVariable Long idCliente) {
        return serviceCliente.buscarClientePorId(idCliente);
    }

    @GetMapping("/clientes")
    public List<Cliente> buscarTodosLosClientes() {
        return serviceCliente.buscarTodosLosClientes();
    }

    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public String eliminarCliente(@PathVariable Long idCliente) {
        return serviceCliente.eliminarCliente(idCliente);
    }

    @PutMapping("/clientes/actualizar/{idCliente}")
    public String actualizarCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        return serviceCliente.actualizarCliente(idCliente, cliente);
    }
}
