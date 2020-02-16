package com.example.modelo;


import java.time.LocalDate;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;





@RestController 
@RequestMapping(path="/itr") 
public class MainController {

	@Autowired
	private EmpleadoRepository empleadoRepository;



	//Post y Get Mapping para empleado
	@PostMapping(path="/add/empleado")
	public @ResponseBody String addNewEmpleado(@RequestParam String nombre, 
			@RequestParam int diasITR, @RequestParam (value = "fechaIngreso") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaIngreso, 
			@RequestParam int homeOffice, @RequestParam int vacaciones) {
		
				
	       		Empleado empleadoConBeneficios = new Empleado();
	    		
	    		empleadoConBeneficios.setNombre(nombre);
	    	
	    		empleadoConBeneficios.setDiasITR(diasITR);
	    		
	    		empleadoConBeneficios.setFechaIngreso(fechaIngreso);
	    		empleadoConBeneficios.setHomeOffice(homeOffice);
	    		empleadoConBeneficios.setVacaciones(vacaciones);
	    	
	    		
	    		empleadoRepository.save(empleadoConBeneficios);
	    		
		  		return "Saved";
	}
	
	
	@GetMapping(path="/empleado")
	public @ResponseBody Iterable<Empleado> getAllEmpleados() {

		return empleadoRepository.findAll();
	}
	
	@GetMapping(path="/empleado/jql")
	public @ResponseBody Iterable<Empleado> jqlEmpleado() {

		return empleadoRepository.findByNombre("Mariano Loyza");
	}
 //-------------------------
	@Autowired
	private BeneficiosBO beneficiosBO;
	
	//POST y GET Mapping para BENEFICIOS
	
	@GetMapping(path="/empleado/beneficios/vacaciones")
	public @ResponseBody int calcularDiasTrabajadosParaVacaciones() {
		return beneficiosBO.calcularDiasTrabajadosParaVacaciones(280);
	}
	
	
	@GetMapping(path="/empleado/beneficios/home")
	public @ResponseBody int calcularDiasParaHome() {
		return beneficiosBO.calcularHomeOffice(110);
	}
	
	@GetMapping(path="/empleado/beneficios/diasITR")
	public @ResponseBody int calcularDiasRestantesITR() {
		return beneficiosBO.calcularDiasITRPorTomar(2);
	}
}