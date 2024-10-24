public class PilhaHistorico {
    private String[] historico;
    private int topo;
    private int capacidade;
    private boolean permitirRepetidos;

    //By: @ Caio Duque
    //De início, a pilha estará vazia
    public PilhaHistorico(int capacidade, boolean permitirRepetidos) {
        this.capacidade = capacidade;
        this.historico = new String[capacidade];
        this.topo = -1;
        this.permitirRepetidos = permitirRepetidos;
    }

    //Método para adicionar uma nova URL na pilha, com verificador se a pilha está cheia
    public boolean push(String url) {
        if (isFull()) {
            System.out.println("Falha ao visitar página. Histórico cheio.");
            return false;
        }
        //Verificar a condição de repetição, caso negar, então impedir a adição de URLs iguais
        if (!permitirRepetidos && localizarElemento(url) != -1) {
            System.out.println("URL repetida não permitida.");
            return false;
        }
        historico[++topo] = url; //Isso irá adicionar a URL no topo da pilha
        System.out.println("Visitando: " + url);
        return true;
    }

    //Método para remover a última URL e voltar para a página anterior, com verificação
    public String pop() {
        if (isEmpty()) {
            System.out.println("Histórico vazio. Não é possível voltar.");
            return null;
        }
        String url = historico[topo--]; //Remover o elemento do topo
        return url; //Retornar a URL removida com sucesso
    }

    //Método para verificar se a pilha está cheia
    public boolean isFull() {
        return topo == capacidade - 1; //Retornar verdadeiro se a pilha estiver cheia
    }

    //Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1; //Retornar verdadeiro se a pilha estiver vazia
    }

    //Método para expor o conteúdo do histórico, com verificação
    public void print() {
        if (isEmpty()) {
            System.out.println("Histórico vazio.");
            return;
        }
        System.out.println("Histórico:");
        for (int i = 0; i <= topo; i++) {
            System.out.println((i + 1) + ". " + historico[i]);
        }
    }

    //Método para retornar a quantidade de páginas no histórico
    public int qtd() {
        return topo + 1;
    }

    //Método para obter a página mais recente visitada, com verificação
    public String getUltimaPagina() {
        if (isEmpty()) {
            return "Histórico vazio.";
        }
        return historico[topo];
    }

    //Método para localizar uma URL específica no histórico, com verificação, e retornar a posição da URL no histórico
    public int localizarElemento(String url) {
        for (int i = 0; i <= topo; i++) {
            if (historico[i].equals(url)) {
                return i + 1;
            }
        }
        return -1;
    }
}
