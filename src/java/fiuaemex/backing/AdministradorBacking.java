/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Administradores;
import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Asesores;
import fiuaemex.entities.Materias;
import fiuaemex.facade.AdministradoresFacadeLocal;
import fiuaemex.facade.AlumnosFacadeLocal;
import fiuaemex.facade.AsesoresFacadeLocal;
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
    @EJB
    private AsesoresFacadeLocal asesoresFacade;
    @EJB
    private AdministradoresFacadeLocal administradorFacade;
    
    private List<Asesores> listaAsesores;
            
    private List<Materias> listaMaterias;
    private Materias materia;
    private Alumnos alumno;
    private Asesores asesor;
    private Administradores administrador;
    
    /**
     * Creates a new instance of AdministradorBacking
     */
    public AdministradorBacking() {
    }
    
    public void consultar(){
        listaMaterias = materiasFacade.findAll();
    }
    
    public void consultarAsesores(){
        listaAsesores = asesoresFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        materia = new Materias();
        alumno = new Alumnos();
        asesor = new Asesores();
        administrador = new Administradores();
        consultar();
        consultarAsesores();
    }

    public List<Asesores> getListaAsesores() {
        consultarAsesores();
        return listaAsesores;
    }

    public void setListaAsesores(List<Asesores> listaAsesores) {
        this.listaAsesores = listaAsesores;
    }

    public Asesores getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesores asesor) {
        this.asesor = asesor;
    }

    public Administradores getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administradores administrador) {
        this.administrador = administrador;
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
            consultarAsesores();
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alumno NO creado correctamente","Alumno NO creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();
        }
    }
    
    public void nuevoAsesor(){
        try{
            this.asesoresFacade.create(asesor);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Asesor creado correctamente","Asesor creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Asesor NO creado correctamente","Asesor NO creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();
        }
    }
    
    public void nuevoAdministrador(){
        try{
            this.administradorFacade.create(administrador);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrador creado correctamente","Administrador creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Administrador NO creado correctamente","Administrador NO creado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();
        }
    }
    
    public void nuevaMateria(){
        try{
            this.materia.setAsesorId(asesor);
            this.materiasFacade.create(materia);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Materia creada correctamente","Materia creada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();            
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Materia NO creada correctamente","Materia NO creada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            consultarAsesores();
            init();
        }
        
    }
}
