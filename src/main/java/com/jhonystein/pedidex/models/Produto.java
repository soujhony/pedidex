package com.jhonystein.pedidex.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTOS")
@SequenceGenerator(name = "produtos_seq", sequenceName = "PRODUTOS_SEQ", allocationSize = 1)
public class Produto implements Serializable {
    
    @Id
    @Column(name = "ID_PRODUTO")
    @GeneratedValue(generator = "produtos_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "CD_PRODUTO", length = 20, unique = true)
    private String codigo;
    
    @Lob
    @Column(name = "DS_PRODUTO")
    private String descricao;
    
    @Column(name = "VL_PRECO", precision = 15, scale = 5)
    private BigDecimal preco;
    
    @Column(name = "QT_ESTOQUE", precision = 15, scale = 5)
    private BigDecimal estoque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }
    
    
}
