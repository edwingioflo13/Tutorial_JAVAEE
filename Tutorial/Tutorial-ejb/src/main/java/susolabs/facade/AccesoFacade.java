/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package susolabs.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import susolabs.entidades.Acceso;

/**
 *
 * @author t4nk
 */
@Stateless
public class AccesoFacade extends AbstractFacade<Acceso> implements AccesoFacadeLocal {

    @PersistenceContext(unitName = "susolabs_Tutorial-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccesoFacade() {
        super(Acceso.class);
    }
    
}
