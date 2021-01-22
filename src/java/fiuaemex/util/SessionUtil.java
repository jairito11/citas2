/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
public class SessionUtil {
    public static HttpSession getSession(){
        return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
}
