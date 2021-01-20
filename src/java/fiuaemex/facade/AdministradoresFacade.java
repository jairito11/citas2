/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.facade;

import fiuaemex.entities.Administradores;
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
public class AdministradoresFacade extends AbstractFacade<Administradores> implements AdministradoresFacadeLocal {

    @PersistenceContext(unitName = "citas2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradoresFacade() {
        super(Administradores.class);
    }
    
    public Administradores consultarAdministrador(String correo, String password){
        try{
            Query query = em.createNamedQuery("Administradores.findUser");
            query = query.setParameter("correo", correo).setParameter("password", password);
            return (Administradores) query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
    
}
