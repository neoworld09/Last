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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Neo
 */
@Entity
@Table(name = "registro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")
    , @NamedQuery(name = "Registro.findByIdregistro", query = "SELECT r FROM Registro r WHERE r.idregistro = :idregistro")
    , @NamedQuery(name = "Registro.findByTipomovimientoIdtipomovimiento", query = "SELECT r FROM Registro r WHERE r.tipomovimientoIdtipomovimiento = :tipomovimientoIdtipomovimiento")
    , @NamedQuery(name = "Registro.findByHoraFecha", query = "SELECT r FROM Registro r WHERE r.horaFecha = :horaFecha")
    , @NamedQuery(name = "Registro.findByOrigen", query = "SELECT r FROM Registro r WHERE r.origen = :origen")
    , @NamedQuery(name = "Registro.findByDestino", query = "SELECT r FROM Registro r WHERE r.destino = :destino")
    , @NamedQuery(name = "Registro.findByPesototal", query = "SELECT r FROM Registro r WHERE r.pesototal = :pesototal")
    , @NamedQuery(name = "Registro.findByVehiculoMatricula", query = "SELECT r FROM Registro r WHERE r.vehiculoMatricula = :vehiculoMatricula")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idregistro")
    private Integer idregistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipomovimiento_idtipomovimiento")
    private int tipomovimientoIdtipomovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "destino")
    private String destino;
    @Column(name = "pesototal")
    private Integer pesototal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "vehiculo_matricula")
    private String vehiculoMatricula;

    public Registro() {
    }

    public Registro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Registro(Integer idregistro, int tipomovimientoIdtipomovimiento, Date horaFecha, String origen, String destino, String vehiculoMatricula) {
        this.idregistro = idregistro;
        this.tipomovimientoIdtipomovimiento = tipomovimientoIdtipomovimiento;
        this.horaFecha = horaFecha;
        this.origen = origen;
        this.destino = destino;
        this.vehiculoMatricula = vehiculoMatricula;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public int getTipomovimientoIdtipomovimiento() {
        return tipomovimientoIdtipomovimiento;
    }

    public void setTipomovimientoIdtipomovimiento(int tipomovimientoIdtipomovimiento) {
        this.tipomovimientoIdtipomovimiento = tipomovimientoIdtipomovimiento;
    }

    public Date getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(Date horaFecha) {
        this.horaFecha = horaFecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getPesototal() {
        return pesototal;
    }

    public void setPesototal(Integer pesototal) {
        this.pesototal = pesototal;
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
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Registro[ idregistro=" + idregistro + " ]";
    }
    
}
