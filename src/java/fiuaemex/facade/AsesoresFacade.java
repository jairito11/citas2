/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.facade;

import fiuaemex.entities.Asesores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author desa
 */
@Stateless
public class AsesoresFacade extends AbstractFacade<Asesores> implements AsesoresFacadeLocal {

    @PersistenceContext(unitName = "citas2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsesoresFacade() {
        super(Asesores.class);
    }
    
    public Asesores consultarAsesor(String correo, String password){
        try{
            Query query = em.createNamedQuery("Asesores.findUser");
            query = query.setParameter("correo", correo).setParameter("password", password);
            return (Asesores) query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
}
