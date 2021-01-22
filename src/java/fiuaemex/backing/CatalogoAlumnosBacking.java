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
import javax.inject.Named;
import javax.enterprise.context.Dependent;
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
public class CatalogoAlumnosBacking implements Serializable{

    @EJB
    private AlumnosFacadeLocal alumnosFacade;
    
    @EJB
    private MateriasFacadeLocal materiasFacade;
    
    private List<Alumnos> listaAlumnos;
    private List<Materias> listaMaterias;
    private Alumnos alumno;
    private Materias materia;
    private boolean muestraDialogo;
    
    /**
     * Creates a new instance of CatalogoAlumnosBacking
     */
    public CatalogoAlumnosBacking() {
    }

    public List<Materias> getListaMaterias() {
        consultarMaterias();
        return listaMaterias;
    }

    public void setListaMaterias(List<Materias> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public List<Alumnos> getListaAlumnos() {
        consultarAlumnos();
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void consultarAlumnos(){
        listaAlumnos = alumnosFacade.findAll();
    }
    
    public void consultarMaterias(){
        listaMaterias = materiasFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        alumno = new Alumnos();
        materia = new Materias();
        consultarAlumnos();
        consultarMaterias();
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void seleccionarAlumno(Alumnos a){
        alumno = a;
        muestraDialogo = true;
    }
    
    public void guardar(){
        try{
            this.alumno.setMateriaId(materia);
            this.alumnosFacade.edit(alumno);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alumno actualizado correctamente","Alumno actualizado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAlumnos();
            consultarMaterias();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void eliminar (Alumnos a){
        alumnosFacade.remove(a);
        consultarAlumnos();
        consultarMaterias();
    }
    
}
