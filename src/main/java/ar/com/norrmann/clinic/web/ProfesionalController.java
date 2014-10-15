package ar.com.norrmann.clinic.web;
import ar.com.norrmann.clinic.model.Profesional;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping("/profesionals")
@Controller
@SessionAttributes({"parametros","profesionals","consultorios"})
@RooWebScaffold(path = "profesionals", formBackingObject = Profesional.class)
public class ProfesionalController {
}
