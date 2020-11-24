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
@Table(name = "tiponotificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiponotificacion.findAll", query = "SELECT t FROM Tiponotificacion t")
    , @NamedQuery(name = "Tiponotificacion.findByIdtiponotificacion", query = "SELECT t FROM Tiponotificacion t WHERE t.idtiponotificacion = :idtiponotificacion")
    , @NamedQuery(name = "Tiponotificacion.findByNombrenotificacion", query = "SELECT t FROM Tiponotificacion t WHERE t.nombrenotificacion = :nombrenotificacion")
    , @NamedQuery(name = "Tiponotificacion.findByDescripcionNotificacion", query = "SELECT t FROM Tiponotificacion t WHERE t.descripcionNotificacion = :descripcionNotificacion")})
public class Tiponotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtiponotificacion")
    private Integer idtiponotificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrenotificacion")
    private String nombrenotificacion;
    @Size(max = 45)
    @Column(name = "descripcion notificacion")
    private String descripcionNotificacion;

    public Tiponotificacion() {
    }

    public Tiponotificacion(Integer idtiponotificacion) {
        this.idtiponotificacion = idtiponotificacion;
    }

    public Tiponotificacion(Integer idtiponotificacion, String nombrenotificacion) {
        this.idtiponotificacion = idtiponotificacion;
        this.nombrenotificacion = nombrenotificacion;
    }

    public Integer getIdtiponotificacion() {
        return idtiponotificacion;
    }

    public void setIdtiponotificacion(Integer idtiponotificacion) {
        this.idtiponotificacion = idtiponotificacion;
    }

    public String getNombrenotificacion() {
        return nombrenotificacion;
    }

    public void setNombrenotificacion(String nombrenotificacion) {
        this.nombrenotificacion = nombrenotificacion;
    }

    public String getDescripcionNotificacion() {
        return descripcionNotificacion;
    }

    public void setDescripcionNotificacion(String descripcionNotificacion) {
        this.descripcionNotificacion = descripcionNotificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiponotificacion != null ? idtiponotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiponotificacion)) {
            return false;
        }
        Tiponotificacion other = (Tiponotificacion) object;
        if ((this.idtiponotificacion == null && other.idtiponotificacion != null) || (this.idtiponotificacion != null && !this.idtiponotificacion.equals(other.idtiponotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tiponotificacion[ idtiponotificacion=" + idtiponotificacion + " ]";
    }
    
}
