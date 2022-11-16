package com.eCommerce.Service;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.eCommerce.Excepciones.ResourceAlreadyExistsException;
import com.eCommerce.Model.ClienteModel;
import com.eCommerce.Repository.ClienteRepository;
import com.eCommerce.Service.RequestsInput.VentaCreateInput;
import com.eCommerce.Validaciones.ClienteValidacion;

//import com.eCommerce.Validaciones.Validaciones;

@Service
public class ClienteServicio {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteValidacion clienteValidacion;
	
	
 //metodo para crear un cliete
public ClienteModel create (ClienteModel nuevoCliente) throws ResourceAlreadyExistsException {
	this.clienteValidacion.validateCliente(nuevoCliente);
	Optional<ClienteModel> ClienteOpti=this.clienteRepository.findByDni(nuevoCliente.getDni());
	if(ClienteOpti.isPresent()) {
		throw new ResourceAlreadyExistsException ("El cliente con el DNI brindado ya existe. Revisar");
	}else {
		
		return this.clienteRepository.save(nuevoCliente);
	}

}


//metodo para buscar
public List<ClienteModel> findAll(){
        return  this.clienteRepository.findAll();
      }


public ClienteModel BuscarDni (String dni) throws IllegalArgumentException{
	Optional<ClienteModel> clientBD = this.clienteRepository.findByDni(dni);
	 if (clientBD.isPresent()){
	return clientBD.get();
	}else {
		throw new IllegalArgumentException ("El cliente con el DNI ingresado, no existe");
	}
	
}

//metodo para actualizar
  public ClienteModel update(ClienteModel cliente, Long id) throws ResourceAlreadyExistsException {
        Optional<ClienteModel> clientBD = this.clienteRepository.findById(id);
        if (clientBD.isPresent()){
            ClienteModel clienteUp = clientBD.get();
            clienteUp.setDni(cliente.getDni());
            clienteUp.setNombre(cliente.getNombre());
            clienteUp.setApellido(cliente.getApellido());
            clienteUp.setFechaNacimiento(cliente.getFechaNacimiento());
       	
            return this.clienteRepository.save(clienteUp);
          
           
        }else {
        	throw new ResourceAlreadyExistsException("El cliente con el DNI brindado ya existe. Revisar");
        }
        
           
        }
        
         
  public String delete(Long id) throws ResourceAlreadyExistsException {
      Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
      if (clienteBD.isPresent()) {
          clienteBD.get();
          this.clienteRepository.deleteById(id);
          return "El cliente fue eliminado";
      }
      throw new ResourceAlreadyExistsException("El cliente no existe");
  }
  
}

