package com.todocode.proyectobazartecnologico.service;

import com.todocode.proyectobazartecnologico.model.Cliente;
import com.todocode.proyectobazartecnologico.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCliente implements IServiceCliente{
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public String crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return "Cliente creado correctamente";
    }

    @Override
    public Cliente buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));
    }

    @Override
    public List<Cliente> buscarTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public String eliminarCliente(Long idCliente) {
        return clienteRepository.findById(idCliente)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return "Cliente eliminado correctamente";
                })
                .orElse("Cliente no encontrado");
    }

    @Override
    public String actualizarCliente(Long idCliente, Cliente cliente) {
        return clienteRepository.findById(idCliente)
                .map(existingCliente -> {
                    existingCliente.setNombre(cliente.getNombre());
                    existingCliente.setApellido(cliente.getApellido());
                    existingCliente.setDni(cliente.getDni());
                    clienteRepository.save(existingCliente);
                    return "Cliente actualizado correctamente";
                })
                .orElse("Cliente no encontrado");
    }
}
