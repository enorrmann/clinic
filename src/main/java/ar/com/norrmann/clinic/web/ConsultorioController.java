package ar.com.norrmann.clinic.web;
import ar.com.norrmann.clinic.model.Consultorio;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping("/consultorios")
@Controller
@SessionAttributes({"parametros","profesionals","consultorios"})
@RooWebScaffold(path = "consultorios", formBackingObject = Consultorio.class)
public class ConsultorioController {
}
