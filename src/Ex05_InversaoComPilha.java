import java.util.ArrayList;
import java.util.Stack;

/**
 * Exercício 5 - Inversão com Pilha
 *
 * Usa uma pilha (LIFO - o último a entrar é o primeiro a sair)
 * para inverter a ordem de uma lista de produtos.
 */
public class Ex05_InversaoComPilha {

    public static ArrayList<String> inverterComPilha(ArrayList<String> produtos) {
        Stack<String> pilha = new Stack<>();

        // 1) Empilha todos os produtos na ordem original
        for (String p : produtos) {
            pilha.push(p);
        }

        // 2) Desempilha: sai primeiro quem entrou por último
        ArrayList<String> invertida = new ArrayList<>();
        while (!pilha.isEmpty()) {
            invertida.add(pilha.pop());
        }
        return invertida;
    }

    public static void main(String[] args) {
        ArrayList<String> produtos = new ArrayList<>();
        produtos.add("Teclado");
        produtos.add("Mouse");
        produtos.add("Monitor");
        produtos.add("Headset");
        produtos.add("Webcam");

        System.out.println("Ordem de inserção: " + produtos);
        System.out.println("Ordem inversa:     " + inverterComPilha(produtos));
    }
}
