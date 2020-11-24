/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Neo
 */
@Stateless
public class TipoterceroFacade extends AbstractFacade<Tipotercero> {

    @PersistenceContext(unitName = "ControlVPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoterceroFacade() {
        super(Tipotercero.class);
    }
    
}
