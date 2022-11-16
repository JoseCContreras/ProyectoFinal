package com.eCommerce.Validaciones;

import org.springframework.stereotype.Component;


import com.eCommerce.Model.ClienteModel;

@Component 
public class ClienteValidacion {

	public void validateCliente (ClienteModel nuevoCliente)  {
		if(nuevoCliente == null) {
			throw new IllegalArgumentException("No puede ser nulo ");
		}
		if(nuevoCliente.getNombre()==null||nuevoCliente.getNombre().isBlank()||nuevoCliente.getNombre().length()<2) {
			throw new IllegalArgumentException("El campo nombre es requerido y debe ser mayor a dos letras");
		}
		if(nuevoCliente.getNombre().matches("[0-9]*{1,10}")){
			throw new IllegalArgumentException("Ingresar solo numeros, no deben ser mas de 10 digitos");
		}
		if(nuevoCliente.getApellido()==null||nuevoCliente.getApellido().isBlank()||nuevoCliente.getApellido().length()<2) {
			throw new IllegalArgumentException("El campo apellido es requerido y debe ser mayor a dos letras");
		}
		if(nuevoCliente.getDni()==null||nuevoCliente.getDni().isBlank()||(Integer.parseInt(nuevoCliente.getDni())<=0 )){
			throw new IllegalArgumentException("El DNI es un campo requerido, no debe contener numeros negativos");
		} 
		 
		if(nuevoCliente.getFechaNacimiento()==null) {
			throw new IllegalArgumentException("Fecha de nacimiento es requerida");
		}
	}
}
