package br.com.concessionaria.api.carro;

import br.com.concessionaria.api.acessorios.Acessorio;
import br.com.concessionaria.api.condPagto.CondPagto;
import br.com.concessionaria.api.formaPagto.FormaPagto;
import br.com.concessionaria.api.marca.Marca;
import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name = "carro", schema = "public")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String modelo;
    private int ano;
    private Double preco;
    private String imagem;
    private String placa;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "forma_carros",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_forma"),
            foreignKey = @ForeignKey(name = "fk_carro"),
            inverseForeignKey = @ForeignKey(name = "fk_forma")
    )
    private List<FormaPagto> formaPagto = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cond_carros",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_cond"),
            foreignKey = @ForeignKey(name = "fk_carro"),
            inverseForeignKey = @ForeignKey(name = "fk_cond")
    )
    private List<CondPagto> condPagto = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "acessorio_carros",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio"),
            foreignKey = @ForeignKey(name = "fk_carro"),
            inverseForeignKey = @ForeignKey(name = "fk_acessorio")
    )
    private List<Acessorio> acessorio = new ArrayList<>();

    public List<Acessorio> getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(List<Acessorio> acessorio) {
        this.acessorio = acessorio;
    }

    public List<FormaPagto> getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(List<FormaPagto> formaPagto) {
        this.formaPagto = formaPagto;
    }

    public List<CondPagto> getCondPagto() {
        return condPagto;
    }

    public void setCondPagto(List<CondPagto> condPagto) {
        this.condPagto = condPagto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
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
