package br.com.techsolutions.findpros.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
    private String telefone;
    private String email;
    private String cidade;
    private String estado;

    public Contato(DadosCadastroContato dados) {

        this.nome = dados.nome();
        this.especialidade = dados.especialidade();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.cidade = dados.cidade();
        this.estado = dados.estado();

    }

    public Contato() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Contato [" + this.nome + ", " + this.telefone + ", " + this.email + ", " + this.cidade + "(" + this.estado + ")]";
    }

}
