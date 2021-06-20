/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.marca.Marca;

/**
 *
 * @author joao6
 */
public class CarroDTO {
    public Long id;
    public String modelo;
    public int ano;
    public int preco;
    public String imagem;
    public Long marca;
}
