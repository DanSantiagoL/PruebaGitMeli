package com.PrimeraEntidad.controller;

import com.PrimeraEntidad.clases.Producto;
import com.PrimeraEntidad.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @GetMapping("/nombre/{nombre}")
    public Optional<Producto> buscarPorNombre(@PathVariable String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping("/activos")
    public Page<Producto> buscarActivosPorCategoria(
            @RequestParam String categoria,
            Pageable pageable
    ) {
        return productoRepository.findActivos(categoria, pageable);
    }
}