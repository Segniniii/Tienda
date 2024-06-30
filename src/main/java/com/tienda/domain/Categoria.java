
package com.tienda.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
        

@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    
    private satic final long serialVersionUID =1L;
    
    @Id
    @GenerateValue(strategy = generationType.IDENTITY)
    @Column (name="id_categoria")
    private Long idCategoria;
    private String description;
    private String rutaImagen;
    private boolean activo;
    
    public Categoria () {
        
    }
    
    public Categoria(String descripcion,String rutaImagen, boolean acttivo) {
        this.description = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
     
}
