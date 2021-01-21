/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Asesores;
import fiuaemex.facade.AsesoresFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author desa
 */
@ManagedBean
@SessionScoped
public class CatalogoAsesoresBacking  implements Serializable{
    
    @EJB
    private AsesoresFacadeLocal asesoresFacade;
    
    private List<Asesores> listaAsesores;
    private Asesores asesor;
    private boolean muestraDialogo;
    
    /**
     * Creates a new instance of CatalogAsesoresBacking
     */
    public CatalogoAsesoresBacking() {
    }

    public List<Asesores> getListaAsesores() {
        consultar();
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

    public boolean isMuestraDialogo() {
        return muestraDialogo;
    }

    public void setMuestraDialogo(boolean muestraDialogo) {
        this.muestraDialogo = muestraDialogo;
    }
    
    public void consultar(){
        listaAsesores = asesoresFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        asesor = new Asesores();
        consultar();
    }
    
    public void seleccionarAsesor(Asesores a){
        asesor = a;
        muestraDialogo = true;
    }
    
    public void eliminar(Asesores a){
        asesoresFacade.remove(a);
        consultar();
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void guardar(){
        try{
            this.asesoresFacade.edit(asesor);
            consultar();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
