package ar.com.norrmann.clinic.web;
import ar.com.norrmann.clinic.model.Consultorio;
import ar.com.norrmann.clinic.model.HorarioDisponible;
import ar.com.norrmann.clinic.model.Profesional;
import ar.com.norrmann.clinic.model.Turno;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping("/turnoes")
@Controller
@RooWebScaffold(path = "turnoes", formBackingObject = Turno.class)
@SessionAttributes({ "parametros" })
public class TurnoController {
	
    @RequestMapping(produces = "text/html")
    public String list(@ModelAttribute Parametros parametros,@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("turnoes", Turno.findTurnoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) Turno.countTurnoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("turnoes", Turno.findAllTurnoes(sortFieldName, sortOrder));
        }
        Consultorio consultorio = Consultorio.findConsultorio(parametros.getConsultorioSeleccionado().getId());
        Profesional profesional = Profesional.findProfesional(parametros.getProfesionalSeleccionado().getId());

        uiModel.addAttribute("horariodisponibles", HorarioDisponible.findHorarioDisponiblesByConsultorioAndProfesional(consultorio, profesional, sortFieldName, sortOrder).getResultList());
        addDateTimeFormatPatterns(uiModel);
        return "turnoes/list";
    }
}
