/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;


import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Citas;
import fiuaemex.facade.CitasFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class AsesorBacking implements Serializable{
    
    @EJB
    private CitasFacadeLocal citasFacade;
    
    private Citas cita;
    private Alumnos alumno;
    private boolean muestraDialogo;
    
//    @Inject
//    private Login login;
    @ManagedProperty(value = "#{login}")
    private Login login;
    /**
     * Creates a new instance of AsesorBacking
     */
    public AsesorBacking() {
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Citas getCita() {
        return cita;
    }

    public void setCita(Citas cita) {
        this.cita = cita;
    }

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void nuevo(){
        cita = new Citas();
        muestraDialogo = true;
    }
    
    @PostConstruct
    public void init(){
        cita = new Citas();
        alumno = new Alumnos();
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void guardar(){
        try{
            this.cita.setEstatus("pendiente");
            this.cita.setAsistencia("pendiente");
            this.cita.setAsesorId(login.getAsesor());
            this.cita.setAlumnoId(alumno);
            this.citasFacade.create(cita);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cita creada correctamente","Cita creada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            muestraDialogo = false;
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cita NO creada correctamente","Cita No creada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            init();
        }

    }
}
