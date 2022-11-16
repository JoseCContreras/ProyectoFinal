package com.eCommerce.Service.Resources;

import java.util.List;

import com.eCommerce.Model.DetalleVentaModel;
import com.eCommerce.Model.ProductoModel;
import com.eCommerce.Model.VentaModel;

public class VentaResource {
	
	public VentaModel venta;
	//public DetalleVentaModel detalleProducto;
	public List<ProductoModel> detalle;
	
	public VentaResource(VentaModel venta, List<ProductoModel> detalle) {
		super();
		this.venta = venta;
		this.detalle = detalle;
	}

	public VentaResource() {
		super();
	}
	

}
