/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.backing;

import fiuaemex.entities.Asesores;
import fiuaemex.entities.Materias;
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
public class CatalogoMateriasBacking implements Serializable{
    
    @EJB
    private MateriasFacadeLocal materiasFacade;
    
    @EJB
    private AsesoresFacadeLocal asesoresFacade;
    
    private List<Materias> listaMaterias;
    private List<Asesores> listaAsesores;
    private Materias materia;
    private Asesores asesor;
    private boolean muestraDialogo;
    
    /**
     * Creates a new instance of CatalogoMateriasBacking
     */
    public CatalogoMateriasBacking() {
    }

    public List<Materias> getListaMaterias() {
        consultarMaterias();
        return listaMaterias;
    }

    public void setListaMaterias(List<Materias> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<Asesores> getListaAsesores() {
        consultarAsesores();
        return listaAsesores;
    }

    public void setListaAsesores(List<Asesores> listaAsesores) {
        this.listaAsesores = listaAsesores;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
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
    
    public void consultarMaterias(){
        listaMaterias = materiasFacade.findAll();
    }
    
    public void consultarAsesores(){
        listaAsesores = asesoresFacade.findAll();
    }
    
    @PostConstruct
    public void init(){
        materia = new Materias();
        asesor = new Asesores();
        consultarAsesores();
        consultarMaterias();
    }
    
    public void cerrarDialogo(){
        muestraDialogo = false;
    }
    
    public void seleccionarMateria(Materias m){
        materia = m;
        muestraDialogo = true;
    }
    
    public void guardar(){
        try{
            this.materia.setAsesorId(asesor);
            this.materiasFacade.edit(materia);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Materia actualizada correctamente","Materia actualizada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAsesores();
            consultarMaterias();
            cerrarDialogo();
            init();            
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Materia NO actualizada correctamente","Materia NO actualizada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAsesores();
            consultarMaterias();
            cerrarDialogo();
            init();
        }
    }
    
    public void eliminar(Materias m){
        try{
            materiasFacade.remove(m);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Materia eliminada correctamente","Materia eliminada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAsesores();
            consultarMaterias();
            cerrarDialogo();
            init();
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Materia NO eliminada correctamente","Materia NO eliminada correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            consultarAsesores();
            consultarMaterias();
            cerrarDialogo();
            init();
        }
    }
    
}
