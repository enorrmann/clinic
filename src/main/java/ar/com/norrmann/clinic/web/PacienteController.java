package ar.com.norrmann.clinic.web;
import ar.com.norrmann.clinic.model.Paciente;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping("/pacientes")
@Controller
@SessionAttributes({"parametros","profesionals","consultorios"})
@RooWebScaffold(path = "pacientes", formBackingObject = Paciente.class)
public class PacienteController {
}
