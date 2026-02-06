package Ui;

import java.util.Scanner;

import Enum.Categoria;
import Exceptions.EstoqueInsuficienteException;
import Exceptions.ProdutoJaExisteException;
import Exceptions.ProdutoNaoEncontradoException;
import Model.Produto;
import Service.ServiceProduto;

public class Menu {
    
    public void menu(){

        int op = 10;
        Scanner sc = new Scanner(System.in);
        ServiceProduto service = new ServiceProduto();

        while (op != 7) {
            
            System.out.println("----------MENU----------");
            System.out.println("1- Cadastrar");
            System.out.println("2- Remover");
            System.out.println("3- Listar");
            System.out.println("4- Atualizar preço");
            System.out.println("5- Entrada de estoque");
            System.out.println("6- Saida de estoque");
            System.out.println("7- Sair");
            System.out.println("------------------------");
            System.out.print("Opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    
                    try{
                        System.out.print("Id: ");
                        int id = sc.nextInt();
                        sc.nextLine(); //Limpar buffer
                        System.out.print("Nome:");
                        String nome = sc.nextLine();
                        System.out.print("Categoria: ");
                        String salvar = sc.nextLine().toUpperCase();
                        Categoria categoria = Categoria.valueOf(salvar);
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        Produto a = new Produto(id, nome, categoria, preco, quantidade);
                        service.cadastrar(a);
                        System.out.println("Produto cadastrado com sucesso");

                    }catch(ProdutoJaExisteException e){
                        System.out.println("Erro: "+ e.getMessage());
                    }catch(EstoqueInsuficienteException e2){
                        System.out.println("Erro: "+ e2.getMessage()
                    );
                    }


                    break;
                case 2:
                    try{
                        System.out.print("Id: ");
                        int idRemover = sc.nextInt();

                        service.remover(idRemover);
                        System.out.println("Produto removido com sucesso");

                    }catch(ProdutoNaoEncontradoException e){
                        System.out.println("Erro: "+ e.getMessage());
                    }

                    break;
                case 3:
                    
                    service.listar();

                    break;
                case 4:
                    
                    try {
                        System.out.print("Id: ");
                        int idAtualizarPreco = sc.nextInt();
                        System.out.print("valor: ");
                        double novoValor = sc.nextDouble();

                        service.atualizarPreco(idAtualizarPreco, novoValor);

                        System.out.println("Valor atualizado com sucesso");
                        
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println("Erro: "+ e.getMessage());
                    }catch(EstoqueInsuficienteException e2){
                        System.out.println("Erro: "+ e2.getMessage());
                    }

                    break;
                case 5:
                    
                    try{
                        System.out.print("Id: ");
                        int idEstoq = sc.nextInt();
                        System.out.print("Entrada no estoque:  ");
                        int estoqueEntrada = sc.nextInt();

                        service.entradaEstq(idEstoq, estoqueEntrada);

                    }catch(ProdutoNaoEncontradoException e){
                        System.out.println("Erro: "+ e.getMessage());
                    }catch(EstoqueInsuficienteException e2){
                        System.out.println("Erro: "+ e2.getMessage());
                    }

                    break;
                case 6:
                
                    try{
                        System.out.print("Id: ");
                        int idEstoq = sc.nextInt();
                        System.out.print("Saida do estoque:  ");
                        int estoqueSaida = sc.nextInt();

                        service.saidaEstq(idEstoq, estoqueSaida);
                        
                    }catch(ProdutoNaoEncontradoException e){
                        System.out.println("Erro: "+ e.getMessage());
                    }catch(EstoqueInsuficienteException e2){
                        System.out.println("Erro: "+ e2.getMessage());
                    }

                    break;
                case 7:
                    System.out.println("Saindo");
                    break;
            
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }
}
