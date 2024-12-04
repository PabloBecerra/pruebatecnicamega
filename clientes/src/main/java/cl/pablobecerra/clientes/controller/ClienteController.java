package cl.pablobecerra.controller;

import cl.pablobecerra.model.Cliente;
import cl.pablobecerra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
/*
    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista de todos los clientes.")
    @GetMapping
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }
*/
    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista de todos los clientes.")
    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        List<Cliente> clientes = clienteRepository.findAll(); // Devuelve todos los clientes
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "clientes 0-" + (clientes.size() - 1) + "/" + clientes.size()); // Agrega el encabezado Content-Range
        return ResponseEntity.ok().headers(headers).body(clientes);
    }

    // Método para obtener un solo cliente por su ID
    @Operation(summary = "Obtener cliente por IDs", description = "Devuelve un cliente por su ID.")
    @GetMapping("/{id}") // Obtener un cliente por su ID
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
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
        cliente.setTelefono(clienteDetails.getTelefono());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setDireccion(clienteDetails.getDireccion());
        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente
    @Operation(summary = "Eliminar cliente", description = "Elimina un cliente.")
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
