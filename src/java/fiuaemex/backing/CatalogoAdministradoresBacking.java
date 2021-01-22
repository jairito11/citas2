/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Administradores;
import fiuaemex.facade.AdministradoresFacadeLocal;
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
public class CatalogoAdministradoresBacking implements Serializable{

    @EJB
    private AdministradoresFacadeLocal administradoresFacade;
    
    private List<Administradores> listaAdministradores;
    private Administradores administrador;
    private boolean muestraDialogo;
    
    /**
     * Creates a new instance of CatalogoAdministradoresBacking
     */
    public CatalogoAdministradoresBacking() {
    }

    public List<Administradores> getListaAdministradores() {
        consultar();
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administradores> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public Administradores getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administradores administrador) {
        this.administrador = administrador;
    }

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void consultar(){
        listaAdministradores = administradoresFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        administrador = new Administradores();
        consultar();
    }
    
    public void seleccionarAdministrador(Administradores a){
        administrador = a;
        muestraDialogo = true;
    }
    
    public void eliminar(Administradores a){
        try{
            administradoresFacade.remove(a);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrador eliminado correctamente","Administrador eliminado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            init();
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Administrador NO eliminado correctamente","Administrador NO eliminado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            init();            
        }
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void guardar(){
        try{
            this.administradoresFacade.edit(administrador);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrador guardado exitosamente","Administrador guardado exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Administrador NO guardado exitosamente","Administrador NO guardado exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultar();
            cerrarDialogo();
            init();
        }
    }
}
