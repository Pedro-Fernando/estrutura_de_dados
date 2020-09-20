package principais_estruturas.armazenamento_sequencial;

import principais_estruturas.modelando.Aluno;

import java.util.Arrays;

public class Vetor {

    private int limiteVetor = 100;
    private Aluno[] alunos = new Aluno[limiteVetor];
    private int proximaPosicaoVazia = 0;

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= proximaPosicaoVazia;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < proximaPosicaoVazia;
    }

    public void adiciona(int posicao, Aluno aluno){
        if (!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida.");
        }

        for (int i = proximaPosicaoVazia - 1; i >= posicao; i--){
            alunos[i+1] = alunos[i];
        }
        alunos[posicao] = aluno;
        proximaPosicaoVazia++;
    }
    public void adiciona(Aluno aluno) {
        if (proximaPosicaoVazia <= limiteVetor) {
            alunos[proximaPosicaoVazia] = aluno;
            proximaPosicaoVazia++;
        }
    }


    public Aluno pega(int posicao) {
        if (posicaoOcupada(posicao)) {
            return alunos[posicao];
        } else {
            throw new IllegalArgumentException("Posição inválida!");
        }
    }

    public void remove(int posicao) {
        for (int i = posicao; i < this.proximaPosicaoVazia; i++){
            this.alunos[i] = this.alunos[i + 1];
        }

        proximaPosicaoVazia--;
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < proximaPosicaoVazia; i++) {
            if (aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return proximaPosicaoVazia;
    }

    @Override
    public String toString() {
        return Arrays.toString(alunos);
    }
}
