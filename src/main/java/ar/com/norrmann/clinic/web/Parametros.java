package ar.com.norrmann.clinic.web;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	private Date fecha = new Date();

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setFecha(String selectDate) {
		try {
			Date fecha = formatoDeFecha.parse(selectDate);
			setFecha(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String getFechaString(){
		return formatoDeFecha.format(fecha);
	}
	
	public int getDayNumber(){
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		return c.get(Calendar.DAY_OF_WEEK);
	}

}
