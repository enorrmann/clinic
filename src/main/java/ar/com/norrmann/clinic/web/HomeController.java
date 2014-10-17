package ar.com.norrmann.clinic.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ar.com.norrmann.clinic.model.Consultorio;
import ar.com.norrmann.clinic.model.Profesional;

@RequestMapping("/")
@Controller
@SessionAttributes({"parametros","profesionalAll","consultorioAll"})
@Scope("request")
public class HomeController {
	
	@Autowired
	Parametros parametros;
	
	
//	public ModelAndView showIndex() {
//		ModelAndView modelAndView = new ModelAndView("index");
//		modelAndView.addObject("parametros", parametros);
//		modelAndView.addObject("profesionals",Profesional.findAllProfesionals());
//		modelAndView.addObject("consultorios",Consultorio.findAllConsultorios());
//		return modelAndView;
//	}

	@RequestMapping(value="/process")
	public String processForm(@ModelAttribute Parametros params) {
//		ModelAndView modelAndView = new ModelAndView("index");
		   return "redirect:/turnoes";
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("index");
		if (!isSet(request,"profesionalAll")){
			List<Profesional> profesionales = Profesional.findAllProfesionals();
			parametros.setProfesionalSeleccionado(profesionales.get(0));
			modelAndView.addObject("profesionalAll", profesionales);
		}
		if (!isSet(request,"consultorioAll")){
			List<Consultorio> consultorios = Consultorio.findAllConsultorios();
			parametros.setConsultorioSeleccionado(consultorios.get(0));
			modelAndView.addObject("consultorioAll", consultorios );
		}
	//	modelAndView.addObject("parametros",parametros);
	return modelAndView;	
	}
	
	private boolean isSet(HttpServletRequest request, String attribute){
		return request.getSession().getAttribute(attribute) != null;
	}
	private void setSessionAttribute(HttpServletRequest request, String attribute,Object value){
		request.getSession().setAttribute(attribute,value);
	}
    
	@RequestMapping(params = "selectDate", produces = "text/html")
    public String selectDate(Model uiModel,@RequestParam(value = "selectDate", required = true) String selectDate) {
		parametros.setFecha(selectDate);
        return "redirect:/turnoes";
    }

}
