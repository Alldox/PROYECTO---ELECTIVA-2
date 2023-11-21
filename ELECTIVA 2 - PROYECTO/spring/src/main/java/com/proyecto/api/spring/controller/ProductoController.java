package com.proyecto.api.spring.controller;

import com.proyecto.api.spring.IService.IProducto;
import com.proyecto.api.spring.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    @Autowired
    private IProducto iProducto;

    @GetMapping("/productos")
    public String listarPorductos(Model model){
        model.addAttribute("productos", iProducto.listarProductos());
        return "productos";
    }

    @GetMapping("/productos/nuevo")
    public String crearProductoForm(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "productonuevo";
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute("producto") Producto producto){
        iProducto.guardarProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("producto", iProducto.obtenerProductoPorId(id));
        return "editarproducto";
    }

    @PostMapping("/productos/{id}")
    public String editarProducto (@PathVariable Long id, @ModelAttribute("producto") Producto producto, Model model){
       Producto productoExistente = iProducto.obtenerProductoPorId(id);
        productoExistente.setId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setCategoria(producto.getCategoria());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setProveedor(producto.getProveedor());
        productoExistente.setStock(producto.getStock());

        iProducto.actualziarProducto(productoExistente);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id){
        iProducto.eliminarProducto(id);
        return "redirect:/productos";
    }

}
