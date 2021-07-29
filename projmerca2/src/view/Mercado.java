package view;

import helper.Utils;
import model.Produto;

import java.lang.reflect.Array;
import java.util.*;

public class Mercado {
    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer>carrinho;


    public static void main(String[] args){
    produtos = new ArrayList<Produto>();
    carrinho = new HashMap<Produto, Integer>();
    Mercado.menu();
    }
    private static void menu(){
        System.out.println("===================================");
        System.out.println("==========Bem - Vindo(a)===========");
        System.out.println("=============SHOP==================");
        System.out.println("===================================");

        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produto");
        System.out.println("3 - Comprar produto");
        System.out.println("4 - Visualizar carrinho");
        System.out.println("5 - Sair do sistema");

        int opcao = 0;
        try{
            opcao = Integer.parseInt(Mercado.teclado.nextLine());
        }catch (InputMismatchException e ){
            Mercado.menu();
        }catch (NumberFormatException f){
            Mercado.menu();
        }
        switch (opcao){ 
            case 1:
                Mercado.Cadastrarproduto();
                break;
            case 2:
                Mercado.ListarProdutos();
                break;
            default:
            case 3:
                Mercado.ComprarProduto();
                break;
            case 4:
                Mercado.VisualizarCArrinho();
                break;
            case 5:
                System.out.println("volte sempre!");
                Utils.pausar(2);
                System.exit(0);

                System.out.println("opção invalida.");
                Utils.pausar(2);
                Mercado.menu();
                break;

                
        }
    }

    private static void VisualizarCArrinho() {
            System.out.println("Ainda não existem produtos no carrinho carrinho");
        }

    private static void ComprarProduto () {
        System.out.println("comprando produto...");
    }

    private static void ListarProdutos() {
        if (Mercado.produtos.size() > 0 ){
            System.out.println(" Listando  Produto");
            System.out.println();

            for (Produto p : Mercado.produtos){
                System.out.println(p);
                System.out.println();
            }
        }else{
            System.out.println("AInda não existem produtos cadastrados.....");
        }
    }

    private static void Cadastrarproduto() {
        System.out.println(" Cadastro de Produto");
        System.out.println("====================");

        System.out.println(" Informe o nome do Produto");
        String nome = Mercado.teclado.nextLine();

        System.out.println(" Informe o preço do produto");
        Double preco = Mercado.teclado.nextDouble();
        Produto produto = new Produto(nome, preco);
        Mercado.produtos.add(produto);
        System.out.println(" O produto " + produto.getNome() + " foi cadastrado com sucesso");
        Utils.pausar(2);
        Mercado.menu();

    }
}
