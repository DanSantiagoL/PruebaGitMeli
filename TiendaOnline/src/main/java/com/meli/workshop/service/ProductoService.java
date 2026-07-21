package com.meli.workshop.service;

import com.meli.workshop.dto.ProductoDTO;
import com.meli.workshop.exception.ConflictException;
import com.meli.workshop.exception.ProductoNotFoundException;
import com.meli.workshop.model.Producto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public List<ProductoDTO> listar() {
        return productos.stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<Producto> buscar(Long id) {
        return productos.stream()
                .filter(productos -> productos.getId().equals(id))
                .findFirst();
    }

    public ProductoDTO crear(ProductoDTO dto) {
        boolean nombreDuplicado = productos.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(dto.getNombre()));
        if (nombreDuplicado) {
            throw new ConflictException("Ya existe un producto con el nombre: " + dto.getNombre());
        }

        Producto producto = toEntity(dto);
        producto.setId(contadorId.getAndIncrement());
        productos.add(producto);
        return toDTO(producto);
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        return buscar(id).map(producto -> {
            producto.setNombre(dto.getNombre());
            producto.setPrecio(dto.getPrecio().doubleValue());
            return toDTO(producto);
        }).orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public void eliminar(Long id) {
        boolean eliminado = productos.removeIf(productos -> productos.getId().equals(id));
        if (!eliminado) {
            throw new ProductoNotFoundException(id);
        }
    }

    private ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(BigDecimal.valueOf(producto.getPrecio()));
        return dto;
    }

    private Producto toEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio().doubleValue());
        return producto;
    }
}