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
        if(getId() <= 0){
            throw new IllegalArgumentException("Id inválido");
        }
        this.id = id;
    }
    
    public void setNome(String nome) {
        if(getNome() == null || getNome().trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }
    
    public void setCategoria(Categoria categoria) {
        if(getCategoria() == null){
            throw new IllegalArgumentException("Categoria inválida");
        }
        this.categoria = categoria;
    }
    
    public void setPreco(double preco) {
        if(getPreco() < 0){
            throw new IllegalArgumentException("Preço inválido");
        }
        this.preco = preco;
    }
    
    public void setQuantEmEstoque(int quantEmEstoque) {
        if(getQuantEmEstoque() < 0){
            throw new IllegalArgumentException("Quantidade inválida");
        }
        this.quantEmEstoque = quantEmEstoque;
    }

    
}
