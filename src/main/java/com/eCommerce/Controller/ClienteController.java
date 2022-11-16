package com.eCommerce.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eCommerce.Excepciones.ResourceAlreadyExistsException;
import com.eCommerce.Model.ClienteModel;
import com.eCommerce.Service.ClienteServicio;




@RequestMapping(path="api/clientes")
@RestController
public class ClienteController { 

	
	// anotación que permite inyectar unas dependencias 
	 @Autowired
	    private ClienteServicio clienteServicio;
	
	
	 
	 @PostMapping("/")// Para crear un recurso en el servidor
	 public ResponseEntity<ClienteModel> create (@RequestBody ClienteModel Cliente) throws ResourceAlreadyExistsException  {
		 
		 return new ResponseEntity<>(this.clienteServicio.create(Cliente), HttpStatus.OK);
		
	 }
	 
	 @GetMapping("/")//Para recuperar un recurso hay que utilizar un GET.
	 public  ResponseEntity<List<ClienteModel>> findAll(){
		 return new  ResponseEntity<>(this.clienteServicio.findAll(), HttpStatus.OK);
	 }
	 
	 @GetMapping("/{dni}")
	 public  ResponseEntity <ClienteModel> BuscarClienteDni (@PathVariable String dni) throws IllegalArgumentException{
		return new  ResponseEntity<>(this.clienteServicio.BuscarDni(dni), HttpStatus.OK);
	 }
	 
	 
	 @PutMapping("/{id}")//Para cambiar el estado de un recurso o para actualizarlo
	 public ResponseEntity<ClienteModel> update(@RequestBody ClienteModel clienteModifica, @PathVariable Long id) throws ResourceAlreadyExistsException {
		     return new ResponseEntity<>(this.clienteServicio.update(clienteModifica, id), HttpStatus.OK);
		  
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> delete (@PathVariable Long id) throws ResourceAlreadyExistsException  {
		 return new ResponseEntity<>(this.clienteServicio.delete(id), HttpStatus.OK);
		}
}
