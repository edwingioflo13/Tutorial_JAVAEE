/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susolabs;


import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import susolabs.entidades.Acceso;
import susolabs.facade.AccesoFacadeLocal;

/**
 *
 * @author t4nk
 */
@ManagedBean(name = "accesoBean")
@RequestScoped
public class accesoBean {

    /**
     * Creates a new instance of accesoBean
     */
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
    
    public void eliminar(Acceso accesoEliminar){
        accesoFacade.remove(accesoEliminar);
    }
    
    public void editar(){
        accesoFacade.edit(accesoEditar);
        accesoEditar = new Acceso();
    }
    
    public List<Acceso> buscar(){
       return accesoFacade.findAll();
    }
    
    public void accesoSeleccionado(Acceso accesoSeleccion) {
        this.accesoEditar = accesoSeleccion;
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }

    public Acceso getAccesoEditar() {
        return accesoEditar;
    }

    public void setAccesoEditar(Acceso accesoEditar) {
        this.accesoEditar = accesoEditar;
    }

    public List<Acceso> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Acceso> filtro) {
        this.filtro = filtro;
    }

}
