import java.util.ArrayList;

/**
 * Exercício 2 - Remoção de Elementos Duplicados (ArrayList)
 *
 * Remove contatos repetidos de uma lista, mantendo apenas a
 * primeira ocorrência de cada pessoa. A comparação ignora
 * maiúsculas/minúsculas e espaços extras ("Ana" == " ana ").
 */
public class Ex02_RemoverDuplicados {

    public static ArrayList<String> removerDuplicados(ArrayList<String> contatos) {
        ArrayList<String> resultado = new ArrayList<>();
        ArrayList<String> jaVistos = new ArrayList<>(); // versões normalizadas

        for (String contato : contatos) {
            String normalizado = contato.trim().toLowerCase();

            if (!jaVistos.contains(normalizado)) {
                jaVistos.add(normalizado);
                resultado.add(contato.trim());
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        ArrayList<String> usuarios = new ArrayList<>();
        usuarios.add("Ana Souza");
        usuarios.add("Bruno Lima");
        usuarios.add("ana souza");
        usuarios.add("Carla Mendes");
        usuarios.add("Bruno Lima");
        usuarios.add("Diego Alves");
        usuarios.add("  Carla Mendes ");

        System.out.println("Lista original (" + usuarios.size() + " contatos):");
        for (String u : usuarios) {
            System.out.println("  - " + u);
        }

        ArrayList<String> semDuplicados = removerDuplicados(usuarios);

        System.out.println("\nLista sem duplicados (" + semDuplicados.size() + " contatos):");
        for (String u : semDuplicados) {
            System.out.println("  - " + u);
        }

        System.out.println("\nRegistros removidos: " + (usuarios.size() - semDuplicados.size()));
    }
}
