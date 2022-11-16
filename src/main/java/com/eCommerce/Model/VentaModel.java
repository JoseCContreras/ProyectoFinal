package com.eCommerce.Model;


//importacion
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


//anotacion para crear set, get, constructor, topString, hashCode, equals
@Data
//crea un constructor por cada variable
@AllArgsConstructor
//crea el contructor por defecto 
@NoArgsConstructor
//anotacion que indica que esta clase esta binculada a una base de datos.
@Entity
//representacion de la tabla en la base de datos
@Table(name = "venta")
public class VentaModel {
	
	//anotacion para indicar que este campo sera el id
	@Id
	//le indica a java que la base de datos se encarga de auto incrementar
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name ="fecha_Alta")
	private LocalDate fechaAlta;			//mapeo
											//@Column indica que es una columna de la tabla
	@Column									//variables que representan campos en la tabla
	private double total;

	//referencia de muchos a uno
	@ManyToOne
	//Especifica una columna para unir una asociación de entidades o una colección de elementos
	@JoinColumn(name = "cliente_id")
	// se crea un objeto 
	private ClienteModel clientes;
	
	
	//@ManyToOne
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="productos")
	//@JoinTable(name = "venta_id")
	//private List<DetalleVentaModel> productos;

}