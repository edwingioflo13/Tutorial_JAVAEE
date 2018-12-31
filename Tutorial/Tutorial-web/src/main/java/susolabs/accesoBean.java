/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susolabs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import susolabs.facade.AccesoFacadeLocal;
import susolabs.entidades.*;

/**
 *
 * @author t4nk
 */
@ManagedBean(name = "accesoBean")
@RequestScoped
public class accesoBean {

    @EJB
    private AccesoFacadeLocal accesoFacade;
    
    private Acceso acceso = new Acceso();
    
    private Acceso accesoEditar = new Acceso();
    
    private List<Acceso> filtro;
    
    public accesoBean() {
    }
    
    public void guardar(){
        accesoFacade.create(acceso);
        acceso = new Acceso();
    }
    
    public void editar(){
        accesoFacade.edit(accesoEditar);
        accesoEditar = new Acceso();
    }
    
    public void eliminar(Acceso accesoBorrar){
        accesoFacade.remove(accesoBorrar);
    }
    
    public List<Acceso> buscar(){
        return accesoFacade.findAll();
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }

    public List<Acceso> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Acceso> filtro) {
        this.filtro = filtro;
    }

    public Acceso getAccesoEditar() {
        return accesoEditar;
    }

    public void setAccesoEditar(Acceso accesoEditar) {
        this.accesoEditar = accesoEditar;
    }
    
     public void accesoSeleccionado(Acceso accesoSeleccion) {
        this.accesoEditar = accesoSeleccion;
    }
    
}
