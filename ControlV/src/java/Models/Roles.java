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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findByIdRoles", query = "SELECT r FROM Roles r WHERE r.idRoles = :idRoles")
    , @NamedQuery(name = "Roles.findByRol", query = "SELECT r FROM Roles r WHERE r.rol = :rol")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRoles")
    private Integer idRoles;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Rol")
    private String rol;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "DescripcionTex")
    private String descripcionTex;

    public Roles() {
    }

    public Roles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public Roles(Integer idRoles, String rol) {
        this.idRoles = idRoles;
        this.rol = rol;
    }

    public Integer getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcionTex() {
        return descripcionTex;
    }

    public void setDescripcionTex(String descripcionTex) {
        this.descripcionTex = descripcionTex;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoles != null ? idRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idRoles == null && other.idRoles != null) || (this.idRoles != null && !this.idRoles.equals(other.idRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Roles[ idRoles=" + idRoles + " ]";
    }
    
}
