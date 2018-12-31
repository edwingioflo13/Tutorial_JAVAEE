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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNombreusuario", query = "SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREUSUARIO")
    private String nombreusuario;
    @Size(max = 255)
    @Column(name = "CLAVE")
    private String clave;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Acceso> accesoList;

    public Usuario() {
    }

    public Usuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public List<Acceso> getAccesoList() {
        return accesoList;
    }

    public void setAccesoList(List<Acceso> accesoList) {
        this.accesoList = accesoList;
    }

    public String muestraAccesos() {
        String retorno = "";
        for (int i = 0; i < accesoList.size(); i++) {
            retorno += accesoList.get(i).getCodigoacceso();
            if (i != accesoList.size() - 1) {
                retorno += ", ";
            }
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreusuario != null ? nombreusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombreusuario == null && other.nombreusuario != null) || (this.nombreusuario != null && !this.nombreusuario.equals(other.nombreusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "susolabs.Usuario[ nombreusuario=" + nombreusuario + " ]";
    }

}
