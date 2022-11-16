package com.eCommerce.Validaciones;


import org.springframework.stereotype.Component;

import com.eCommerce.Model.ProductoModel;

@Component 
public class ProductoValidacion {

	public void validateProducto (ProductoModel nuevoProducto) {
		
		if(nuevoProducto == null) {
			throw new IllegalArgumentException("No puede ser nulo ");
		}
		if(nuevoProducto.getSku()==null||nuevoProducto.getSku().isBlank()||nuevoProducto.getSku().length()<4||nuevoProducto.getSku().length()>50) {
			throw new IllegalArgumentException("El codigo de barra es requerido y debe ser mayor a 4 numeros");
		}
		if(nuevoProducto.getDescripcion()==null||nuevoProducto.getDescripcion().isBlank()||nuevoProducto.getDescripcion().length()<3||nuevoProducto.getSku().length()>50) {
			throw new IllegalArgumentException("La descripcion es requerida y y debe ser entre 3 y 50 letras");
		}
		if(nuevoProducto.getPrecioCompra() <= 0.0 ) {
			throw new IllegalArgumentException("El precio de compra no debe ser menor ni igual a cero");		
		}
		if(nuevoProducto.getPrecioVenta() <=0.0) {
			throw new IllegalArgumentException("El precio de Venta no debe ser menor ni igual a cero");
		}
		if(nuevoProducto.getPrecioVenta() < nuevoProducto.getPrecioCompra() ) {
			throw new IllegalArgumentException("El precio de Venta no puede ser menor al de compra");
		}
		if(nuevoProducto.getStock()<0) {
			throw new IllegalArgumentException("La cantidad es requeridad, ingresar una mayor a cero");
		}
	}
	
}
