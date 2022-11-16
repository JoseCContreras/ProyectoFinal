package com.eCommerce.Repository;

import java.util.List;

//importacion
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCommerce.Model.DetalleVentaModel;
import com.eCommerce.Model.ProductoModel;



@Repository //anotacion de Spring para indicar que esto es un repository el cual nos permite guardar datos en la base de datos
public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Long> {//interfas DetalleVentaRepository que hereda de la clase JpaRepository
	
	List<ProductoModel> findByProductos(Long id);

}
