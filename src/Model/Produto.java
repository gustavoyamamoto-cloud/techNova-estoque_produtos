package Model;

import Enum.Categoria;

public class Produto {
    
    private int id;
    private String nome;
    private Categoria categoria;
    private double preco;
    private int quantEmEstoque;

    //Setters e Getters
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getQuantEmEstoque() {
        return quantEmEstoque;
    }


    public void setId(int id) {
        
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setQuantEmEstoque(int quantEmEstoque) {
        this.quantEmEstoque = quantEmEstoque;
    }

    
}
