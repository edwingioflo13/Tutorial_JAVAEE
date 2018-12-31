/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susolabs.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author t4nk
 */
@Entity
@Table(name = "acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a")
    , @NamedQuery(name = "Acceso.findByCodigoacceso", query = "SELECT a FROM Acceso a WHERE a.codigoacceso = :codigoacceso")
    , @NamedQuery(name = "Acceso.findByDescripcion", query = "SELECT a FROM Acceso a WHERE a.descripcion = :descripcion")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CODIGOACCESO")
    private String codigoacceso;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinTable(name = "usuario_acceso", joinColumns = {
        @JoinColumn(name = "CODIGOACCESO", referencedColumnName = "CODIGOACCESO")}, inverseJoinColumns = {
        @JoinColumn(name = "NOMBREUSUARIO", referencedColumnName = "NOMBREUSUARIO")})
    @ManyToMany
    private List<Usuario> usuarioList;

    public Acceso() {
    }

    public Acceso(String codigoacceso) {
        this.codigoacceso = codigoacceso;
    }

    public String getCodigoacceso() {
        return codigoacceso;
    }

    public void setCodigoacceso(String codigoacceso) {
        this.codigoacceso = codigoacceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoacceso != null ? codigoacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.codigoacceso == null && other.codigoacceso != null) || (this.codigoacceso != null && !this.codigoacceso.equals(other.codigoacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "susolabs.Acceso[ codigoacceso=" + codigoacceso + " ]";
    }
    
}
