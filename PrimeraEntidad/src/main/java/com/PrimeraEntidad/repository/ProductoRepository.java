package com.PrimeraEntidad.repository;

import com.PrimeraEntidad.clases.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoria(String categoria);

    Optional<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.categoria = :cat")
    Page<Producto> findActivos(@Param("cat") String cat, Pageable pageable);
}
