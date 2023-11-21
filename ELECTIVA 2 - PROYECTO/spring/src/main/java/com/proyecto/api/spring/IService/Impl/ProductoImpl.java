package com.proyecto.api.spring.IService.Impl;

import com.proyecto.api.spring.IService.IProducto;
import com.proyecto.api.spring.entities.Producto;
import com.proyecto.api.spring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImpl implements IProducto {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Producto actualziarProducto(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }
}
