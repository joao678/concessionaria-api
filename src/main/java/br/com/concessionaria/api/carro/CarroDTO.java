package br.com.concessionaria.api.carro;

import java.util.List;

public class CarroDTO {

    public Long id;
    public String modelo;
    public String imagem;
    public int ano;
    public Double preco;
    public Long marca;
    public String placa;
    public List<Long> formas;
    public List<Long> condicoes;
    public List<Long> acessorios;    

    public CarroDTO(Long id, String modelo, String imagem, int ano, Double preco, Long marca, String placa, List<Long> formas, List<Long> conds, List<Long> acessorios) {
        this.id = id;
        this.modelo = modelo;
        this.imagem = imagem;
        this.ano = ano;
        this.preco = preco;
        this.marca = marca;
        this.placa = placa;
        this.formas = formas;
        this.condicoes = conds;
        this.acessorios = acessorios;
    }
}
