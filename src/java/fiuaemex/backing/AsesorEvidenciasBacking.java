/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;


import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Evidencias;
import fiuaemex.facade.AlumnosFacadeLocal;
import fiuaemex.facade.EvidenciasFacadeLocal;
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
public class AsesorEvidenciasBacking {
    
    @EJB
    private EvidenciasFacadeLocal evidenciasFacade;
    
    @EJB
    private AlumnosFacadeLocal alumnosFacade;
    
    private List<Evidencias> listaEvidencias;
    private List<Alumnos> listaAlumnos;
    private Alumnos alumno;
    private Evidencias evidencia;
    private boolean muestraDialogo;
    

    /**
     * Creates a new instance of AsesorEvidenciasBacking
     */
    public AsesorEvidenciasBacking() {
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

    public List<Evidencias> getListaEvidencias() {
        consultarEvidencias();
        return listaEvidencias;
    }

    public void setListaEvidencias(List<Evidencias> listaEvidencias) {
        this.listaEvidencias = listaEvidencias;
    }

    public Evidencias getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(Evidencias evidencia) {
        this.evidencia = evidencia;
    }
    
    public void consultarEvidencias(){
        listaEvidencias = evidenciasFacade.findAll();
    }
    
    public void consultarAlumnos(){
        listaAlumnos = alumnosFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        evidencia = new Evidencias();
        alumno = new Alumnos();
        consultarEvidencias();
        consultarAlumnos();
    }

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void cerrarDialogo(){
        this.muestraDialogo = false;
    }
    
    public void seleccionarEvidencia(Evidencias e){
        evidencia = e;
        muestraDialogo = true;
    }
    
    public void nuevo(){
        evidencia = new Evidencias();
        muestraDialogo = true;
    }
    
    public void guardar(){
        try{
            this.evidencia.setAlumnoId(alumno);
            this.evidenciasFacade.edit(evidencia);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Evidencia guardada exitosamente","Evidencia guardada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAlumnos();
            consultarEvidencias();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Evidencia NO guardada exitosamente","Evidencia NO guardada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAlumnos();
            consultarEvidencias();
            cerrarDialogo();
            init();
        }
    }
     
    public void eliminar(Evidencias e){
        try{
            evidenciasFacade.remove(e);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Evidencia eliminada exitosamente","Evidencia eliminada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAlumnos();
            consultarEvidencias();
            cerrarDialogo();
            init();
        }catch(Exception ex){
            ex.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Evidencia NO eliminada exitosamente","Evidencia NO eliminada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAlumnos();
            consultarEvidencias();
            cerrarDialogo();
            init();
        }
    }
}
