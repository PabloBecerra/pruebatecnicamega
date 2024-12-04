package cl.pablobecerra.controller;

import cl.pablobecerra.model.Cliente;
import cl.pablobecerra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista de todos los clientes.")
    @GetMapping
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    // Crear un nuevo cliente
    @Operation(summary = "Crear cliente", description = "Crea un cliente.")
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    @Operation(summary = "Actualizar cliente", description = "Actualiza un cliente.")
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setEmail(clienteDetails.getDireccion());
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente
    @Operation(summary = "Eliminar cliente", description = "Elimina un cliente.")
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
