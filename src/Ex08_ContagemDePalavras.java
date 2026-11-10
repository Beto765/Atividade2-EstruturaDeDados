import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Exercício 8 - Contagem de Palavras (HashMap)
 *
 * Conta quantas vezes cada palavra aparece em um texto usando um
 * HashMap<palavra, quantidade> e depois mostra as mais frequentes.
 */
public class Ex08_ContagemDePalavras {

    public static HashMap<String, Integer> contarPalavras(String texto) {
        HashMap<String, Integer> frequencia = new HashMap<>();

        // Deixa tudo minúsculo e remove pontuação (mantém letras com acento)
        String limpo = texto.toLowerCase().replaceAll("[^\\p{L}\\p{N}\\s]", " ");
        String[] palavras = limpo.trim().split("\\s+");

        for (String p : palavras) {
            if (p.isEmpty()) continue;
            // Se a palavra já existe, soma 1; senão começa em 1
            frequencia.put(p, frequencia.getOrDefault(p, 0) + 1);
        }
        return frequencia;
    }

    public static void main(String[] args) {
        String artigo = "Java é uma linguagem popular. Java é usada em sistemas web, "
                + "e sistemas Java rodam em muitos servidores. A linguagem Java é "
                + "orientada a objetos e a linguagem é muito usada no mercado.";

        HashMap<String, Integer> contagem = contarPalavras(artigo);

        System.out.println("Texto analisado:\n" + artigo + "\n");
        System.out.println("Frequência de cada palavra:");
        for (Map.Entry<String, Integer> e : contagem.entrySet()) {
            System.out.println("  " + e.getKey() + " = " + e.getValue());
        }

        // Ordena as entradas por frequência (decrescente) para achar as mais comuns
        ArrayList<Map.Entry<String, Integer>> ranking = new ArrayList<>(contagem.entrySet());
        ranking.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("\nTop 3 palavras mais comuns:");
        for (int i = 0; i < 3 && i < ranking.size(); i++) {
            System.out.println("  " + (i + 1) + "º \"" + ranking.get(i).getKey()
                    + "\" - " + ranking.get(i).getValue() + " vezes");
        }
    }
}
