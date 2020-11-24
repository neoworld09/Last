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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "registroproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroproductos.findAll", query = "SELECT r FROM Registroproductos r")
    , @NamedQuery(name = "Registroproductos.findByIdRegistroproducto", query = "SELECT r FROM Registroproductos r WHERE r.idRegistroproducto = :idRegistroproducto")
    , @NamedQuery(name = "Registroproductos.findByRegistroidRegistro", query = "SELECT r FROM Registroproductos r WHERE r.registroidRegistro = :registroidRegistro")
    , @NamedQuery(name = "Registroproductos.findByProductoIdproducto", query = "SELECT r FROM Registroproductos r WHERE r.productoIdproducto = :productoIdproducto")})
public class Registroproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_registroproducto")
    private Integer idRegistroproducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Registro_idRegistro")
    private int registroidRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "producto_idproducto")
    private int productoIdproducto;

    public Registroproductos() {
    }

    public Registroproductos(Integer idRegistroproducto) {
        this.idRegistroproducto = idRegistroproducto;
    }

    public Registroproductos(Integer idRegistroproducto, int registroidRegistro, int productoIdproducto) {
        this.idRegistroproducto = idRegistroproducto;
        this.registroidRegistro = registroidRegistro;
        this.productoIdproducto = productoIdproducto;
    }

    public Integer getIdRegistroproducto() {
        return idRegistroproducto;
    }

    public void setIdRegistroproducto(Integer idRegistroproducto) {
        this.idRegistroproducto = idRegistroproducto;
    }

    public int getRegistroidRegistro() {
        return registroidRegistro;
    }

    public void setRegistroidRegistro(int registroidRegistro) {
        this.registroidRegistro = registroidRegistro;
    }

    public int getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(int productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroproducto != null ? idRegistroproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroproductos)) {
            return false;
        }
        Registroproductos other = (Registroproductos) object;
        if ((this.idRegistroproducto == null && other.idRegistroproducto != null) || (this.idRegistroproducto != null && !this.idRegistroproducto.equals(other.idRegistroproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Registroproductos[ idRegistroproducto=" + idRegistroproducto + " ]";
    }
    
}
