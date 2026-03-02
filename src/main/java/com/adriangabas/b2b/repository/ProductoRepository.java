package com.adriangabas.b2b.repository;

import com.adriangabas.b2b.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}