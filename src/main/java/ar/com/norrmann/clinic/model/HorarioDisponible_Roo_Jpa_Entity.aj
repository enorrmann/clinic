// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ar.com.norrmann.clinic.model;

import ar.com.norrmann.clinic.model.HorarioDisponible;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect HorarioDisponible_Roo_Jpa_Entity {
    
    declare @type: HorarioDisponible: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long HorarioDisponible.id;
    
    @Version
    @Column(name = "version")
    private Integer HorarioDisponible.version;
    
    public Long HorarioDisponible.getId() {
        return this.id;
    }
    
    public void HorarioDisponible.setId(Long id) {
        this.id = id;
    }
    
    public Integer HorarioDisponible.getVersion() {
        return this.version;
    }
    
    public void HorarioDisponible.setVersion(Integer version) {
        this.version = version;
    }
    
}
