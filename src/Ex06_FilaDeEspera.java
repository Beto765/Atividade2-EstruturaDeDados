import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Exercício 6 - Sistema de Fila de Espera (Fila)
 *
 * Simula a fila de pacientes de uma clínica (FIFO - o primeiro a
 * chegar é o primeiro a ser atendido). Permite adicionar, chamar
 * (remover) e exibir a ordem de atendimento.
 */
public class Ex06_FilaDeEspera {

    private Queue<String> fila = new LinkedList<>();
    private int senha = 1;

    public void adicionarPaciente(String nome) {
        String registro = String.format("Senha %03d - %s", senha++, nome);
        fila.offer(registro);
        System.out.println("Paciente adicionado: " + registro);
    }

    public void chamarProximo() {
        String atendido = fila.poll(); // retorna null se a fila estiver vazia
        if (atendido == null) {
            System.out.println("Não há pacientes aguardando.");
        } else {
            System.out.println("Chamando para atendimento: " + atendido);
        }
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }
        System.out.println("Ordem de atendimento (" + fila.size() + " aguardando):");
        int posicao = 1;
        for (String p : fila) {
            System.out.println("  " + posicao++ + "º - " + p);
        }
    }

    public static void main(String[] args) {
        Ex06_FilaDeEspera clinica = new Ex06_FilaDeEspera();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== CLÍNICA - FILA DE ESPERA ===");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Chamar próximo paciente");
            System.out.println("3 - Exibir fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.hasNextInt() ? sc.nextInt() : 0;
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    clinica.adicionarPaciente(sc.nextLine());
                    break;
                case 2:
                    clinica.chamarProximo();
                    break;
                case 3:
                    clinica.exibirFila();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
