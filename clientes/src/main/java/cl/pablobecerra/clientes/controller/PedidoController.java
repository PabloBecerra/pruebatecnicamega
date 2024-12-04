package cl.pablobecerra.controller;

import cl.pablobecerra.model.Pedido;
import cl.pablobecerra.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Obtener todos los pedidos
    @GetMapping
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }

    // Crear un nuevo pedido
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Actualizar un pedido
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetails) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        pedido.setDescripcion(pedidoDetails.getDescripcion());
        pedido.setTotal(pedidoDetails.getTotal());
        pedido.setCliente(pedidoDetails.getCliente());
        return pedidoRepository.save(pedido);
    }

    // Eliminar un pedido
    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
}
