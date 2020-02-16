package com.example.modelo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="EMPLEADO")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	
	private String nombre;

	LocalDate fechaIngreso;
	
	
	int vacaciones;
	
	
	int diasITR = 5;
	
	
	int homeOffice;
	
	

	public Empleado(String nombre, LocalDate fechaIngreso, int vacaciones, int diasITR, int homeOffice) {
		
		
		this.nombre = nombre;
		this.fechaIngreso= fechaIngreso;
		this.vacaciones = vacaciones;
		this.diasITR = diasITR;
		this.homeOffice = homeOffice;
		
	}

	public Empleado() {
		
	}

	public int getId(int i) {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getVacaciones() {
		return vacaciones;
	}

	public void setVacaciones(int vacaciones) {
		this.vacaciones = vacaciones;
	}

	public int getDiasITR() {
		return diasITR;
	}

	public void setDiasITR(int diasITR) {
		this.diasITR = diasITR;
	}

	public int getHomeOffice() {
		return homeOffice;
	}

	public void setHomeOffice(int homeOffice) {
		this.homeOffice = homeOffice;
	}



	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso + ", vacaciones="
				+ vacaciones + ", diasITR=" + diasITR + ", homeOffice=" + homeOffice + "]";
	}

}