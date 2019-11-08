package br.com.fiap.nacfinal;

import java.io.Serializable;

public class Mensagem implements Serializable {

    private int id;
    private String nome;
    private String email;
    private String mensagem;

    public Mensagem() {
    }

    public Mensagem(String nome, String email, String mensagem) {
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
    }
    
    public Mensagem(int id, String nome, String email, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
