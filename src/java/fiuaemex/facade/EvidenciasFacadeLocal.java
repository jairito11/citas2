/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.facade;

import fiuaemex.entities.Evidencias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author desa
 */
@Local
public interface EvidenciasFacadeLocal {

    void create(Evidencias evidencias);

    void edit(Evidencias evidencias);

    void remove(Evidencias evidencias);

    Evidencias find(Object id);

    List<Evidencias> findAll();

    List<Evidencias> findRange(int[] range);

    int count();
    
}
