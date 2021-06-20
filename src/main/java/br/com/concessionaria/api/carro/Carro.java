/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.formaPagto.FormaPagto;
import br.com.concessionaria.api.marca.Marca;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

/**
 *
 * @author joao6
 */
@Entity
@Table(name = "carro", schema="public")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false)
    private String modelo;
    private int ano;
    private int preco;
    private String imagem;

    @ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "marca_id", referencedColumnName = "id", unique = false, insertable = false, updatable = false)
    private Marca marca;
    
    /*@ManyToMany
    @JoinTable(
        name = "forma_pagto_carro",
        joinColumns = @JoinColumn(name = "carro_id"),
        inverseJoinColumns = @JoinColumn(name = "forma_pagto_id")
    )
    private List<FormaPagto> formaPagto;

    public List<FormaPagto> getFormaPagto() {
        return formaPagto;
    }*/

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
