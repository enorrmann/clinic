// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.com.norrmann.clinic.model;

import ar.com.norrmann.clinic.model.Turno;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Turno_Roo_Jpa_Entity {
    
    declare @type: Turno: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Turno.id;
    
    @Version
    @Column(name = "version")
    private Integer Turno.version;
    
    public Long Turno.getId() {
        return this.id;
    }
    
    public void Turno.setId(Long id) {
        this.id = id;
    }
    
    public Integer Turno.getVersion() {
        return this.version;
    }
    
    public void Turno.setVersion(Integer version) {
        this.version = version;
    }
    
}
