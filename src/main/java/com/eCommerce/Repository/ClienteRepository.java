package com.eCommerce.Repository;


import java.util.Optional;

//importacion
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Model.ClienteModel;


@Repository //anotacion de Spring para indicar que esto es un repository el cual nos permite guardar datos en la base de datos
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {//interfas ClienteRepository que hereda de la clase JpaRepository

	Optional<ClienteModel> findByDni(String dni);

	
	
}
