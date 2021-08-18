
package com.py.columbia.pr2.nildandrergio.springrestpaises.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Departamento extends Audit {
    @Id
    @GeneratedValue (generator = "generator departamento")
    @SequenceGenerator(
            name ="generator departamento",
            sequenceName = "departamento sequence_id",
            initialValue = 100
    )
    private Long id;
    @Column(columnDefinition = "text")
    private String nombre;
    
    @ManyToOne (fetch = FetchType.LAZY, optional =false)
    @JoinColumn(name = "pais_id", nullable = false)
    @JsonIgnore
    private Departamento departamento;

    public Departamento(String nombre, Departamento departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
