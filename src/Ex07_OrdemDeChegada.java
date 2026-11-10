import java.util.LinkedList;
import java.util.Queue;

/**
 * Exercício 7 - Ordem de Chegada (Fila)
 *
 * Simula clientes chegando em uma loja durante uma promoção.
 * Os clientes entram na fila conforme chegam e saem na mesma
 * ordem (FIFO), mostrando que a ordem de saída = ordem de chegada.
 */
public class Ex07_OrdemDeChegada {

    public static void main(String[] args) {
        Queue<String> filaLoja = new LinkedList<>();
        String[] clientes = {"Mariana", "João", "Pedro", "Larissa", "Thiago", "Beatriz"};

        System.out.println("=== CHEGADA DOS CLIENTES ===");
        for (int i = 0; i < clientes.length; i++) {
            filaLoja.offer(clientes[i]);
            System.out.println((i + 1) + "º a chegar: " + clientes[i]
                    + "  | Fila atual: " + filaLoja);
        }

        System.out.println("\n=== ATENDIMENTO / SAÍDA ===");
        int ordem = 1;
        while (!filaLoja.isEmpty()) {
            String atendido = filaLoja.poll();
            System.out.println(ordem++ + "º a sair: " + atendido
                    + "  | Restam na fila: " + filaLoja);
        }

        System.out.println("\nTodos os clientes foram atendidos na ordem de chegada.");
    }
}
