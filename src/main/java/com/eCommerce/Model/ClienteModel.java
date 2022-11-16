package com.eCommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;


@Data //anotacion para crear set, get, constructor, topString, hashCode, equals
@AllArgsConstructor //crea un constructor por cada variable
@NoArgsConstructor //crea el contructor por defecto 
@Entity	//anotacion que indica que esta clase esta binculada a una base de datos.
@Table(name = "clientes") //representacion de la tabla en la base de datos
public class ClienteModel {
	//anotacion para indicar que este campo sera el id
	@Id       
	@GeneratedValue(strategy = GenerationType.IDENTITY)//le indica a java que la base de datos se encarga de auto incrementar
	private Long id; 
	
	@Column (name = "dni")
	private String dni; 
	 							//Mapeo
	@Column (name = "nombre")	//@Column indica que es una columna de la tabla
	private String nombre;  	//variables que representan campos en la tabla
	
	@Column	(name = "apellido")
	private String apellido;  

	@Column (name = "fecha_Nacimiento") 
	private LocalDate fechaNacimiento;

	


}
