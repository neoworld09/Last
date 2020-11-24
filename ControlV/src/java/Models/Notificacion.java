/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificacion.findAll", query = "SELECT n FROM Notificacion n")
    , @NamedQuery(name = "Notificacion.findByIdnoti", query = "SELECT n FROM Notificacion n WHERE n.idnoti = :idnoti")
    , @NamedQuery(name = "Notificacion.findByTiponotificacionIdtiponotificacion", query = "SELECT n FROM Notificacion n WHERE n.tiponotificacionIdtiponotificacion = :tiponotificacionIdtiponotificacion")
    , @NamedQuery(name = "Notificacion.findByCuerponotificacionIdcuerponotificacion", query = "SELECT n FROM Notificacion n WHERE n.cuerponotificacionIdcuerponotificacion = :cuerponotificacionIdcuerponotificacion")
    , @NamedQuery(name = "Notificacion.findByTerceroreceptor", query = "SELECT n FROM Notificacion n WHERE n.terceroreceptor = :terceroreceptor")
    , @NamedQuery(name = "Notificacion.findByFechaenvionoti", query = "SELECT n FROM Notificacion n WHERE n.fechaenvionoti = :fechaenvionoti")
    , @NamedQuery(name = "Notificacion.findByTercerosIdtercero", query = "SELECT n FROM Notificacion n WHERE n.tercerosIdtercero = :tercerosIdtercero")})
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnoti")
    private Integer idnoti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiponotificacion_idtiponotificacion")
    private int tiponotificacionIdtiponotificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuerponotificacion_idcuerponotificacion")
    private int cuerponotificacionIdcuerponotificacion;
    @Size(max = 45)
    @Column(name = "terceroreceptor")
    private String terceroreceptor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaenvionoti")
    @Temporal(TemporalType.DATE)
    private Date fechaenvionoti;
    @Basic(optional = false)
    @NotNull
    @Column(name = "terceros_idtercero")
    private long tercerosIdtercero;

    public Notificacion() {
    }

    public Notificacion(Integer idnoti) {
        this.idnoti = idnoti;
    }

    public Notificacion(Integer idnoti, int tiponotificacionIdtiponotificacion, int cuerponotificacionIdcuerponotificacion, Date fechaenvionoti, long tercerosIdtercero) {
        this.idnoti = idnoti;
        this.tiponotificacionIdtiponotificacion = tiponotificacionIdtiponotificacion;
        this.cuerponotificacionIdcuerponotificacion = cuerponotificacionIdcuerponotificacion;
        this.fechaenvionoti = fechaenvionoti;
        this.tercerosIdtercero = tercerosIdtercero;
    }

    public Integer getIdnoti() {
        return idnoti;
    }

    public void setIdnoti(Integer idnoti) {
        this.idnoti = idnoti;
    }

    public int getTiponotificacionIdtiponotificacion() {
        return tiponotificacionIdtiponotificacion;
    }

    public void setTiponotificacionIdtiponotificacion(int tiponotificacionIdtiponotificacion) {
        this.tiponotificacionIdtiponotificacion = tiponotificacionIdtiponotificacion;
    }

    public int getCuerponotificacionIdcuerponotificacion() {
        return cuerponotificacionIdcuerponotificacion;
    }

    public void setCuerponotificacionIdcuerponotificacion(int cuerponotificacionIdcuerponotificacion) {
        this.cuerponotificacionIdcuerponotificacion = cuerponotificacionIdcuerponotificacion;
    }

    public String getTerceroreceptor() {
        return terceroreceptor;
    }

    public void setTerceroreceptor(String terceroreceptor) {
        this.terceroreceptor = terceroreceptor;
    }

    public Date getFechaenvionoti() {
        return fechaenvionoti;
    }

    public void setFechaenvionoti(Date fechaenvionoti) {
        this.fechaenvionoti = fechaenvionoti;
    }

    public long getTercerosIdtercero() {
        return tercerosIdtercero;
    }

    public void setTercerosIdtercero(long tercerosIdtercero) {
        this.tercerosIdtercero = tercerosIdtercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnoti != null ? idnoti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notificacion)) {
            return false;
        }
        Notificacion other = (Notificacion) object;
        if ((this.idnoti == null && other.idnoti != null) || (this.idnoti != null && !this.idnoti.equals(other.idnoti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Notificacion[ idnoti=" + idnoti + " ]";
    }
    
}
