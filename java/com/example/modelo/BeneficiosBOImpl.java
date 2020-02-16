package com.example.modelo;

import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeneficiosBOImpl implements BeneficiosBO {

	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	List<Empleado> empleadoBenApp;
	
	@Override
	public int calcularDiasITRPorTomar (int diasITR) {
		
		if(diasITR > 5) 
			return 0;
		if(diasITR <= 5) 
			return diasITR-1;
		return diasITR-1;
			
	}
	
	
	@Override
	public int calcularDiasTrabajadosParaVacaciones( int vacaciones) {
		return vacaciones * 30 / 360;
	}

	@Override
	public int calcularHomeOffice(int homeOffice) {
		int diasTrabajadosParaHome = homeOffice;
		if(diasTrabajadosParaHome > 120) 
			return 2;
		if(diasTrabajadosParaHome > 60)
			return 1;
		return diasTrabajadosParaHome;
		
		}
	

}
	



