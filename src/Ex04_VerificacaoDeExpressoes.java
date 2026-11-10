import java.util.Stack;

/**
 * Exercício 4 - Verificação de Expressões (Pilha)
 *
 * Verifica se os parênteses (e também colchetes e chaves) de uma
 * expressão matemática estão balanceados, usando uma pilha:
 *  - ao encontrar um símbolo de abertura, empilha;
 *  - ao encontrar um de fechamento, desempilha e confere se combina;
 *  - no final, a pilha precisa estar vazia.
 */
public class Ex04_VerificacaoDeExpressoes {

    public static boolean estaBalanceada(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (char c : expressao.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // Fechou algo sem ter aberto antes
                if (pilha.isEmpty()) {
                    return false;
                }
                char topo = pilha.pop();
                if (!combina(topo, c)) {
                    return false;
                }
            }
            // Números, operadores e espaços são ignorados
        }
        // Se sobrou algo na pilha, algum símbolo ficou aberto
        return pilha.isEmpty();
    }

    private static boolean combina(char abre, char fecha) {
        return (abre == '(' && fecha == ')')
            || (abre == '[' && fecha == ']')
            || (abre == '{' && fecha == '}');
    }

    public static void main(String[] args) {
        String[] expressoes = {
            "(2 + 3) * (4 - 1)",
            "((5 + 2) * 3",
            "(8 / 2)) + 1",
            "{[3 + (2 * 4)] - 1}",
            "[(1 + 2])",
            ")3 + 4("
        };

        for (String exp : expressoes) {
            String status = estaBalanceada(exp) ? "BALANCEADA" : "ERRO - não balanceada";
            System.out.printf("%-25s -> %s%n", exp, status);
        }
    }
}
