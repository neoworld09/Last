/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "cuerponotificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuerponotificacion.findAll", query = "SELECT c FROM Cuerponotificacion c")
    , @NamedQuery(name = "Cuerponotificacion.findByIdcuerponotificacion", query = "SELECT c FROM Cuerponotificacion c WHERE c.idcuerponotificacion = :idcuerponotificacion")
    , @NamedQuery(name = "Cuerponotificacion.findByConcepto", query = "SELECT c FROM Cuerponotificacion c WHERE c.concepto = :concepto")
    , @NamedQuery(name = "Cuerponotificacion.findByAdjunto", query = "SELECT c FROM Cuerponotificacion c WHERE c.adjunto = :adjunto")})
public class Cuerponotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcuerponotificacion")
    private Integer idcuerponotificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 45)
    @Column(name = "adjunto")
    private String adjunto;

    public Cuerponotificacion() {
    }

    public Cuerponotificacion(Integer idcuerponotificacion) {
        this.idcuerponotificacion = idcuerponotificacion;
    }

    public Cuerponotificacion(Integer idcuerponotificacion, String concepto) {
        this.idcuerponotificacion = idcuerponotificacion;
        this.concepto = concepto;
    }

    public Integer getIdcuerponotificacion() {
        return idcuerponotificacion;
    }

    public void setIdcuerponotificacion(Integer idcuerponotificacion) {
        this.idcuerponotificacion = idcuerponotificacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuerponotificacion != null ? idcuerponotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuerponotificacion)) {
            return false;
        }
        Cuerponotificacion other = (Cuerponotificacion) object;
        if ((this.idcuerponotificacion == null && other.idcuerponotificacion != null) || (this.idcuerponotificacion != null && !this.idcuerponotificacion.equals(other.idcuerponotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Cuerponotificacion[ idcuerponotificacion=" + idcuerponotificacion + " ]";
    }
    
}
