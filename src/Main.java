/* Sou um estudante de Ciência da Computação e amante de programação. Estou desenvolvendo conhecimentos
na linguagem de progração JAVA, a qual tenho me familiarizado bem. No código a seguir, coloquei em
prática conhecimentos prévios de Programação Orientada a Objetos, através de um sistema simples de
Gerenciamento de Carros.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Classe Carro
class Carro {
    private String modelo;
    private String marca;
    private int ano;
    private String placa;
    private double preco;
    private boolean disponivel;

    //Construtor
    public Carro(String modelo, String marca, int ano, String placa, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.preco = preco;
        this.disponivel = true; // Por padrão, o carro está disponível
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

    public boolean isDisponivel() {
        return disponivel;
    }

    public void alterarDisponibilidade() {
        this.disponivel = !this.disponivel;
    }

    @Override
    public String toString() {
        String status = disponivel ? "Disponível" : "Indisponível";
        return "Modelo: " + modelo + "\n" +
                "Marca: " + marca + "\n" +
                "Ano: " + ano + "\n" +
                "Placa: " + placa + "\n" +
                "Preço: R$ " + preco + "\n" +
                "Status: " + status + "\n";
    }
}

//Classe Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Carro> carros = new ArrayList<>();

        while (true) {
            System.out.println("\n----* Sistema de Gerenciamento de Carros *----");
            System.out.println("1. Adicionar Carro");
            System.out.println("2. Listar Carros");
            System.out.println("3. Alterar Disponibilidade");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n=== Adicionar Carro ===");
                    System.out.print("Digite o modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Digite a marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Digite o ano: ");
                    int ano = scanner.nextInt();

                    System.out.print("Digite a placa: ");
                    scanner.nextLine(); // Consumir quebra de linha
                    String placa = scanner.nextLine();

                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir quebra de linha

                    Carro carro = new Carro(modelo, marca, ano, placa, preco);
                    carros.add(carro);
                    System.out.println("Carro adicionado com sucesso!");
                }
                case 2 -> {
                    System.out.println("\n=== Listar Carros ===");
                    if (carros.isEmpty()) {
                        System.out.println("Não há carros cadastrados.");
                    } else {
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.println("Carro " + (i + 1) + ":");
                            System.out.println(carros.get(i));
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\n=== Alterar Disponibilidade ===");
                    if (carros.isEmpty()) {
                        System.out.println("Não há carros cadastrados.");
                    } else {
                        System.out.print("Digite o número do carro para alterar disponibilidade: ");
                        int indice = scanner.nextInt();
                        scanner.nextLine(); // Consumir quebra de linha

                        if (indice > 0 && indice <= carros.size()) {
                            Carro carro = carros.get(indice - 1);
                            carro.alterarDisponibilidade();
                            System.out.println("Disponibilidade alterada com sucesso!");
                            System.out.println(carro);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

