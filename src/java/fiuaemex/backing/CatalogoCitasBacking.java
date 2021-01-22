/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Asesores;
import fiuaemex.entities.Citas;
import fiuaemex.facade.AlumnosFacadeLocal;
import fiuaemex.facade.AsesoresFacadeLocal;
import fiuaemex.facade.CitasFacadeLocal;
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
public class CatalogoCitasBacking implements Serializable{
    
    @EJB
    private CitasFacadeLocal citasFacade;
    @EJB
    private AsesoresFacadeLocal asesoresFacade;
    @EJB
    private AlumnosFacadeLocal alumnosFacade;
    
    private List<Asesores> listaAsesores;
    private List<Alumnos> listaAlumnos;
    
    private List<Citas> listaCitas;
    private Citas cita;
    private Alumnos alumno;
    private Asesores asesor;
    private boolean muestraDialogo;
    
    /**
     * Creates a new instance of CatalogoCitasBacking
     */
    public CatalogoCitasBacking() {
    }

    public List<Asesores> getListaAsesores() {
        consultarAsesores();
        return listaAsesores;
    }

    public void setListaAsesores(List<Asesores> listaAsesores) {
        this.listaAsesores = listaAsesores;
    }

    public List<Alumnos> getListaAlumnos() {
        consultarAlumnos();
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public List<Citas> getListaCitas() {
        consultar();////////////////////////////////////////////
        return listaCitas;
    }

    public void setListaCitas(List<Citas> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Asesores getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesores asesor) {
        this.asesor = asesor;
    }

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void consultar(){
        listaCitas = citasFacade.findAll();
    }
    
    public void consultarAsesores(){
        listaAsesores = asesoresFacade.findAll();
    }
    
    public void consultarAlumnos(){
        listaAlumnos = alumnosFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        cita = new Citas();
        alumno = new Alumnos();
        asesor = new Asesores();
        consultar();//////////////////////////////////////////////
        consultarAlumnos();
        consultarAsesores();
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void seleccionarCita(Citas c){
        cita = c;
        muestraDialogo = true;
    }
    
    public void guardar(){
        try{
            this.cita.setAlumnoId(alumno);
            this.cita.setAsesorId(asesor);
            this.citasFacade.edit(cita);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cita actualizada correctamente","Cita actualizada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();////////////////////////////////////////////////
            consultarAlumnos();
            consultarAsesores();
            cerrarDialogo();
            init();
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cita NO actualizada correctamente","Cita NO actualizada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();////////////////////////////////////////////////
            consultarAlumnos();
            consultarAsesores();
            cerrarDialogo();
            init();            
        }
    }
    
    public void eliminar(Citas c){

        try{
            citasFacade.remove(c);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cita eliminada correctamente","Cita eliminada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();//////////////////////////////////////////////////
            consultarAlumnos();
            consultarAsesores(); 
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cita NO eliminada correctamente","Cita NO eliminada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
}
