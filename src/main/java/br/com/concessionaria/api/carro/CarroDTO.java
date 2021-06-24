/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.formaPagto.FormaPagto;
import br.com.concessionaria.api.marca.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author joao6
 */
public class CarroDTO {
    public Long id;
    public String modelo;
    public String imagem;
    public int ano;
    public int preco;
    public Long marca;
    public List<Long> formas;
    
    public CarroDTO(Long id, String modelo, String imagem, int ano, int preco, Long marca, List<Long> formas) {
        this.id = id;
        this.modelo = modelo;
        this.imagem = imagem;
        this.ano = ano;
        this.preco = preco;
        this.marca = marca;
        this.formas = formas;
    }
}
