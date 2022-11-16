package com.eCommerce.Model;

//importacion
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


import java.time.LocalDate;
//import java.util.List;


//anotacion para crear set, get, constructor, topString, hashCode, equals
@Data
//crea un constructor por cada variable
@AllArgsConstructor
//crea el contructor por defecto 
@NoArgsConstructor
//anotacion que indica que esta clase esta binculada a una base de datos.
@Entity
//representacion de la tabla en la base de datos
@Table(name = "productos")
public class ProductoModel {

	

	public ProductoModel(String descripcion2) {
		// TODO Auto-generated constructor stub
	}

	public ProductoModel(Long id2) {
		// TODO Auto-generated constructor stub
	}

	public ProductoModel(double precioVenta2) {
		// TODO Auto-generated constructor stub
	}

	//anotacion para indicar que este campo sera el id
	@Id
	//le indica a java que la base de datos se encarga de auto incrementar
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "sku")
	private String sku;

	@Column	(name = "descripcion")								//mapeo
	private String descripcion;				//@Column indica que es una columna de la tabla
											//variables que representan campos en la tabla
	@Column (name = "precio_Compra")
	private double precioCompra;

	@Column (name = "precio_Venta")
	private double precioVenta;

	@Column (name = "stock")
	private int stock;

	@Column (name = "fecha_Alta")
	private LocalDate fechaAltaProducto;

	
}
