package Model;

import Enum.Categoria;

public class Produto implements Comparable<Produto>{
    
    private int id;
    private String nome;
    private Categoria categoria;
    private double preco;
    private int quantEmEstoque;

    //Construtor
    public Produto(int id, String nome, Categoria categoria, double preco, int quantEmEstoque){
        setId(id);
        setNome(nome);
        setCategoria(categoria);
        setPreco(preco);
        setQuantEmEstoque(quantEmEstoque);
    }

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

    //ToString
    public String toString(){
        return String.format("|Id:  %-5d |Nome: %-15s |Categoria: %-10s |Preço: %8.2f |Quantidade Estq: %-5d", getId(), getNome(), getCategoria(), getPreco(), getQuantEmEstoque());
    }
    
    //Equals
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Produto other = (Produto)obj;
        return this.getId() == other.getId();
    }

    //HasCode
    @Override
    public int hashCode(){
        return Integer.hashCode(getId());
    }

    //Comparable
    @Override
    public int compareTo(Produto other){
        return this.getId() - other.getId();
    }
}
