package ar.com.norrmann.clinic.model;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord
@RooEquals
@RooSerializable
public class Consultorio {

    /**
     */
    private String nombre;

    /**
     */
    private String domicilio;

    /**
     */
    private String telefonos;
    
    public String toString(){
    	return nombre;
    }
}
