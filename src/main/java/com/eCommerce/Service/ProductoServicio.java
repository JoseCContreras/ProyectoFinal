package com.eCommerce.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.Excepciones.ResourceAlreadyExistsException;
import com.eCommerce.Model.ClienteModel;
import com.eCommerce.Model.ProductoModel;
import com.eCommerce.Repository.ProductoRepository;
import com.eCommerce.Validaciones.ProductoValidacion;



@Service 
public class ProductoServicio {
	
	@Autowired 
	private ProductoRepository productoRepository;
	@Autowired 
	private ProductoValidacion productoValidacion;
	
	public ProductoModel create (ProductoModel nuevoProducto) throws ResourceAlreadyExistsException {
		this.productoValidacion.validateProducto(nuevoProducto);
		Optional<ProductoModel> productoOpti=this.productoRepository.findBySku(nuevoProducto.getSku());
		if(productoOpti.isPresent()) {
			throw new ResourceAlreadyExistsException("El producto con el codigo de barras brindado ya existe. Revisar");
		}else {
			return this.productoRepository.save(nuevoProducto);
		}
	}
	public List<ProductoModel> findAll(){
        return  this.productoRepository.findAll();
    }
	
	public ProductoModel findById(Long id){
        return  this.productoRepository.findById(id).get();
    }
	
	public ProductoModel BuscarSku (String sku) throws IllegalArgumentException{
		Optional<ProductoModel> productoOptional = this.productoRepository.findBySku(sku);
		 if (productoOptional.isPresent()){
		return productoOptional.get();
		}else {
			throw new IllegalArgumentException ("El codigo de barras ingresado, no existe");
		}
		
	}
	
	
	public ProductoModel update (ProductoModel producto, Long id) throws ResourceAlreadyExistsException  {
		this.productoValidacion.validateProducto(producto);
		Optional<ProductoModel> productoUp = this.productoRepository.findById(id);
		if(productoUp.isPresent()) {
			ProductoModel productoCaja = productoUp.get();
			productoCaja.setSku(producto.getSku());
			productoCaja.setDescripcion(producto.getDescripcion());
			productoCaja.setPrecioCompra(producto.getPrecioCompra());
			productoCaja.setPrecioVenta(producto.getPrecioVenta());
			productoCaja.setStock(producto.getStock());
			productoCaja.setFechaAltaProducto(producto.getFechaAltaProducto());
			return this.productoRepository.save(productoCaja);
			
			 
		} else {
			throw new ResourceAlreadyExistsException("El producto con id: "+ id + " no existe");
		}
	}
		
	public ProductoModel updateStock (int Stock, Long id) throws ResourceAlreadyExistsException {
		Optional<ProductoModel> productoUp = this.productoRepository.findById(id);
		if(productoUp.isPresent()) {
		ProductoModel productoCaja = productoUp.get();	
		productoCaja.setStock(Stock);
		return this.productoRepository.save(productoCaja);
		}
		else {
		throw new ResourceAlreadyExistsException("El producto con id: "+ id + " no existe");
	}
		
	}
	
	
	public String delete(Long id) throws ResourceAlreadyExistsException {
	      Optional<ProductoModel> clienteBD = this.productoRepository.findById(id);
	      if (clienteBD.isPresent()) {
	          clienteBD.get();
	          this.productoRepository.deleteById(id);
	          return "El producto fue eliminado";
	      }
	      throw new ResourceAlreadyExistsException("El producto no existe");
	  }

}