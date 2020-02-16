package com.example.modelo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
	
	@Query("from Empleado e where e.nombre=:nombre")
	public Iterable<Empleado> findByNombre(@Param("nombre") String nombre);
}
