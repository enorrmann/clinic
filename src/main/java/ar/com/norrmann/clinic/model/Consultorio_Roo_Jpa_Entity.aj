// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.com.norrmann.clinic.model;

import ar.com.norrmann.clinic.model.Consultorio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Consultorio_Roo_Jpa_Entity {
    
    declare @type: Consultorio: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Consultorio.id;
    
    @Version
    @Column(name = "version")
    private Integer Consultorio.version;
    
    public Long Consultorio.getId() {
        return this.id;
    }
    
    public void Consultorio.setId(Long id) {
        this.id = id;
    }
    
    public Integer Consultorio.getVersion() {
        return this.version;
    }
    
    public void Consultorio.setVersion(Integer version) {
        this.version = version;
    }
    
}
