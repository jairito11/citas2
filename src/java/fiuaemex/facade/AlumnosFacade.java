/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.facade;

import fiuaemex.entities.Alumnos;
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
public class AlumnosFacade extends AbstractFacade<Alumnos> implements AlumnosFacadeLocal {

    @PersistenceContext(unitName = "citas2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnosFacade() {
        super(Alumnos.class);
    }
    
    public Alumnos consultarAlumno(String correo, String password){
        try{
            Query query = em.createNamedQuery("Alumnos.findUser");
            query = query.setParameter("correo", correo).setParameter("password", password);
            return (Alumnos) query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
    
}
