/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuaemex.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@WebFilter(filterName = "AutenticationFillter", urlPatterns = {"*.xhtml"})
public class AutenticationFillter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public AutenticationFillter() {
    }    
    
      

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        HttpSession ses = req.getSession(false);
        String uri = req.getRequestURI();
        
        if(uri.indexOf("/index.xhtml") >= 0
                || (ses != null && ses.getAttribute("username") != null)){
            chain.doFilter(request, response);
        }else{
            resp.sendRedirect(req.getContextPath() + "/faces/index.xhtml");
        }
        
    }

     /**
     * Destroy method for this filter
     */
    public void destroy() {
        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        
    }
    
}
