/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.entities;

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
 * @author desa
 */
@Entity
@Table(name = "administradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a")
    , @NamedQuery(name = "Administradores.findById", query = "SELECT a FROM Administradores a WHERE a.id = :id")
    , @NamedQuery(name = "Administradores.findByCorreo", query = "SELECT a FROM Administradores a WHERE a.correo = :correo")
    , @NamedQuery(name = "Administradores.findByPassword", query = "SELECT a FROM Administradores a WHERE a.password = :password")
    , @NamedQuery(name = "Administradores.findByNombre", query = "SELECT a FROM Administradores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Administradores.findByPaterno", query = "SELECT a FROM Administradores a WHERE a.paterno = :paterno")
    , @NamedQuery(name = "Administradores.findByMaterno", query = "SELECT a FROM Administradores a WHERE a.materno = :materno")
    , @NamedQuery(name = "Administradores.findUser", query = "SELECT a FROM Administradores a WHERE a.correo = :correo AND a.password = :password")})
public class Administradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "paterno")
    private String paterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "materno")
    private String materno;

    public Administradores() {
    }

    public Administradores(Integer id) {
        this.id = id;
    }

    public Administradores(Integer id, String correo, String password, String nombre, String paterno, String materno) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administradores)) {
            return false;
        }
        Administradores other = (Administradores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fiuaemex.entities.Administradores[ id=" + id + " ]";
    }
    
}
