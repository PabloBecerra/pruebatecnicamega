package cl.pablobecerra.controller;

import cl.pablobecerra.model.Cliente;
import cl.pablobecerra.model.Pedido;
import cl.pablobecerra.repository.PedidoRepository;
import cl.pablobecerra.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import java.math.BigDecimal;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    // Obtener todos los pedidos
/*
    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }
*/
    @Operation(summary = "Obtener todos los pedidos", description = "Devuelve todos los pedidos.")
    @GetMapping
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "pedidos 0-" + (pedidos.size() - 1) + "/" + pedidos.size());
        return ResponseEntity.ok().headers(headers).body(pedidos);
    }
    
    @Operation(summary = "Obtener pedido por ID", description = "Obtiene un pedido según el ID entregado.")
    @GetMapping("/{id}") // Obtener un pedido por su ID
    public Pedido getPedidoById(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }
    
    // Crear un nuevo pedido
    @Operation(summary = "Crear Pedido", description = "Crea un pedido.")
    @PostMapping
    public Pedido createPedido(@RequestBody Map<String, Object> request) {
        // Verificar si el campo 'cliente' existe y contiene 'id'
        Map<String, Object> clienteMap = (Map<String, Object>) request.get("cliente");
        if (clienteMap == null || clienteMap.get("id") == null) {
            throw new RuntimeException("El pedido debe incluir un cliente válido.");
        }

        Long idCliente = ((Number) clienteMap.get("id")).longValue();

        // Verificar que el cliente existe en la base de datos
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + idCliente));

        // Crear el pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDescripcion((String) request.get("descripcion"));
        pedido.setTotal(new BigDecimal(request.get("total").toString()));

        return pedidoRepository.save(pedido);
    }


    // Actualizar un pedido
    @Operation(summary = "Actualizar pedido", description = "Actualiza un pedido.")
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setDescripcion(pedidoDetails.getDescripcion());
        pedido.setTotal(pedidoDetails.getTotal());
        pedido.setCliente(pedidoDetails.getCliente());
        return pedidoRepository.save(pedido);
    }

    // Eliminar un pedido
    @Operation(summary = "Eliminar pedido", description = "Elimina un pedido.")
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
