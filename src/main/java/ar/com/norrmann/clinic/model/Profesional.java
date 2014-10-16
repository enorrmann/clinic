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
public class Profesional {

    /**
     */
    private String apellido;

    /**
     */
    private String nombres;

    /**
     */
    private String tratamiento = "Dr.";
    
    public String getNombreLargo(){
    	return tratamiento+" "+apellido+", "+nombres;
    }
    public String toString(){
    	return getNombreLargo();
    }

}
