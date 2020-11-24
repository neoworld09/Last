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
public class RolesHasPrivilegiosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Roles_idRoles")
    private int rolesidRoles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Privilegios_idPrivilegios")
    private int privilegiosidPrivilegios;

    public RolesHasPrivilegiosPK() {
    }

    public RolesHasPrivilegiosPK(int rolesidRoles, int privilegiosidPrivilegios) {
        this.rolesidRoles = rolesidRoles;
        this.privilegiosidPrivilegios = privilegiosidPrivilegios;
    }

    public int getRolesidRoles() {
        return rolesidRoles;
    }

    public void setRolesidRoles(int rolesidRoles) {
        this.rolesidRoles = rolesidRoles;
    }

    public int getPrivilegiosidPrivilegios() {
        return privilegiosidPrivilegios;
    }

    public void setPrivilegiosidPrivilegios(int privilegiosidPrivilegios) {
        this.privilegiosidPrivilegios = privilegiosidPrivilegios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolesidRoles;
        hash += (int) privilegiosidPrivilegios;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesHasPrivilegiosPK)) {
            return false;
        }
        RolesHasPrivilegiosPK other = (RolesHasPrivilegiosPK) object;
        if (this.rolesidRoles != other.rolesidRoles) {
            return false;
        }
        if (this.privilegiosidPrivilegios != other.privilegiosidPrivilegios) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.RolesHasPrivilegiosPK[ rolesidRoles=" + rolesidRoles + ", privilegiosidPrivilegios=" + privilegiosidPrivilegios + " ]";
    }
    
}
