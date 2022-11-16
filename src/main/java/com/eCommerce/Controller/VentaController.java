package com.eCommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eCommerce.Excepciones.ResourceAlreadyExistsException;
import com.eCommerce.Excepciones.ResourceNotFoundException;
import com.eCommerce.Model.DetalleVentaModel;
import com.eCommerce.Model.VentaModel;
import com.eCommerce.Service.VentaServicio;
import com.eCommerce.Service.RequestsInput.VentaCreateInput;
import com.eCommerce.Service.Resources.VentaResource;

@RequestMapping(path = "api/ventas")
@RestController
public class VentaController {

	@Autowired
	private VentaServicio ventaServicio;

	
	@PostMapping("/")
	public ResponseEntity<VentaModel> create(@RequestBody VentaCreateInput input) throws Exception{
		
		return new ResponseEntity<>(this.ventaServicio.create(input), HttpStatus.OK);
	}

/*	@PostMapping("/")
	public ResponseEntity<VentaModel> create(@RequestBody VentaCreateInput input) throws Exception {
		// dominio
		double total = 0;
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
		ventaModel = this.ventaServicio.create(ventaModel);

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

		}

		return new ResponseEntity<>(ventaModel, HttpStatus.OK);

	}

	@GetMapping("/b/{id}")
	public ResponseEntity<VentaDetalleInput> buscarFactura(@PathVariable Long id)
			throws IllegalArgumentException, ResourceNotFoundException {
		return new ResponseEntity<>(this.ventaServicio.buscarFacturas(id), HttpStatus.OK);
	}
*/
	@GetMapping("/") // Para recuperar un recurso hay que utilizar un GET.
	public ResponseEntity<List<VentaModel>> findAll() {
		
		return new ResponseEntity<>( this.ventaServicio.findAll(), HttpStatus.OK);
	}

	//@GetMapping("/{id}")
	//public ResponseEntity<VentaResource> buscarPorId(@PathVariable Long id)
	//		throws IllegalArgumentException, ResourceAlreadyExistsException {
	//	return new ResponseEntity<>(this.ventaServicio.buscarPorId(id), HttpStatus.OK);
	//}
}
