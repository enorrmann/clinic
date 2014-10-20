package ar.com.norrmann.clinic.model;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.plural.RooPlural;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findTurnoesByConsultorioAndProfesionalAndFechaEquals", "findTurnoesByConsultorioAndProfesionalAndFecha" })
public class Turno {

    /**
     */
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date fecha;

    /**
     */
    private String hora;

    /**
     */
    @ManyToOne
    private Profesional profesional;

    /**
     */
    @ManyToOne
    private Paciente paciente;

    /**
     */
    @ManyToOne
    private Consultorio consultorio;
}
