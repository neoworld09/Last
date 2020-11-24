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
@Table(name = "terceros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terceros.findAll", query = "SELECT t FROM Terceros t")
    , @NamedQuery(name = "Terceros.findByIdtercero", query = "SELECT t FROM Terceros t WHERE t.idtercero = :idtercero")
    , @NamedQuery(name = "Terceros.findByNombre", query = "SELECT t FROM Terceros t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Terceros.findByApellido", query = "SELECT t FROM Terceros t WHERE t.apellido = :apellido")
    , @NamedQuery(name = "Terceros.findByEmail", query = "SELECT t FROM Terceros t WHERE t.email = :email")
    , @NamedQuery(name = "Terceros.findByTeloficina", query = "SELECT t FROM Terceros t WHERE t.teloficina = :teloficina")
    , @NamedQuery(name = "Terceros.findByCelular", query = "SELECT t FROM Terceros t WHERE t.celular = :celular")
    , @NamedQuery(name = "Terceros.findByTipoterceroIdtipoter", query = "SELECT t FROM Terceros t WHERE t.tipoterceroIdtipoter = :tipoterceroIdtipoter")})
public class Terceros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtercero")
    private Long idtercero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido")
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "teloficina")
    private String teloficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipotercero_idtipoter")
    private int tipoterceroIdtipoter;

    public Terceros() {
    }

    public Terceros(Long idtercero) {
        this.idtercero = idtercero;
    }

    public Terceros(Long idtercero, String nombre, String apellido, String email, String celular, int tipoterceroIdtipoter) {
        this.idtercero = idtercero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.tipoterceroIdtipoter = tipoterceroIdtipoter;
    }

    public Long getIdtercero() {
        return idtercero;
    }

    public void setIdtercero(Long idtercero) {
        this.idtercero = idtercero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeloficina() {
        return teloficina;
    }

    public void setTeloficina(String teloficina) {
        this.teloficina = teloficina;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getTipoterceroIdtipoter() {
        return tipoterceroIdtipoter;
    }

    public void setTipoterceroIdtipoter(int tipoterceroIdtipoter) {
        this.tipoterceroIdtipoter = tipoterceroIdtipoter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtercero != null ? idtercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terceros)) {
            return false;
        }
        Terceros other = (Terceros) object;
        if ((this.idtercero == null && other.idtercero != null) || (this.idtercero != null && !this.idtercero.equals(other.idtercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Terceros[ idtercero=" + idtercero + " ]";
    }
    
}
