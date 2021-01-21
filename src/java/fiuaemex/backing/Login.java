/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;


import fiuaemex.entities.Administradores;
import fiuaemex.entities.Alumnos;
import fiuaemex.entities.Asesores;
import fiuaemex.facade.AdministradoresFacadeLocal;
import fiuaemex.facade.AlumnosFacadeLocal;
import fiuaemex.facade.AsesoresFacadeLocal;
import java.io.Serializable;
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
public class Login implements Serializable {

    private String correo;
    private String password;
    private String rol;
    
    private Administradores administrador;
    private Asesores asesor;
    private Alumnos alumno;
    
    @EJB
    private AdministradoresFacadeLocal administradorFacade;
    @EJB
    private AsesoresFacadeLocal asesorFacade;
    @EJB
    private AlumnosFacadeLocal alumnoFacade;
    /**
     * Creates a new instance of Login
     */
    public Login() {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Administradores getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administradores administrador) {
        this.administrador = administrador;
    }

    public Asesores getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesores asesor) {
        this.asesor = asesor;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }
    
    public String validarLogin(){
        String outcome = null;
        
        switch (rol) {
            case "administrador":
                administrador = administradorFacade.consultarAdministrador(correo, password);
                if (administrador != null) {
                    outcome = "indexAdministrador";
                }else{
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Administrador no valido","Administrador no valido");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
                return outcome;
            case "asesor":
                asesor = asesorFacade.consultarAsesor(correo, password);
                if (asesor != null) {
                    outcome = "indexAsesor";
                }else{
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Asesor no valido","Asesor no valido");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
                return outcome;
            case "alumno":
                alumno = alumnoFacade.consultarAlumno(correo, password);
                if (alumno != null) {
                    outcome = "indexAlumno";
                }else{
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alumno no valido","Alumno no valido");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
                return outcome;
            default:
                throw new AssertionError();
        }
    }    
    
}
