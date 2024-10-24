import java.util.Scanner;

public class GerenciadorHistorico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //By: @ Caio Duque
        //Solicitar ao user o tamanho máximo do histórico e se permite URLs repetidas
        System.out.print("Defina o tamanho máximo do histórico: ");
        int capacidade = scanner.nextInt();
        System.out.print("Permitir repetição de URLs? (1 = Sim, 0 = Não): ");
        boolean permitirRepetidos = scanner.nextInt() == 1;

        //Criar o histórico baseado na entrada de dados enviada pelo user
        PilhaHistorico historico = new PilhaHistorico(capacidade, permitirRepetidos);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 -> Navegar para uma nova página");
            System.out.println("2 -> Voltar para a página anterior");
            System.out.println("3 -> Mostrar histórico");
            System.out.println("4 -> Mostrar quantidade de páginas no histórico");
            System.out.println("5 -> Mostrar última página visitada");
            System.out.println("6 -> Localizar uma página no histórico");
            System.out.println("0 -> Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL da nova página: ");
                    String url = scanner.nextLine();
                    historico.push(url);
                    break;

                case 2:
                    String paginaRemovida = historico.pop();
                    if (paginaRemovida != null) {
                        System.out.println("Voltando para a página: " + paginaRemovida);
                    }
                    break;

                case 3:
                    historico.print();
                    break;

                case 4:
                    System.out.println("Quantidade de páginas no histórico: " + historico.qtd());
                    break;

                case 5:
                    System.out.println("Última página visitada: " + historico.getUltimaPagina());
                    break;

                case 6:
                    System.out.print("Digite a URL a localizar: ");
                    String urlBusca = scanner.nextLine();
                    int posicao = historico.localizarElemento(urlBusca);
                    if (posicao != -1) {
                        System.out.println("Página '" + urlBusca + "' encontrada na posição " + posicao);
                    } else {
                        System.out.println("Página '" + urlBusca + "' não encontrada no histórico.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
