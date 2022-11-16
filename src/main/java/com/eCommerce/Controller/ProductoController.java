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
import com.eCommerce.Model.ProductoModel;
import com.eCommerce.Service.ProductoServicio;




					
@RequestMapping(path="api/productos")
@RestController
public class ProductoController {

	@Autowired
	private ProductoServicio productoServicio;
	

	
	@PostMapping("/")
	public ProductoModel create (@RequestBody ProductoModel nuevoproducto) throws ResourceAlreadyExistsException  {
		return this.productoServicio.create(nuevoproducto);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductoModel>> findAll(){
		 return new ResponseEntity<>(this.productoServicio.findAll(),HttpStatus.OK);
	 }
	@GetMapping("/{sku}")
	 public  ResponseEntity <ProductoModel> BuscarClienteDni (@PathVariable String sku) throws IllegalArgumentException{
		return new  ResponseEntity<>(this.productoServicio.BuscarSku(sku), HttpStatus.OK);
	 }
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoModel>  update ( @RequestBody ProductoModel producto,@PathVariable Long id ) throws ResourceAlreadyExistsException {
		return new ResponseEntity<>(this.productoServicio.update(producto , id), HttpStatus.OK);
		
	}
	
	 
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id) throws ResourceAlreadyExistsException  {
		 return new ResponseEntity<>(this.productoServicio.delete(id), HttpStatus.OK);

	}
}
