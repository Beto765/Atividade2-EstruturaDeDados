import java.util.HashMap;
import java.util.Map;

/**
 * Exercício 9 - Mesclar Mapas (HashMap)
 *
 * Mescla dois registros de inventário (produto -> quantidade em estoque).
 * Tratamento de conflito: quando o mesmo produto aparece nos dois
 * mapas, as quantidades são SOMADAS, e o conflito é informado na tela.
 */
public class Ex09_MesclarMapas {

    public static HashMap<String, Integer> mesclarInventarios(HashMap<String, Integer> estoqueA,
                                                              HashMap<String, Integer> estoqueB) {
        // Começa com uma cópia do primeiro mapa para não alterar o original
        HashMap<String, Integer> resultado = new HashMap<>(estoqueA);

        for (Map.Entry<String, Integer> item : estoqueB.entrySet()) {
            String produto = item.getKey();
            int qtdB = item.getValue();

            if (resultado.containsKey(produto)) {
                int qtdA = resultado.get(produto);
                System.out.println("  Conflito em \"" + produto + "\": " + qtdA + " + " + qtdB
                        + " = " + (qtdA + qtdB));
                resultado.put(produto, qtdA + qtdB);
            } else {
                resultado.put(produto, qtdB);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> lojaCentro = new HashMap<>();
        lojaCentro.put("Notebook", 10);
        lojaCentro.put("Mouse", 50);
        lojaCentro.put("Teclado", 30);
        lojaCentro.put("Monitor", 8);

        HashMap<String, Integer> lojaShopping = new HashMap<>();
        lojaShopping.put("Mouse", 20);
        lojaShopping.put("Monitor", 5);
        lojaShopping.put("Impressora", 4);
        lojaShopping.put("Headset", 15);

        System.out.println("Inventário 1: " + lojaCentro);
        System.out.println("Inventário 2: " + lojaShopping);
        System.out.println("\nMesclando...");

        HashMap<String, Integer> inventarioFinal = mesclarInventarios(lojaCentro, lojaShopping);

        System.out.println("\nInventário mesclado:");
        for (Map.Entry<String, Integer> e : inventarioFinal.entrySet()) {
            System.out.println("  " + e.getKey() + ": " + e.getValue() + " unidades");
        }
    }
}
