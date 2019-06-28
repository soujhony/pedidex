package com.jhonystein.pedidex.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PEDIDOS")
@SequenceGenerator(name = "pedido_seq", allocationSize = 1,
        sequenceName = "PEDIDO_SEQ")
public class Pedido implements Entidade {
    
    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue(generator = "pedido_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "CD_PEDIDO", length = 20, unique = true)
    private String codigo;
    
    @ManyToOne()
    @JoinColumn(name = "ID_CLIENTE", 
            foreignKey = 
                    @ForeignKey(name = "FK_PEDIDO_CLIENTE", 
                            value = ConstraintMode.CONSTRAINT))
    private Cliente cliente;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_EMISSAO")
    private Date emissao;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_APROVACAO")
    private Date aprovacao;
    
    @OneToMany()
    @JoinColumn(name = "ID_PEDIDO")
    private List<PedidoItem> items;

    @Override
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Date aprovacao) {
        this.aprovacao = aprovacao;
    }

    public List<PedidoItem> getItems() {
        return items;
    }

    public void setItems(List<PedidoItem> items) {
        this.items = items;
    }
    
}
