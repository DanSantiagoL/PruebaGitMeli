package com.primeraentidad.service;

import com.primeraentidad.clases.Producto;
import com.primeraentidad.dto.ProductoDTO;
import com.primeraentidad.repository.ProductoRepository;
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
        Producto guardado = repository.save(toEntity(dto));
        return toDTO(guardado);
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
        return repository.findByActivosPaginado(categoria, pageable);
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());

        return toDTO(repository.save(producto));

    }

    private Producto toEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCategoria(dto.getCategoria());
        producto.setPrecio(dto.getPrecio());
        return producto;
    }

    private ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setCategoria(producto.getCategoria());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }
}
