package ar.com.norrmann.clinic.web;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.com.norrmann.clinic.model.Consultorio;
import ar.com.norrmann.clinic.model.Dia;
import ar.com.norrmann.clinic.model.HorarioDisponible;
import ar.com.norrmann.clinic.model.Profesional;
import ar.com.norrmann.clinic.model.Turno;

@RequestMapping("/turnoes")
@Controller
@RooWebScaffold(path = "turnoes", formBackingObject = Turno.class)
@SessionAttributes({ "parametros" })
public class TurnoController {
	
    @RequestMapping(produces = "text/html")
    public String list(@ModelAttribute Parametros parametros,@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    	List<Turno> turnos = null;
    	List<HorarioDisponible> horariosDisponibles = null;
    	if (sortFieldName==null)sortFieldName="hora";

        Consultorio consultorio = Consultorio.findConsultorio(parametros.getConsultorioSeleccionado().getId());
        Profesional profesional = Profesional.findProfesional(parametros.getProfesionalSeleccionado().getId());
        Date fecha = parametros.getFecha();
        turnos = Turno.findTurnoesByConsultorioAndProfesionalAndFecha(consultorio,profesional,fecha,sortFieldName,"ASC").getResultList();
        uiModel.addAttribute("turnoes", turnos);
        Dia dia = Dia.findDia(new Long(parametros.getDayNumber()));
        if (dia!=null){
        	horariosDisponibles = HorarioDisponible.findHorarioDisponiblesByConsultorioAndProfesionalAndDia(consultorio, profesional, dia,sortFieldName, sortOrder).getResultList();
        	removeAssigned(turnos,horariosDisponibles);
        }
        uiModel.addAttribute("horariodisponibles", horariosDisponibles);
        addDateTimeFormatPatterns(uiModel);
        return "turnoes/list";
    }
    
    private void removeAssigned(List<Turno> turnos,List<HorarioDisponible> horariosDisponibles){
    	if (turnos==null || horariosDisponibles==null){
    		return ;
    	}
    	Iterator<HorarioDisponible> itHorarios = horariosDisponibles.iterator();
    	while (itHorarios.hasNext()){
    		HorarioDisponible unHorarioDisponible = itHorarios.next();
    		for (Turno unTurno:turnos){
    			if (unTurno.getHora().equals(unHorarioDisponible.getHora())){
    				itHorarios.remove();
    			}
    		}
    	}
    }
}
