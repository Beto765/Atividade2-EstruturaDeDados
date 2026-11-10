import java.util.ArrayList;

/**
 * Exercício 10 - Implementação de Algoritmo de Ordenação
 *
 * Ordena produtos pelo número de vendas, em ordem DECRESCENTE,
 * usando o Quick Sort implementado manualmente (sem métodos prontos).
 *
 * Quick Sort: escolhe um pivô, coloca à esquerda os produtos com
 * MAIS vendas que o pivô e à direita os com MENOS, e repete o
 * processo recursivamente em cada lado. Complexidade média O(n log n).
 */
public class Ex10_OrdenacaoPorVendas {

    // Classe simples para representar um produto
    static class Produto {
        String nome;
        int vendas;

        Produto(String nome, int vendas) {
            this.nome = nome;
            this.vendas = vendas;
        }
    }

    public static void quickSort(ArrayList<Produto> lista, int inicio, int fim) {
        if (inicio < fim) {
            int posPivo = particionar(lista, inicio, fim);
            quickSort(lista, inicio, posPivo - 1);
            quickSort(lista, posPivo + 1, fim);
        }
    }

    // Usa o último elemento como pivô (esquema de Lomuto)
    private static int particionar(ArrayList<Produto> lista, int inicio, int fim) {
        int pivo = lista.get(fim).vendas;
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            // ">" em vez de "<" para a ordem ficar decrescente
            if (lista.get(j).vendas > pivo) {
                i++;
                trocar(lista, i, j);
            }
        }
        trocar(lista, i + 1, fim);
        return i + 1;
    }

    private static void trocar(ArrayList<Produto> lista, int a, int b) {
        Produto temp = lista.get(a);
        lista.set(a, lista.get(b));
        lista.set(b, temp);
    }

    private static void exibir(ArrayList<Produto> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("  %2dº  %-22s %5d vendas%n", i + 1, lista.get(i).nome, lista.get(i).vendas);
        }
    }

    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Fone Bluetooth", 340));
        produtos.add(new Produto("Carregador USB-C", 1250));
        produtos.add(new Produto("Smartwatch", 210));
        produtos.add(new Produto("Capa de Celular", 980));
        produtos.add(new Produto("Mouse Gamer", 455));
        produtos.add(new Produto("Teclado Mecânico", 130));
        produtos.add(new Produto("Power Bank", 760));
        produtos.add(new Produto("Pendrive 64GB", 455));

        System.out.println("Produtos (ordem original):");
        exibir(produtos);

        quickSort(produtos, 0, produtos.size() - 1);

        System.out.println("\nMais vendidos (Quick Sort - decrescente):");
        exibir(produtos);
    }
}
