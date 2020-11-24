/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "rolestercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolestercero.findAll", query = "SELECT r FROM Rolestercero r")
    , @NamedQuery(name = "Rolestercero.findByRolesidRoles", query = "SELECT r FROM Rolestercero r WHERE r.rolesterceroPK.rolesidRoles = :rolesidRoles")
    , @NamedQuery(name = "Rolestercero.findByFechaAlta", query = "SELECT r FROM Rolestercero r WHERE r.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Rolestercero.findByEnable", query = "SELECT r FROM Rolestercero r WHERE r.enable = :enable")
    , @NamedQuery(name = "Rolestercero.findByRoleshasTercerocol", query = "SELECT r FROM Rolestercero r WHERE r.rolesterceroPK.roleshasTercerocol = :roleshasTercerocol")})
public class Rolestercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolesterceroPK rolesterceroPK;
    @Column(name = "fechaAlta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Size(max = 45)
    @Column(name = "Enable")
    private String enable;

    public Rolestercero() {
    }

    public Rolestercero(RolesterceroPK rolesterceroPK) {
        this.rolesterceroPK = rolesterceroPK;
    }

    public Rolestercero(int rolesidRoles, short roleshasTercerocol) {
        this.rolesterceroPK = new RolesterceroPK(rolesidRoles, roleshasTercerocol);
    }

    public RolesterceroPK getRolesterceroPK() {
        return rolesterceroPK;
    }

    public void setRolesterceroPK(RolesterceroPK rolesterceroPK) {
        this.rolesterceroPK = rolesterceroPK;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolesterceroPK != null ? rolesterceroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolestercero)) {
            return false;
        }
        Rolestercero other = (Rolestercero) object;
        if ((this.rolesterceroPK == null && other.rolesterceroPK != null) || (this.rolesterceroPK != null && !this.rolesterceroPK.equals(other.rolesterceroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Rolestercero[ rolesterceroPK=" + rolesterceroPK + " ]";
    }
    
}
