package com.PrimeraEntidad.service;

import com.PrimeraEntidad.clases.Producto;
import com.PrimeraEntidad.dto.ProductoDTO;
import com.PrimeraEntidad.repository.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository repository;

    public ProductoService (ProductoRepository repository) {
        this.repository = repository;
    }

    public ProductoDTO crear(ProductoDTO dto){
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());

        Producto guardado = repository.save(producto);

        ProductoDTO resultado = new ProductoDTO();
        resultado.setNombre(guardado.getNombre());
        resultado.setCategoria(guardado.getCategoria());
        resultado.setPrecio(guardado.getPrecio());

        return resultado;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return repository.findByCategoria(categoria);
    }

    public Optional<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public Page<Producto> buscarActivos(String categoria, Pageable pageable) {
        return repository.findActivos(categoria, pageable);
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());

        Producto guardado = repository.save(producto);

        ProductoDTO resultado = new ProductoDTO();
        resultado.setNombre(guardado.getNombre());
        resultado.setCategoria(guardado.getCategoria());
        resultado.setPrecio(guardado.getPrecio());

        return resultado;
    }
}
