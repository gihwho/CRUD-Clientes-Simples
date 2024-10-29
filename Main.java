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
                    System.out.println("Opcao inválida");
            }
        } while (opcao != 5);
    }

    private static void menu() {
        System.out.println("===============MENU===============");
        System.out.println("1. Inserir um cliente.");
        System.out.println("2. Listar um cliente.");
        System.out.println("3. Atualizar um cliente.");
        System.out.println("4. Deletar um cliente.");
        System.out.println("5. Sair.");
    }

    private static void inserirCliente() {
        System.out.println("Digite o nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String cpf = input.nextLine();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = input.nextLine();

        Cliente novoCliente = new Cliente(contId++, nome, cpf, endereco);
        clienteLista.add(novoCliente);

        System.out.println("Cliente inserido com sucesso!\n");
    }

    private static void listarCliente() {
        int op;
        do {
            System.out.println("1. Listar todos clientes.");
            System.out.println("2. Listar um cliente pelo ID.");
            System.out.println("3. Voltar.");
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
                System.out.println("Retornando ao menu...");
                break;
            default:
                System.out.println("Opção inválida");
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
        int ID = input.nextInt();

        boolean flagEncontrado = false;

        for (Cliente novoCliente : clienteLista) {
            if (novoCliente.getId() == ID) {
                System.out.println("\nEncontrado!\n");
                System.out.println(novoCliente);
                flagEncontrado = true;
                break;
            }

            if (!flagEncontrado) {      //! se falso
                System.out.println("\nCliente não encontrado!\n");
            }
        }
    }

    private static void atualizarCliente() {
        System.out.println("Digite o ID do cliente que deseja alterar: ");
        int ID = input.nextInt();
        input.nextLine();

        Cliente clienteEncontrado = null;

        for (Cliente novoCliente : clienteLista) {
            if (novoCliente.getId() == ID) {
                clienteEncontrado = novoCliente;
                System.out.println("Cliente encontrado!");
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("Digite o novo nome: ");
            String novoNome = input.nextLine();
            clienteEncontrado.setNome(novoNome);

            System.out.println("Digite o novo CPF: ");
            String novoCPF = input.nextLine();
            clienteEncontrado.setCpf(novoCPF);

            System.out.println("Digite o novo endereco: ");
            String novoEndereco = input.nextLine();
            clienteEncontrado.setEndereco(novoEndereco);

            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private static void deletarCliente() {
        System.out.println("Digite o ID do cliente que deseja deletar: ");
        int ID = input.nextInt();

        Cliente clienteEncontrado = null;

        for (Cliente novoCliente : clienteLista) {
            if (novoCliente.getId() == ID) {
                clienteEncontrado = novoCliente;
                System.out.println("Cliente encontrado!");
                break;
            }
        }

        if (clienteEncontrado != null) {
            clienteLista.remove(clienteEncontrado);
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}