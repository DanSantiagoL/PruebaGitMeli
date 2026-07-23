package com.primeraentidad.clases;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@ToString
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    private String categoria;
    private BigDecimal precio;

    public Producto(){
    }
    public Producto(String nombre, String categoria, BigDecimal precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(nombre, producto.nombre) &&
                Objects.equals(categoria, producto.categoria) &&
                Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, categoria, precio);
    }
}
