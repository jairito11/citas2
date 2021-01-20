/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desa
 */
@Entity
@Table(name = "asesores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asesores.findAll", query = "SELECT a FROM Asesores a")
    , @NamedQuery(name = "Asesores.findById", query = "SELECT a FROM Asesores a WHERE a.id = :id")
    , @NamedQuery(name = "Asesores.findByNombre", query = "SELECT a FROM Asesores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asesores.findByPaterno", query = "SELECT a FROM Asesores a WHERE a.paterno = :paterno")
    , @NamedQuery(name = "Asesores.findByMaterno", query = "SELECT a FROM Asesores a WHERE a.materno = :materno")
    , @NamedQuery(name = "Asesores.findByEspecialidad", query = "SELECT a FROM Asesores a WHERE a.especialidad = :especialidad")
    , @NamedQuery(name = "Asesores.findByCorreo", query = "SELECT a FROM Asesores a WHERE a.correo = :correo")
    , @NamedQuery(name = "Asesores.findByPassword", query = "SELECT a FROM Asesores a WHERE a.password = :password")
    , @NamedQuery(name = "Asesores.findUser", query = "SELECT a FROM Asesores a WHERE a.correo = :correo AND a.password = :password")})
public class Asesores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "especialidad")
    private String especialidad;
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
    @OneToMany(mappedBy = "asesorId")
    private List<Citas> citasList;
    @OneToOne(mappedBy = "asesorId")
    private Materias materias;

    public Asesores() {
    }

    public Asesores(Integer id) {
        this.id = id;
    }

    public Asesores(Integer id, String nombre, String paterno, String materno, String especialidad, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.especialidad = especialidad;
        this.correo = correo;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    @XmlTransient
    public List<Citas> getCitasList() {
        return citasList;
    }

    public void setCitasList(List<Citas> citasList) {
        this.citasList = citasList;
    }

    public Materias getMaterias() {
        return materias;
    }

    public void setMaterias(Materias materias) {
        this.materias = materias;
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
        if (!(object instanceof Asesores)) {
            return false;
        }
        Asesores other = (Asesores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fiuaemex.entities.Asesores[ id=" + id + " ]";
    }
    
}
