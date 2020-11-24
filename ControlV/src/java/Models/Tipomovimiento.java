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
@Table(name = "tipomovimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomovimiento.findAll", query = "SELECT t FROM Tipomovimiento t")
    , @NamedQuery(name = "Tipomovimiento.findByIdtipomovimiento", query = "SELECT t FROM Tipomovimiento t WHERE t.idtipomovimiento = :idtipomovimiento")
    , @NamedQuery(name = "Tipomovimiento.findByTiposalida", query = "SELECT t FROM Tipomovimiento t WHERE t.tiposalida = :tiposalida")
    , @NamedQuery(name = "Tipomovimiento.findByTipoingreso", query = "SELECT t FROM Tipomovimiento t WHERE t.tipoingreso = :tipoingreso")})
public class Tipomovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipomovimiento")
    private Integer idtipomovimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tiposalida")
    private String tiposalida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoingreso")
    private String tipoingreso;

    public Tipomovimiento() {
    }

    public Tipomovimiento(Integer idtipomovimiento) {
        this.idtipomovimiento = idtipomovimiento;
    }

    public Tipomovimiento(Integer idtipomovimiento, String tiposalida, String tipoingreso) {
        this.idtipomovimiento = idtipomovimiento;
        this.tiposalida = tiposalida;
        this.tipoingreso = tipoingreso;
    }

    public Integer getIdtipomovimiento() {
        return idtipomovimiento;
    }

    public void setIdtipomovimiento(Integer idtipomovimiento) {
        this.idtipomovimiento = idtipomovimiento;
    }

    public String getTiposalida() {
        return tiposalida;
    }

    public void setTiposalida(String tiposalida) {
        this.tiposalida = tiposalida;
    }

    public String getTipoingreso() {
        return tipoingreso;
    }

    public void setTipoingreso(String tipoingreso) {
        this.tipoingreso = tipoingreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipomovimiento != null ? idtipomovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomovimiento)) {
            return false;
        }
        Tipomovimiento other = (Tipomovimiento) object;
        if ((this.idtipomovimiento == null && other.idtipomovimiento != null) || (this.idtipomovimiento != null && !this.idtipomovimiento.equals(other.idtipomovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Tipomovimiento[ idtipomovimiento=" + idtipomovimiento + " ]";
    }
    
}
