/* Sou um estudante de Ciência da Computação e amante de programação. Estou desenvolvendo conhecimentos
na linguagem de progração JAVA, a qual tenho me familiarizado bem. No código a seguir, coloquei em
prática conhecimentos prévios de Programação Orientada a Objetos, através de um sistema simples de
Gerenciamento de Carros.*/

import java.util.ArrayList;
import java.util.List;

// Classe Carro
class Carro {
    private String modelo;
    private String marca;
    private int ano;
    private String placa;
    private double preco;
    private boolean disponivel;  // Atributo que controla a disponibilidade

    // Construtor
    public Carro(String modelo, String marca, int ano, String placa, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.preco = preco;
        this.disponivel = true;  // Por padrão, o carro está disponível
    }

    // Getters e Setters

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Método para exibir as informações do carro
    public void exibirInfo() {
        String status = disponivel ? "Disponível" : "Indisponível"; // Verifica status de disponibilidade
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
        System.out.println("Placa: " + placa);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Status: " + status);
    }

    // Método para alterar a disponibilidade do carro
    public void alterarDisponibilidade() {
        this.disponivel = !this.disponivel;  // Alterna o estado de disponibilidade
    }
}

class GerenciamentoDeCarros {
    private List<Carro> carros;

    public GerenciamentoDeCarros() {
        carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro){
        carros.add(carro);
    }

    public void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Não há carros cadastrados.");
        } else {
            for (Carro carro : carros) {
                carro.exibirInfo();
                System.out.println(); // Apenas para separar cada carro na saída
            }
        }
    }

    public void alterarDisponibilidade(int indice) {
        if (indice >= 0 && indice < carros.size()) {
            Carro carro = carros.get(indice);
            carro.alterarDisponibilidade();  // Altera a disponibilidade do carro
            System.out.println("Disponibilidade alterada: ");
            carro.exibirInfo();  // Exibe as informações atualizadas do carro
        } else {
            System.out.println("Índice inválido.");
        }
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        // Criando alguns carros
        Carro carro1 = new Carro("Uno", "Fiat", 2020, "DSFDFS", 30000);
        Carro carro2 = new Carro("Gol", "Volkswagen", 2018, "ASKJDH", 45000);
        Carro carro3 = new Carro("Fox", "Volkswagen", 2018, "AOALAS", 60000);

        // Criando o sistema de gerenciamento
        GerenciamentoDeCarros sistema = new GerenciamentoDeCarros();

        // Adicionando carros ao sistema
        sistema.adicionarCarro(carro1);
        sistema.adicionarCarro(carro2);
        sistema.adicionarCarro(carro3);

        // Listando todos os carros cadastrados
        System.out.println("Lista de carros cadastrados: ");
        sistema.listarCarros();

        // Alterando a disponibilidade do carro 2
        System.out.println("\nAlterando a disponibilidade do carro 2 (Gol): ");
        sistema.alterarDisponibilidade(1);

        // Listando os carros após a alteração da disponibilidade
        System.out.println("\nLista de carros após alteração de disponibilidade: ");
        sistema.listarCarros();
    }
}

