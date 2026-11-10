import java.util.ArrayList;

/**
 * Exercício 3 - Mesclar Listas (ArrayList)
 *
 * Recebe duas listas de convidados e devolve uma nova lista com os
 * nomes intercalados (1º da lista A, 1º da lista B, 2º da A, 2º da B...).
 * Se uma lista for maior, os nomes que sobrarem entram no final.
 */
public class Ex03_MesclarListas {

    public static ArrayList<String> intercalar(ArrayList<String> listaA, ArrayList<String> listaB) {
        ArrayList<String> resultado = new ArrayList<>();
        int maior = Math.max(listaA.size(), listaB.size());

        for (int i = 0; i < maior; i++) {
            if (i < listaA.size()) {
                resultado.add(listaA.get(i));
            }
            if (i < listaB.size()) {
                resultado.add(listaB.get(i));
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<String> convidadosNoivo = new ArrayList<>();
        convidadosNoivo.add("Carlos");
        convidadosNoivo.add("Eduardo");
        convidadosNoivo.add("Fernanda");

        ArrayList<String> convidadosNoiva = new ArrayList<>();
        convidadosNoiva.add("Juliana");
        convidadosNoiva.add("Marcos");
        convidadosNoiva.add("Patrícia");
        convidadosNoiva.add("Rafael");
        convidadosNoiva.add("Sofia");

        System.out.println("Lista 1: " + convidadosNoivo);
        System.out.println("Lista 2: " + convidadosNoiva);

        ArrayList<String> listaFinal = intercalar(convidadosNoivo, convidadosNoiva);
        System.out.println("\nLista intercalada: " + listaFinal);
    }
}
