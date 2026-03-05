package com.adriangabas.template.controller;

import com.adriangabas.template.dto.ProductoRequest;
import com.adriangabas.template.dto.ProductoResponse;
import com.adriangabas.template.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // GET ALL
    @GetMapping
    public Page<ProductoResponse> obtenerTodos(Pageable pageable) {
        return productoService.obtenerTodos(pageable);
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ProductoResponse obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    // CREATE
    @PostMapping
    public ProductoResponse crear(@Valid @RequestBody ProductoRequest request) {
        return productoService.guardar(request);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ProductoResponse actualizar(@PathVariable Long id,
                                       @Valid @RequestBody ProductoRequest request) {
        return productoService.actualizar(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
