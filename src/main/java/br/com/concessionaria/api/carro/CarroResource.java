/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.carro.Carro;
import br.com.concessionaria.api.marca.Marca;
import br.com.concessionaria.api.marca.MarcaResource;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author joao6
 */
@Path("carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CarroResource {
    @PersistenceContext(unitName = "ConsessionariaPU")
    private EntityManager entityManager; 
    
    @GET
    @Path("{id}")
    public Carro getCarro(@PathParam("id") Long id) {
        return entityManager.find(Carro.class, id);
    }
    
    @POST
    public Carro addCarro(Carro carro) {
        entityManager.persist(carro);
        return carro;
    }
    
    @PUT
    @Path("{id}")
    public Carro updateCarro(@PathParam("id") Long id, Carro carro) {
       carro.setId(id);
       entityManager.merge(carro);
       return carro;
    }
    
    @DELETE    
    @Path("{id}")
    public void removeCarro(@PathParam("id") Long id) {
        entityManager.remove(getCarro(id));
    }
    
    @GET
    public List<Carro> getCarros() {
       return entityManager.createQuery("SELECT l FROM Carro l", Carro.class).getResultList();
    }
}
