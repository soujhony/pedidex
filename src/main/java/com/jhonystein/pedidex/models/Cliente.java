package com.jhonystein.pedidex.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES")
@SequenceGenerator(name = "cliente_seq", allocationSize = 1,
        sequenceName = "CLIENTE_SEQ")
public class Cliente implements Serializable {
    
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(generator = "cliente_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "NR_DOCUMENTO", length = 20)
    private String documento;
    @Column(name = "NM_CLIENTE", length = 80)
    private String nome;
    @Column(name = "NR_TELEFONE", length = 20)
    private String telefone;
    @Column(name = "DS_EMAIL", length = 120)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
