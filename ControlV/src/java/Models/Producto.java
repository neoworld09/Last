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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto")
    , @NamedQuery(name = "Producto.findByNombreproducto", query = "SELECT p FROM Producto p WHERE p.nombreproducto = :nombreproducto")
    , @NamedQuery(name = "Producto.findByPresentacion", query = "SELECT p FROM Producto p WHERE p.presentacion = :presentacion")
    , @NamedQuery(name = "Producto.findByPesopresentacion", query = "SELECT p FROM Producto p WHERE p.pesopresentacion = :pesopresentacion")
    , @NamedQuery(name = "Producto.findByLote", query = "SELECT p FROM Producto p WHERE p.lote = :lote")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreproducto")
    private String nombreproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "presentacion")
    private String presentacion;
    @Size(max = 10)
    @Column(name = "pesopresentacion")
    private String pesopresentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lote")
    private int lote;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, String nombreproducto, String presentacion, int lote) {
        this.idproducto = idproducto;
        this.nombreproducto = nombreproducto;
        this.presentacion = presentacion;
        this.lote = lote;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getPesopresentacion() {
        return pesopresentacion;
    }

    public void setPesopresentacion(String pesopresentacion) {
        this.pesopresentacion = pesopresentacion;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
