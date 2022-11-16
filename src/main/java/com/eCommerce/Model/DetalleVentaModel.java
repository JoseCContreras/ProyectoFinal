package com.eCommerce.Model;


//importacion
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

//anotacion para crear set, get, constructor, topString, hashCode, equals
@Data
//crea un constructor por cada variable
@AllArgsConstructor
//crea el contructor por defecto 
@NoArgsConstructor
//anotacion que indica que esta clase esta binculada a una base de datos.
@Entity
//representacion de la tabla en la base de datos
@Table(name = "detalle_venta")
public class DetalleVentaModel {
	//anotacion para indicar que este campo sera el id
	@Id
	//le indica a java que la base de datos se encarga de auto incrementar
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "venta_id")
	private VentaModel venta;


	@ManyToOne
	@JoinColumn(name = "productos_id") 
	private ProductoModel  productos;
	
	@Column
	private int cantidad;

	@Column(name = "subtotal") 
	private double subTotal;

	
}
