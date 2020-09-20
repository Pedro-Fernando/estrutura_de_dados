package principais_estruturas.armazenamento_sequencial;

import principais_estruturas.modelando.Aluno;

public class VetorTeste {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("João");
        Aluno a2 = new Aluno("José");
        Aluno a3 = new Aluno("Paulo");

        Vetor lista = new Vetor();

        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(1, a3);
        lista.remove(1);

        System.out.println(lista.pega(1));
        System.out.println(lista);
    }
}
