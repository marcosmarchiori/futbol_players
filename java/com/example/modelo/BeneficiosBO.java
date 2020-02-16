package com.example.modelo;

import org.joda.time.DateTime;

public interface BeneficiosBO {
	

	public int calcularDiasITRPorTomar(int diasITR);
	
	public int calcularDiasTrabajadosParaVacaciones(int vacaciones);
	
	public int calcularHomeOffice(int homeOffice);

	

	
}
