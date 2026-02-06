package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Exceptions.ProdutoJaExisteException;
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
}
