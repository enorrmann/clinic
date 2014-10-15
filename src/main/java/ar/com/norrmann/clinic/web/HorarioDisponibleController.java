package ar.com.norrmann.clinic.web;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ar.com.norrmann.clinic.model.Consultorio;
import ar.com.norrmann.clinic.model.Dia;
import ar.com.norrmann.clinic.model.HorarioDisponible;
import ar.com.norrmann.clinic.model.Profesional;

import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/horariodisponibles")
@Controller
@SessionAttributes({ "parametros" })
@RooWebScaffold(path = "horariodisponibles", formBackingObject = HorarioDisponible.class)
@RooWebFinder
public class HorarioDisponibleController {

    @RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel, @ModelAttribute Parametros params) {
        HorarioDisponible horarioDisponible = new HorarioDisponible();
        uiModel.addAttribute("horarioDisponible", horarioDisponible);
        uiModel.addAttribute("dias", Dia.findAllDias());
        return "horariodisponibles/create";
    }

    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@ModelAttribute Parametros parametros, @Valid HorarioDisponible horarioDisponible, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, horarioDisponible);
            return "horariodisponibles/create";
        }
        uiModel.asMap().clear();
    	Consultorio consultorio = Consultorio.findConsultorio(parametros.getConsultorioSeleccionado().getId());
    	Profesional profesional = Profesional.findProfesional(parametros.getProfesionalSeleccionado().getId());
        horarioDisponible.setConsultorio(consultorio);
        horarioDisponible.setProfesional(profesional);
        horarioDisponible.persist();
        //return "redirect:/horariodisponibles/" + encodeUrlPathSegment(horarioDisponible.getId().toString(), httpServletRequest);
        return "redirect:/horariodisponibles";
    }
    
    @RequestMapping(produces = "text/html")
    public String list(@ModelAttribute Parametros parametros, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    	//(@RequestParam("consultorio") Consultorio consultorio, @RequestParam("profesional") Profesional profesional, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
    	Consultorio consultorio = Consultorio.findConsultorio(parametros.getConsultorioSeleccionado().getId());
    	Profesional profesional = Profesional.findProfesional(parametros.getProfesionalSeleccionado().getId());
    	return findHorarioDisponiblesByConsultorioAndProfesional(consultorio,profesional,page, size, sortFieldName, sortOrder, uiModel);
    	
    }

}
