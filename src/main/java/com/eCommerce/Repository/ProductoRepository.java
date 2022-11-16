package com.eCommerce.Repository;

import java.util.List;
import java.util.Optional;

//importacion
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Model.ProductoModel;


@Repository //anotacion de Spring para indicar que esto es un repository el cual nos permite guardar datos en la base de datos
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {//interfas ProductoRepository que hereda de la clase JpaRepository

	Optional<ProductoModel> findBySku(String sku);
	
}
