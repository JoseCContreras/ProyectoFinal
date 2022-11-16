package com.eCommerce.Validaciones;

import org.springframework.stereotype.Component;


import com.eCommerce.Model.VentaModel;

@Component 
public class VentaValidacion {
	
	public void validateVenta (VentaModel nuevaVenta) {
		if(nuevaVenta == null) {
			throw new IllegalArgumentException("No puede ser nulo ");
		}
		if(nuevaVenta.getClientes()==null) {
			throw new IllegalArgumentException("Debe asignarse un cliente ");
		}
		if(nuevaVenta.getFechaAlta()==null) {
			throw new IllegalArgumentException("Fecha de alta es requerida con formato aaaa-mm-dd");
		}
		
	}
	
	
}
