/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Materias;
import fiuaemex.facade.AlumnosFacadeLocal;
import fiuaemex.facade.MateriasFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class AdministradorBacking implements Serializable{
    
    @EJB
    private MateriasFacadeLocal materiasFacade;
    @EJB
    private AlumnosFacadeLocal alumnosFacade;
            
    private List<Materias> listaMaterias;
    private Materias materia;
    private Alumnos alumno;
    /**
     * Creates a new instance of AdministradorBacking
     */
    public AdministradorBacking() {
    }
    
    public void consultar(){
        listaMaterias = materiasFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        materia = new Materias();
        alumno = new Alumnos();
        consultar();
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public List<Materias> getListaMaterias() {
        consultar();
        return listaMaterias;
    }

    public void setListaMaterias(List<Materias> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
    
    public void nuevoAlumno(){
        try{
            this.alumno.setAvance(0);
            this.alumno.setMateriaId(materia);
            this.alumnosFacade.create(alumno);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alumno creado correctamente","Alumno creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
