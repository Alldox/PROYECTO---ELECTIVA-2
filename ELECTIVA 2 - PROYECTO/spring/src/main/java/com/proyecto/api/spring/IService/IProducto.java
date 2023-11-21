package com.proyecto.api.spring.IService;

import com.proyecto.api.spring.entities.Producto;

import java.util.List;

public interface IProducto {

    public List<Producto> listarProductos();

    public Producto guardarProducto(Producto producto);

    public Producto obtenerProductoPorId(Long id);

    public Producto actualziarProducto(Producto producto);

    public void eliminarProducto(Long id);

}
