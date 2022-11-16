package com.eCommerce.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eCommerce.Excepciones.ResourceNotFoundException;
import com.eCommerce.Model.DetalleVentaModel;
import com.eCommerce.Model.ProductoModel;
import com.eCommerce.Repository.DetalleVentaRepository;
import com.eCommerce.Validaciones.DetalleVentaValidacion;

@Service
public class DetalleVentaServicio {
	
	 @Autowired
	 private DetalleVentaRepository detalleVentaRepository;
	 @Autowired
	 private DetalleVentaValidacion detalleVentaValidacion;
	 @Autowired 
	 public ProductoServicio productoServicio;
	 
	 public DetalleVentaModel create(DetalleVentaModel detalle){
		 this.detalleVentaValidacion.validateDetalleVenta(detalle);
         return this.detalleVentaRepository.save(detalle);
	 }
	 
	 public List<DetalleVentaModel> findAll(){	 
			 return this.detalleVentaRepository.findAll();
	
         }
		
	 
    	
     
	 
     public DetalleVentaModel findById(Long id) throws ResourceNotFoundException  {
    	 Optional<DetalleVentaModel> detailDB = this.detalleVentaRepository.findById(id);
    	 if (detailDB.isPresent()){
    		 return this.detalleVentaRepository.findById(id).orElseThrow();
         }else{
             throw new ResourceNotFoundException("El detalle no existe");
         }
     }
/*     
     public DetalleVentaModel update(DetalleVentaModel detalle, Long id) throws ResourceNotFoundException {
    	 this.detalleVentaValidacion.validateDetalleVenta(detalle);
         Optional<DetalleVentaModel> detalleOptional= this.detalleVentaRepository.findById(id);
         if (detalleOptional.isPresent()){
        	 DetalleVentaModel nuevoDetalle = detalleOptional.get();
        	 nuevoDetalle.setVenta(detalle.getVenta());
        	 nuevoDetalle.setProductos(detalle.getProductos());
        	 nuevoDetalle.setSubTotal(detalle.getSubTotal());
        	 nuevoDetalle.setCantidad(detalle.getCantidad());
             return this.detalleVentaRepository.save(nuevoDetalle);
         }else{
             throw new ResourceNotFoundException("El detalle no existe");
         }
     }
*/
     
}