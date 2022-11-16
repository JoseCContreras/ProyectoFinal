package com.eCommerce.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eCommerce.Excepciones.ResourceAlreadyExistsException;
import com.eCommerce.Model.DetalleVentaModel;
import com.eCommerce.Model.ProductoModel;
import com.eCommerce.Model.VentaModel;
import com.eCommerce.Repository.ClienteRepository;
import com.eCommerce.Repository.DetalleVentaRepository;
import com.eCommerce.Repository.ProductoRepository;
import com.eCommerce.Repository.VentaRepository;
import com.eCommerce.Service.RequestsInput.VentaCreateInput;
import com.eCommerce.Service.RequestsInput.VentaCreateInputProducto;
import com.eCommerce.Service.Resources.VentaResource;
import com.eCommerce.Validaciones.VentaValidacion;

@Service
public class VentaServicio {

	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	public ClienteServicio clienteServicio;
	@Autowired
	public ClienteRepository clienteRepository;
	@Autowired
	public DetalleVentaRepository detalleVentaRepository;
	@Autowired
	public VentaValidacion ventaValidacion;
	@Autowired
	public ProductoServicio productoServicio;
	@Autowired
	public DetalleVentaServicio detalleVentaServicio;
	@Autowired
	public ProductoRepository productoRepository;
	

	/*
	 * public VentaModel create (VentaModel nuevaVenta) throws
	 * ResourceAlreadyExistsException {
	 * this.ventaValidacion.validateVenta(nuevaVenta); Optional<VentaModel>
	 * VentaOpti=this.ventaRepository.findById(nuevaVenta.getId());
	 * if(VentaOpti.isPresent()) { throw new
	 * ResourceAlreadyExistsException("La venta ya existe. Revisar"); }else { return
	 * this.ventaRepository.save(nuevaVenta); }
	 * 
	 * 
	 * }
	 */

	public VentaModel create(VentaCreateInput input) throws Exception {
		//dominio
		double total = 0;
		int reducirStock=0;
		VentaModel ventaModel = new VentaModel();
		ventaModel.setId(Long.MAX_VALUE);

		if (input.cliente == null)
			throw new Exception("La venta requiere un cliente");
		ventaModel.setClientes(input.cliente);
		ventaModel.setFechaAlta(LocalDate.now());

		if (input.lineas.length == 0)
			throw new Exception("La venta debe tener al menos un producto");

		for (VentaCreateInputProducto linea : input.lineas) {
			ProductoModel producto = this.productoServicio.findById(linea.id);
			if (linea.cantidad <= 0)
				throw new Exception("La cantidad debe ser mayor a cero");
			total += producto.getPrecioVenta() * linea.cantidad;
		}
		ventaModel.setTotal(total);
		// persistencia
		ventaModel = this.ventaRepository.save(ventaModel);

		for (VentaCreateInputProducto linea : input.lineas) {
			ProductoModel producto = this.productoServicio.findById(linea.id);
			double precio = producto.getPrecioVenta() * linea.cantidad;
			DetalleVentaModel detalle = new DetalleVentaModel();
			detalle.setId(Long.MAX_VALUE);
			detalle.setCantidad(linea.cantidad);
			detalle.setProductos(producto);
			detalle.setSubTotal(precio);
			detalle.setVenta(ventaModel);
			detalle = this.detalleVentaServicio.create(detalle);
			if(producto.getStock()<=0) 
				throw new ResourceAlreadyExistsException("No hay Stock de este producto "+producto.getDescripcion());
			if(linea.cantidad > producto.getStock()) 
					throw new ResourceAlreadyExistsException("La cantidad solicitada del producto "+producto.getDescripcion()+ " es mayor al stock actual: "+ producto.getStock());
			reducirStock = producto.getStock() - linea.cantidad;
			producto = this.productoServicio.updateStock(reducirStock, linea.id);
			
		
			
		}
		
		return this.ventaRepository.save(ventaModel);
	}
		
	
	



	public List<VentaModel> findAll() {
		return this.ventaRepository.findAll();
	}

	public VentaResource buscarPorId(Long id) throws ResourceAlreadyExistsException {
		
		
		
		Optional<VentaModel> ventaOpti = this.ventaRepository.findById(id);
		if (ventaOpti.isPresent()) {
			VentaModel venta = ventaOpti.get();
		//revisar
			List<ProductoModel> detalle=this.detalleVentaRepository.findByProductos(id);
		
				
			return new VentaResource (venta,detalle );
		} else {
			throw new ResourceAlreadyExistsException("la venta no existe");
		}
	}

}
