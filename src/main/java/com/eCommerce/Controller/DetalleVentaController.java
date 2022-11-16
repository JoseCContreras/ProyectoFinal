package com.eCommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eCommerce.Model.DetalleVentaModel;
import com.eCommerce.Service.DetalleVentaServicio;
import com.eCommerce.Service.RequestsInput.VentaCreateInput;

@RequestMapping(path = "api/detalles")
@RestController
public class DetalleVentaController {
	
	 @Autowired
	 private DetalleVentaServicio detalleVentaServicio;

	 @PostMapping ("/")
	    public ResponseEntity<DetalleVentaModel> create (@RequestBody DetalleVentaModel detalle){
	        return new ResponseEntity<>(this.detalleVentaServicio.create(detalle), HttpStatus.OK);
	    }
	 @GetMapping("/")
	    public ResponseEntity<List<DetalleVentaModel>> findAll(){
	        return new ResponseEntity<>(this.detalleVentaServicio.findAll(),HttpStatus.OK);
	    }
	 @GetMapping("/{id}")
	    public ResponseEntity<DetalleVentaModel> findById(@PathVariable Long id) throws Exception {
	        return new ResponseEntity<>(this.detalleVentaServicio.findById(id),HttpStatus.OK);
	    }
	
	    
	 
}