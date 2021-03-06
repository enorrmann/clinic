package ar.com.norrmann.clinic.web;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ar.com.norrmann.clinic.model.Consultorio;
import ar.com.norrmann.clinic.model.Profesional;

@Component
@Scope("session")
public class Parametros implements Serializable {

	private static final long serialVersionUID = 1L;

	private SimpleDateFormat formatoDeFecha = new SimpleDateFormat("MM/d/yyyy");
	private Profesional profesionalSeleccionado;
	private Consultorio consultorioSeleccionado;
	private Date fechaSeleccionada = new Date();
	private List<Long> diasAtiende = new ArrayList<Long>();

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

	public Date getFechaSeleccionada() {
		return fechaSeleccionada;
	}

	public void setFechaSeleccionada(Date fechaSeleccionada) {
		this.fechaSeleccionada = fechaSeleccionada;
	}

	public void setFechaSeleccionada(String selectDate) {
		try {
			Date fecha = formatoDeFecha.parse(selectDate);
			setFechaSeleccionada(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getFechaString(){
		return formatoDeFecha.format(fechaSeleccionada);
	}
	
	public int getDayNumber(){
		Calendar c = Calendar.getInstance();
		c.setTime(fechaSeleccionada);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	public List<Long> getDiasAtiende() {
		return diasAtiende;
	}

	public void setDiasAtiende(List<Long> diasAtiende) {
		this.diasAtiende = diasAtiende;
	}
	
	public void addDiaAtiende(Long diaAtiende){
		diasAtiende.add(diaAtiende);
	}

}
