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
@Table(name = "privilegios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegios.findAll", query = "SELECT p FROM Privilegios p")
    , @NamedQuery(name = "Privilegios.findByIdPrivilegios", query = "SELECT p FROM Privilegios p WHERE p.idPrivilegios = :idPrivilegios")
    , @NamedQuery(name = "Privilegios.findByPrivilegios", query = "SELECT p FROM Privilegios p WHERE p.privilegios = :privilegios")
    , @NamedQuery(name = "Privilegios.findByPrivilegioscol", query = "SELECT p FROM Privilegios p WHERE p.privilegioscol = :privilegioscol")})
public class Privilegios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPrivilegios")
    private Integer idPrivilegios;
    @Size(max = 45)
    @Column(name = "Privilegios")
    private String privilegios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Privilegioscol")
    private String privilegioscol;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Descripcion")
    private String descripcion;

    public Privilegios() {
    }

    public Privilegios(Integer idPrivilegios) {
        this.idPrivilegios = idPrivilegios;
    }

    public Privilegios(Integer idPrivilegios, String privilegioscol) {
        this.idPrivilegios = idPrivilegios;
        this.privilegioscol = privilegioscol;
    }

    public Integer getIdPrivilegios() {
        return idPrivilegios;
    }

    public void setIdPrivilegios(Integer idPrivilegios) {
        this.idPrivilegios = idPrivilegios;
    }

    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }

    public String getPrivilegioscol() {
        return privilegioscol;
    }

    public void setPrivilegioscol(String privilegioscol) {
        this.privilegioscol = privilegioscol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegios != null ? idPrivilegios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegios)) {
            return false;
        }
        Privilegios other = (Privilegios) object;
        if ((this.idPrivilegios == null && other.idPrivilegios != null) || (this.idPrivilegios != null && !this.idPrivilegios.equals(other.idPrivilegios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Privilegios[ idPrivilegios=" + idPrivilegios + " ]";
    }
    
}
