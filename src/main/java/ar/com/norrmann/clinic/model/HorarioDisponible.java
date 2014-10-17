package ar.com.norrmann.clinic.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.equals.RooEquals;

@RooJavaBean
@RooToString
@RooEquals
@RooJpaActiveRecord(finders = { "findHorarioDisponiblesByConsultorioAndProfesional", "findHorarioDisponiblesByConsultorioAndProfesionalAndDia" })
public class HorarioDisponible {

    /**
     */
    @ManyToOne
    private Consultorio consultorio;

    /**
     */
    @ManyToOne
    private Profesional profesional;

    /**
     */
    @ManyToOne
    private Dia dia;

    /**
     */
    private String hora;
}
