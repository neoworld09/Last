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
@Table(name = "docvehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docvehiculo.findAll", query = "SELECT d FROM Docvehiculo d")
    , @NamedQuery(name = "Docvehiculo.findByIddocvehiculo", query = "SELECT d FROM Docvehiculo d WHERE d.iddocvehiculo = :iddocvehiculo")
    , @NamedQuery(name = "Docvehiculo.findBySoat", query = "SELECT d FROM Docvehiculo d WHERE d.soat = :soat")
    , @NamedQuery(name = "Docvehiculo.findByRevTecnomecanica", query = "SELECT d FROM Docvehiculo d WHERE d.revTecnomecanica = :revTecnomecanica")
    , @NamedQuery(name = "Docvehiculo.findByPerCirculacion", query = "SELECT d FROM Docvehiculo d WHERE d.perCirculacion = :perCirculacion")
    , @NamedQuery(name = "Docvehiculo.findByIdtarjetapropiedad", query = "SELECT d FROM Docvehiculo d WHERE d.idtarjetapropiedad = :idtarjetapropiedad")
    , @NamedQuery(name = "Docvehiculo.findByVehiculoMatricula", query = "SELECT d FROM Docvehiculo d WHERE d.vehiculoMatricula = :vehiculoMatricula")})
public class Docvehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddocvehiculo")
    private Integer iddocvehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "SOAT")
    private String soat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "RevTecnomecanica")
    private String revTecnomecanica;
    @Size(max = 45)
    @Column(name = "PerCirculacion")
    private String perCirculacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "idtarjetapropiedad")
    private String idtarjetapropiedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vehiculo_matricula")
    private String vehiculoMatricula;

    public Docvehiculo() {
    }

    public Docvehiculo(Integer iddocvehiculo) {
        this.iddocvehiculo = iddocvehiculo;
    }

    public Docvehiculo(Integer iddocvehiculo, String soat, String revTecnomecanica, String idtarjetapropiedad, String vehiculoMatricula) {
        this.iddocvehiculo = iddocvehiculo;
        this.soat = soat;
        this.revTecnomecanica = revTecnomecanica;
        this.idtarjetapropiedad = idtarjetapropiedad;
        this.vehiculoMatricula = vehiculoMatricula;
    }

    public Integer getIddocvehiculo() {
        return iddocvehiculo;
    }

    public void setIddocvehiculo(Integer iddocvehiculo) {
        this.iddocvehiculo = iddocvehiculo;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public String getRevTecnomecanica() {
        return revTecnomecanica;
    }

    public void setRevTecnomecanica(String revTecnomecanica) {
        this.revTecnomecanica = revTecnomecanica;
    }

    public String getPerCirculacion() {
        return perCirculacion;
    }

    public void setPerCirculacion(String perCirculacion) {
        this.perCirculacion = perCirculacion;
    }

    public String getIdtarjetapropiedad() {
        return idtarjetapropiedad;
    }

    public void setIdtarjetapropiedad(String idtarjetapropiedad) {
        this.idtarjetapropiedad = idtarjetapropiedad;
    }

    public String getVehiculoMatricula() {
        return vehiculoMatricula;
    }

    public void setVehiculoMatricula(String vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocvehiculo != null ? iddocvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docvehiculo)) {
            return false;
        }
        Docvehiculo other = (Docvehiculo) object;
        if ((this.iddocvehiculo == null && other.iddocvehiculo != null) || (this.iddocvehiculo != null && !this.iddocvehiculo.equals(other.iddocvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Docvehiculo[ iddocvehiculo=" + iddocvehiculo + " ]";
    }
    
}
