
package com.py.columbia.pr2.nildandrergio.springrestpaises.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Pais extends Audit {
    @Id
    @GeneratedValue(generator = "generator pais")
    @SequenceGenerator (
            name = "generator pais", 
            sequenceName = "pais_sequence_id",
            initialValue = 100
    )
    private Long id;
    
    @NotBlank
    @Size(min = 3, max = 100)
    private String nombre;
    
    @Column(columnDefinition = "text")
    private String descripcion;
    
    public Pais (){
        
    }

    public Pais(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Pais other = (Pais) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Pais{" + 
                "id=" + id + 
                ", nombre=" + nombre +
                ", descripcion=" + descripcion + 
                '}';
    }

    public void setPais(Pais pais) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
