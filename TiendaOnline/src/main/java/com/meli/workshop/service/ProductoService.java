package com.meli.workshop.service;

import com.meli.workshop.exception.ConflictException;
import com.meli.workshop.exception.ProductoNotFoundException;
import com.meli.workshop.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    public List<Producto> listar() {
        return productos;
    }

    public Optional<Producto> buscar(Long id) {
        return productos.stream()
                .filter(productos -> productos.getId().equals(id))
                .findFirst();
    }

    public Producto crear(Producto producto) {
        boolean nombreDuplicado = productos.stream()
                .anyMatch(productos -> productos.getNombre().equalsIgnoreCase(productos.getNombre()));
        if (nombreDuplicado) {
            throw new ConflictException("Ya existe un producto con el nombre: " + producto.getNombre());
        }

        producto.setId(contadorId.getAndIncrement());
        productos.add(producto);
        return producto;
    }

    public Producto actualizar(Long id, Producto datos) {
        return buscar(id).map(productos -> {
            productos.setNombre(datos.getNombre());
            productos.setPrecio(datos.getPrecio());
            return productos;
        }).orElseThrow(() -> new ProductoNotFoundException(id));
    }

    public void eliminar(Long id) {
        boolean eliminado = productos.removeIf(productos -> productos.getId().equals(id));
        if (!eliminado) {
            throw new ProductoNotFoundException(id);
        }
    }
}