/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.carro.Carro;
import br.com.concessionaria.api.formaPagto.FormaPagto;
import br.com.concessionaria.api.marca.Marca;
import br.com.concessionaria.api.marca.MarcaResource;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public CarroDTO getCarro(@PathParam("id") Long id) {
        Carro carro = entityManager.find(Carro.class, id);
        List<Long> formaIds = new ArrayList<Long>();
        carro.getFormaPagto().forEach((forma) -> {
            formaIds.add(forma.getId());
        });
        return new CarroDTO(carro.getId(), carro.getModelo(), carro.getImagem(), carro.getAno(), carro.getPreco(), carro.getMarca().getId(), formaIds);
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
       Marca marca = entityManager.find(Marca.class, carro.getMarca().getId());
       carro.setMarca(marca);
       entityManager.merge(carro);
       return carro;
    }
    
    @DELETE    
    @Path("{id}")
    public void removeCarro(@PathParam("id") Long id) {
        entityManager.remove(entityManager.find(Carro.class,id));
    }
    
    @GET
    public List<CarroDTO> getCarros() {
        List<Carro> listaCarros = entityManager.createQuery("SELECT c FROM Carro c", Carro.class).getResultList();
        List<CarroDTO> listaCarroDTO = new ArrayList<>();
        
        listaCarros.forEach((carro) -> {
            List<Long> formaIds = new ArrayList<>();
            carro.getFormaPagto().forEach((forma) -> {
                formaIds.add(forma.getId());
            });
            listaCarroDTO.add(new CarroDTO(carro.getId(), carro.getModelo(), carro.getImagem(), carro.getAno(), carro.getPreco(), carro.getMarca().getId(), formaIds));
        });
        return listaCarroDTO;
    }
}