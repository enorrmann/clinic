package ar.com.norrmann.clinic.web;
import ar.com.norrmann.clinic.model.Turno;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping("/turnoes")
@Controller
@RooWebScaffold(path = "turnoes", formBackingObject = Turno.class)
@SessionAttributes({ "parametros" })
public class TurnoController {
}
