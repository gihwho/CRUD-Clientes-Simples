import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clienteLista = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static int contId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    inserirCliente();
                    break;
                case 2:
                    listarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    deletarCliente();
                    break;
                case 5:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcao != 5);
    }

    private static void menu() {
        System.out.println("===============MENU===============");
        System.out.println("1. Inserir um cliente.\n");
        System.out.println("2. Listar um cliente.\n");
        System.out.println("3. Atualizar um cliente.\n");
        System.out.println("4. Deletar um cliente.\n");
        System.out.println("5. Sair.\n");
    }

    private static void inserirCliente() {
        System.out.println("\nDigite o nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("\nDigite o CPF do cliente: ");
        String cpf = input.nextLine();
        System.out.println("\nDigite o endereço do cliente: ");
        String endereco = input.nextLine();

        Cliente novoCliente = new Cliente(contId++, nome, cpf, endereco);
        clienteLista.add(novoCliente);

        System.out.println("Cliente inserido com sucesso!");
    }

    private static void listarCliente() {
        int op;
        do {
            System.out.println("1. Listar todos clientes.\n");
            System.out.println("2. Listar um cliente pelo ID.\n");
            System.out.println("3. Voltar.\n");
            op = input.nextInt();
            input.nextLine();

        switch (op) {
            case 1:
                listarTodos();
                break;
            case 2:
                listarID();
                break;
            case 3:
                System.out.println("\nRetornando ao menu...");
                menu();
        }
        } while (op != 3);
    }

    private static void listarTodos() {
        for (Cliente novoCliente : clienteLista) {
            System.out.println(novoCliente);
        }
    }

    private static void listarID() {
        System.out.println("Qual o ID do cliente? ");
        String ID = input.nextLine();

        boolean flagEncontrado = false;

        for (Cliente novoCliente : clienteLista) {
            if (String.valueOf(novoCliente.getId()).equals(ID)) {
                System.out.println("\nEncontrado!\n");
                System.out.println(novoCliente);
                flagEncontrado = true;
                break;
            }

            if (flagEncontrado != true) {
                System.out.println("\nCliente não encontrado!\n");
            }
        }
    }

    private static void atualizarCliente() {

    }

    private static void deletarCliente() {

    }
}