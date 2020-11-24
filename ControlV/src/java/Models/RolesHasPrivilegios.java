/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "roles_has_privilegios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesHasPrivilegios.findAll", query = "SELECT r FROM RolesHasPrivilegios r")
    , @NamedQuery(name = "RolesHasPrivilegios.findByRolesidRoles", query = "SELECT r FROM RolesHasPrivilegios r WHERE r.rolesHasPrivilegiosPK.rolesidRoles = :rolesidRoles")
    , @NamedQuery(name = "RolesHasPrivilegios.findByPrivilegiosidPrivilegios", query = "SELECT r FROM RolesHasPrivilegios r WHERE r.rolesHasPrivilegiosPK.privilegiosidPrivilegios = :privilegiosidPrivilegios")})
public class RolesHasPrivilegios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolesHasPrivilegiosPK rolesHasPrivilegiosPK;

    public RolesHasPrivilegios() {
    }

    public RolesHasPrivilegios(RolesHasPrivilegiosPK rolesHasPrivilegiosPK) {
        this.rolesHasPrivilegiosPK = rolesHasPrivilegiosPK;
    }

    public RolesHasPrivilegios(int rolesidRoles, int privilegiosidPrivilegios) {
        this.rolesHasPrivilegiosPK = new RolesHasPrivilegiosPK(rolesidRoles, privilegiosidPrivilegios);
    }

    public RolesHasPrivilegiosPK getRolesHasPrivilegiosPK() {
        return rolesHasPrivilegiosPK;
    }

    public void setRolesHasPrivilegiosPK(RolesHasPrivilegiosPK rolesHasPrivilegiosPK) {
        this.rolesHasPrivilegiosPK = rolesHasPrivilegiosPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolesHasPrivilegiosPK != null ? rolesHasPrivilegiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesHasPrivilegios)) {
            return false;
        }
        RolesHasPrivilegios other = (RolesHasPrivilegios) object;
        if ((this.rolesHasPrivilegiosPK == null && other.rolesHasPrivilegiosPK != null) || (this.rolesHasPrivilegiosPK != null && !this.rolesHasPrivilegiosPK.equals(other.rolesHasPrivilegiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.RolesHasPrivilegios[ rolesHasPrivilegiosPK=" + rolesHasPrivilegiosPK + " ]";
    }
    
}
