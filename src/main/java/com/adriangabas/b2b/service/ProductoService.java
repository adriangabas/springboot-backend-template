package com.adriangabas.b2b.service;
import com.adriangabas.b2b.dto.ProductoRequest;
import com.adriangabas.b2b.dto.ProductoResponse;
import com.adriangabas.b2b.model.Producto;
import com.adriangabas.b2b.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // GET ALL
    public Page<ProductoResponse> obtenerTodos(Pageable pageable) {
        return productoRepository.findAll(pageable)
                .map(this::convertToResponse);
    }

    // GET BY ID
    public ProductoResponse obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
                );

        return convertToResponse(producto);
    }

    // CREATE
    public ProductoResponse guardar(ProductoRequest request) {

        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());

        Producto guardado = productoRepository.save(producto);

        return convertToResponse(guardado);
    }

    // UPDATE
    public ProductoResponse actualizar(Long id, ProductoRequest request) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
                );

        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());

        Producto actualizado = productoRepository.save(producto);

        return convertToResponse(actualizado);
    }

    // DELETE
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
                );

        productoRepository.delete(producto);
    }

    // MÉTODO PRIVADO DE CONVERSIÓN
    private ProductoResponse convertToResponse(Producto producto) {
        return ProductoResponse.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .build();
    }
}