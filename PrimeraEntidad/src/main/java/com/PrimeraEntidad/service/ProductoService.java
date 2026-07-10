package com.PrimeraEntidad.service;

import com.PrimeraEntidad.clases.Producto;
import com.PrimeraEntidad.dto.ProductoDTO;
import com.PrimeraEntidad.repository.ProductoRepository;
import org.springframework.stereotype.Service;

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
}
