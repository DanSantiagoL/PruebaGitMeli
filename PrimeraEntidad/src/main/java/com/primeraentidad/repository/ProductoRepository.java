package com.primeraentidad.repository;

import com.primeraentidad.clases.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoria(String categoria);

    Optional<Producto> findByNombre(String nombre);

    Page<Producto> findByActivosPaginado(String categoria, Pageable pageable);
}
