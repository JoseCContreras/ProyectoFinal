package com.eCommerce.Validaciones;

import org.springframework.stereotype.Component;

import com.eCommerce.Model.DetalleVentaModel;

@Component 
public class DetalleVentaValidacion {

	
	public void validateDetalleVenta (DetalleVentaModel nuevoDetalleVenta) {
		if(nuevoDetalleVenta == null) {
			throw new IllegalArgumentException("No puede ser nulo ");
		}
		if(nuevoDetalleVenta.getCantidad()<= 0) {
			throw new IllegalArgumentException("La cantidad no puede ser menor o igual a cero ");
		}
		if(nuevoDetalleVenta.getProductos()==null) {
			throw new IllegalArgumentException("Debe asignar uno o mas productos");
		}
		if(nuevoDetalleVenta.getSubTotal()<= 0.0) {
			throw new IllegalArgumentException("El precio de total no debe ser menor ni igual a cero");
		}
		if(nuevoDetalleVenta.getVenta()==null) {
			throw new IllegalArgumentException("El detalle debe estar asignado a una venta");
		}
	}
}
