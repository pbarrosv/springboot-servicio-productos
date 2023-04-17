package com.springboot.app.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.productos.models.entity.Producto;
import com.springboot.app.productos.models.service.IProductoService;

@RestController //convierte a JSon los metodos handler
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> listar() {
		return productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		boolean ok = false;
		
		if(!ok) {
			throw new RuntimeException("No se puede cargar el producto");
		}
		
		return productoService.findById(id);
	}
}
