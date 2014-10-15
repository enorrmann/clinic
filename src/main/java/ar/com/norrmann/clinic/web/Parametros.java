package ar.com.norrmann.clinic.web;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ar.com.norrmann.clinic.model.Consultorio;
import ar.com.norrmann.clinic.model.Profesional;

@Component
@Scope("session")
public class Parametros implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	private Profesional profesionalSeleccionado;
	private Consultorio consultorioSeleccionado;
	public Profesional getProfesionalSeleccionado() {
		return profesionalSeleccionado;
	}
	public void setProfesionalSeleccionado(Profesional profesionalSeleccionado) {
		this.profesionalSeleccionado = profesionalSeleccionado;
	}
	public Consultorio getConsultorioSeleccionado() {
		return consultorioSeleccionado;
	}
	public void setConsultorioSeleccionado(Consultorio consultorioSeleccionado) {
		this.consultorioSeleccionado = consultorioSeleccionado;
	}

	}
