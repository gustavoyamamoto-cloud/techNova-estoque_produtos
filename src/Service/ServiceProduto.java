package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Exceptions.EstoqueInsuficienteException;
import Exceptions.ProdutoJaExisteException;
import Exceptions.ProdutoNaoEncontradoException;
import Model.Produto;

public class ServiceProduto {
    
    Map<Integer, Produto> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    List<Produto> list = new ArrayList<>();

    public void cadastrar(Produto a){

        if(map.containsKey(a.getId())){
            throw new ProdutoJaExisteException("Id já cadastrado");
        }

        if(set.contains(a.getNome())){
            throw new ProdutoJaExisteException("Nome já cadastrado");
        }

        map.put(a.getId(), a);
        set.add(a.getNome());
        list.add(a);
    }

    public void remover(int id){

        if(!map.containsKey(id)){
            throw new ProdutoNaoEncontradoException("Id não encontrado");
        }

        Produto a = map.get(id);

        map.remove(a.getId());
        set.remove(a.getNome());
        list.remove(id);
    }

    public void listar(){

        for(Produto a : list){
            System.out.println(a);
        }
    } 

    public void atualizarPreco(int id, double novoValor){

        if(!map.containsKey(id)){
            throw new ProdutoNaoEncontradoException("Id não encontrado");
        }

        if(novoValor <= 0){
            throw new EstoqueInsuficienteException("Não pode preço negativo");
        }

        Produto a = map.get(id);

        a.setPreco(novoValor);
    }

    public void entradaEstq(int id, int valorEntrada){
        if(!map.containsKey(id)){
            throw new ProdutoNaoEncontradoException("Id não encontrado");
        }

        if(valorEntrada < 0){
            throw new EstoqueInsuficienteException("Valor negativo");
        }

        Produto a = map.get(id);

        a.setQuantEmEstoque(valorEntrada + a.getQuantEmEstoque());
    } 

    public void saidaEstq(int id, int valorSaida){

        if(!map.containsKey(id)){
            throw new ProdutoNaoEncontradoException("Id não encontrado");
        }

         Produto a = map.get(id);

        if (valorSaida <= 0) {
            throw new IllegalArgumentException("Valor de saída deve ser maior que zero");
        }

        if (valorSaida > a.getQuantEmEstoque()) {
            throw new EstoqueInsuficienteException("Estoque insuficiente");
        }

        a.setQuantEmEstoque(a.getQuantEmEstoque() - valorSaida);

    }

}
