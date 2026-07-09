package com.meli.workshop.controller;

import com.meli.workshop.dto.ProductoDTO;
import com.meli.workshop.exception.ProductoNotFoundException;
import com.meli.workshop.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meli.workshop.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        // Ya no maneja el 404 aquí — si el producto no existe, el service lanza
        // ProductoNotFoundException y el GlobalExceptionHandler devuelve la respuesta estándar.
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto creado = service.crear(producto);
        URI location = URI.create("/api/productos/" + creado.getId());
        return ResponseEntity.created(location).body(creado);
    }

    @PostMapping("/dto")
    public ResponseEntity<ProductoDTO> crearDesdeDTO(@Valid @RequestBody ProductoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto datos) {

        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}