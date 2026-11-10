import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercício 1 - Inversão de Lista (ArrayList)
 *
 * Inverte a lista de tarefas do dia SEM usar métodos prontos
 * (como Collections.reverse). A inversão é feita trocando os
 * elementos das pontas em direção ao meio (dois índices).
 */
public class Ex01_InversaoDeLista {

    // Inverte a própria lista trocando o primeiro com o último,
    // o segundo com o penúltimo, e assim por diante.
    public static void inverterLista(ArrayList<String> lista) {
        int inicio = 0;
        int fim = lista.size() - 1;

        while (inicio < fim) {
            String temp = lista.get(inicio);
            lista.set(inicio, lista.get(fim));
            lista.set(fim, temp);
            inicio++;
            fim--;
        }
    }

    public static void exibirLista(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + lista.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        tarefas.add("Responder e-mails");
        tarefas.add("Reunião com a equipe");
        tarefas.add("Estudar Estrutura de Dados");
        tarefas.add("Ir à academia");
        tarefas.add("Preparar o jantar");

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== LISTA DE TAREFAS ===");
            System.out.println("1 - Ver lista na ordem normal");
            System.out.println("2 - Ver lista do fim para o começo");
            System.out.println("3 - Adicionar tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.hasNextInt() ? sc.nextInt() : 0;
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\nTarefas (ordem normal):");
                    exibirLista(tarefas);
                    break;
                case 2:
                    // Trabalha em uma cópia para não alterar a lista original
                    ArrayList<String> invertida = new ArrayList<>(tarefas);
                    inverterLista(invertida);
                    System.out.println("\nTarefas (ordem inversa):");
                    exibirLista(invertida);
                    break;
                case 3:
                    System.out.print("Nova tarefa: ");
                    String nova = sc.nextLine();
                    tarefas.add(nova);
                    System.out.println("Tarefa adicionada!");
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
