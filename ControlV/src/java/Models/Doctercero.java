/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "doctercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctercero.findAll", query = "SELECT d FROM Doctercero d")
    , @NamedQuery(name = "Doctercero.findByIddoc", query = "SELECT d FROM Doctercero d WHERE d.iddoc = :iddoc")
    , @NamedQuery(name = "Doctercero.findByLictransito", query = "SELECT d FROM Doctercero d WHERE d.lictransito = :lictransito")
    , @NamedQuery(name = "Doctercero.findByFechaexplictransito", query = "SELECT d FROM Doctercero d WHERE d.fechaexplictransito = :fechaexplictransito")
    , @NamedQuery(name = "Doctercero.findByFechaveclictransito", query = "SELECT d FROM Doctercero d WHERE d.fechaveclictransito = :fechaveclictransito")
    , @NamedQuery(name = "Doctercero.findByIddocalimentos", query = "SELECT d FROM Doctercero d WHERE d.iddocalimentos = :iddocalimentos")
    , @NamedQuery(name = "Doctercero.findByFechaexpdocalimentos", query = "SELECT d FROM Doctercero d WHERE d.fechaexpdocalimentos = :fechaexpdocalimentos")
    , @NamedQuery(name = "Doctercero.findByFechavendocalimentos", query = "SELECT d FROM Doctercero d WHERE d.fechavendocalimentos = :fechavendocalimentos")
    , @NamedQuery(name = "Doctercero.findByTercerosIdtercero", query = "SELECT d FROM Doctercero d WHERE d.tercerosIdtercero = :tercerosIdtercero")})
public class Doctercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddoc")
    private Integer iddoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lictransito")
    private int lictransito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaexplictransito")
    @Temporal(TemporalType.DATE)
    private Date fechaexplictransito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaveclictransito")
    @Temporal(TemporalType.DATE)
    private Date fechaveclictransito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddocalimentos")
    private int iddocalimentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaexpdocalimentos")
    @Temporal(TemporalType.DATE)
    private Date fechaexpdocalimentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechavendocalimentos")
    @Temporal(TemporalType.DATE)
    private Date fechavendocalimentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "terceros_idtercero")
    private long tercerosIdtercero;

    public Doctercero() {
    }

    public Doctercero(Integer iddoc) {
        this.iddoc = iddoc;
    }

    public Doctercero(Integer iddoc, int lictransito, Date fechaexplictransito, Date fechaveclictransito, int iddocalimentos, Date fechaexpdocalimentos, Date fechavendocalimentos, long tercerosIdtercero) {
        this.iddoc = iddoc;
        this.lictransito = lictransito;
        this.fechaexplictransito = fechaexplictransito;
        this.fechaveclictransito = fechaveclictransito;
        this.iddocalimentos = iddocalimentos;
        this.fechaexpdocalimentos = fechaexpdocalimentos;
        this.fechavendocalimentos = fechavendocalimentos;
        this.tercerosIdtercero = tercerosIdtercero;
    }

    public Integer getIddoc() {
        return iddoc;
    }

    public void setIddoc(Integer iddoc) {
        this.iddoc = iddoc;
    }

    public int getLictransito() {
        return lictransito;
    }

    public void setLictransito(int lictransito) {
        this.lictransito = lictransito;
    }

    public Date getFechaexplictransito() {
        return fechaexplictransito;
    }

    public void setFechaexplictransito(Date fechaexplictransito) {
        this.fechaexplictransito = fechaexplictransito;
    }

    public Date getFechaveclictransito() {
        return fechaveclictransito;
    }

    public void setFechaveclictransito(Date fechaveclictransito) {
        this.fechaveclictransito = fechaveclictransito;
    }

    public int getIddocalimentos() {
        return iddocalimentos;
    }

    public void setIddocalimentos(int iddocalimentos) {
        this.iddocalimentos = iddocalimentos;
    }

    public Date getFechaexpdocalimentos() {
        return fechaexpdocalimentos;
    }

    public void setFechaexpdocalimentos(Date fechaexpdocalimentos) {
        this.fechaexpdocalimentos = fechaexpdocalimentos;
    }

    public Date getFechavendocalimentos() {
        return fechavendocalimentos;
    }

    public void setFechavendocalimentos(Date fechavendocalimentos) {
        this.fechavendocalimentos = fechavendocalimentos;
    }

    public long getTercerosIdtercero() {
        return tercerosIdtercero;
    }

    public void setTercerosIdtercero(long tercerosIdtercero) {
        this.tercerosIdtercero = tercerosIdtercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoc != null ? iddoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctercero)) {
            return false;
        }
        Doctercero other = (Doctercero) object;
        if ((this.iddoc == null && other.iddoc != null) || (this.iddoc != null && !this.iddoc.equals(other.iddoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Doctercero[ iddoc=" + iddoc + " ]";
    }
    
}
