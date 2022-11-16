package com.eCommerce.Repository;

import org.springframework.stereotype.Repository;

import com.eCommerce.Model.ClienteModel;
import com.eCommerce.Model.VentaModel;

import java.util.Optional;

//importacion
import org.springframework.data.jpa.repository.JpaRepository;

@Repository //anotacion de Spring para indicar que esto es un repository el cual nos permite guardar datos en la base de datos
public interface VentaRepository extends JpaRepository<VentaModel, Long> {//interfas VentaRepository que hereda de la clase JpaRepository

	


}
