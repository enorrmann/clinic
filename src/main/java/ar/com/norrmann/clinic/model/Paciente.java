package ar.com.norrmann.clinic.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Paciente {

    /**
     */
    private String apellido;

    /**
     */
    private String nombres;

    /**
     */
    private String documento;

    /**
     */
    private String telefonos;

    /**
     */
    private String domicilio;

    /**
     */
    private String sexo;

    /**
     */
    private String email;

    /**
     */
    private String observaciones;
}
