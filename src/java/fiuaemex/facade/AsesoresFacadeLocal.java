/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.facade;

import fiuaemex.entities.Asesores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface AsesoresFacadeLocal {

    void create(Asesores asesores);

    void edit(Asesores asesores);

    void remove(Asesores asesores);

    Asesores find(Object id);

    List<Asesores> findAll();

    List<Asesores> findRange(int[] range);

    int count();
    
}
