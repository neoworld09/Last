/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Neo
 */
@Embeddable
public class RolesterceroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Roles_idRoles")
    private int rolesidRoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Roles_has_Tercerocol")
    private short roleshasTercerocol;

    public RolesterceroPK() {
    }

    public RolesterceroPK(int rolesidRoles, short roleshasTercerocol) {
        this.rolesidRoles = rolesidRoles;
        this.roleshasTercerocol = roleshasTercerocol;
    }

    public int getRolesidRoles() {
        return rolesidRoles;
    }

    public void setRolesidRoles(int rolesidRoles) {
        this.rolesidRoles = rolesidRoles;
    }

    public short getRoleshasTercerocol() {
        return roleshasTercerocol;
    }

    public void setRoleshasTercerocol(short roleshasTercerocol) {
        this.roleshasTercerocol = roleshasTercerocol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolesidRoles;
        hash += (int) roleshasTercerocol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesterceroPK)) {
            return false;
        }
        RolesterceroPK other = (RolesterceroPK) object;
        if (this.rolesidRoles != other.rolesidRoles) {
            return false;
        }
        if (this.roleshasTercerocol != other.roleshasTercerocol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.RolesterceroPK[ rolesidRoles=" + rolesidRoles + ", roleshasTercerocol=" + roleshasTercerocol + " ]";
    }
    
}
