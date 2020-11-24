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
import javax.persistence.Lob;
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
@Table(name = "tipotercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotercero.findAll", query = "SELECT t FROM Tipotercero t")
    , @NamedQuery(name = "Tipotercero.findByIdtipoter", query = "SELECT t FROM Tipotercero t WHERE t.idtipoter = :idtipoter")
    , @NamedQuery(name = "Tipotercero.findByTipoter", query = "SELECT t FROM Tipotercero t WHERE t.tipoter = :tipoter")
    , @NamedQuery(name = "Tipotercero.findByTipopersona", query = "SELECT t FROM Tipotercero t WHERE t.tipopersona = :tipopersona")})
public class Tipotercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoter")
    private Integer idtipoter;
    @Size(max = 45)
    @Column(name = "tipoter")
    private String tipoter;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipopersona")
    private short tipopersona;

    public Tipotercero() {
    }

    public Tipotercero(Integer idtipoter) {
        this.idtipoter = idtipoter;
    }

    public Tipotercero(Integer idtipoter, short tipopersona) {
        this.idtipoter = idtipoter;
        this.tipopersona = tipopersona;
    }

    public Integer getIdtipoter() {
        return idtipoter;
    }

    public void setIdtipoter(Integer idtipoter) {
        this.idtipoter = idtipoter;
    }

    public String getTipoter() {
        return tipoter;
    }

    public void setTipoter(String tipoter) {
        this.tipoter = tipoter;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(short tipopersona) {
        this.tipopersona = tipopersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoter != null ? idtipoter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotercero)) {
            return false;
        }
        Tipotercero other = (Tipotercero) object;
        if ((this.idtipoter == null && other.idtipoter != null) || (this.idtipoter != null && !this.idtipoter.equals(other.idtipoter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tipotercero[ idtipoter=" + idtipoter + " ]";
    }
    
}
