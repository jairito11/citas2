/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Citas;
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
public class AlumnoBacking implements Serializable{
    
    @EJB
    private CitasFacadeLocal citasFacade;
    
    private List<Citas> listaCitas;
    private Citas cita;
    /**
     * Creates a new instance of AlumnoBacking
     */
    public AlumnoBacking() {
    }

    public List<Citas> getListaCitas() {
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
    
    @PostConstruct
    public void init(){
        cita = new Citas();
    }
    
    public void asistencia(Citas c){
        try{
            c.setEstatus("finalizada");
            c.setAsistencia("asistio");
            citasFacade.edit(c);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Asistencia marcada exitosamente","Asistencia marcada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            init();
        }catch (Exception ex){
            ex.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Asistencia NO marcada exitosamente","Asistencia NO marcada exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            init();
        }
        
    }
}
