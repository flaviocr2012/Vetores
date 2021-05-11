package vetores;

import java.util.Arrays;

public class Vetor {

    private Aluno [] alunos = new Aluno [100];
    private int totalDeAlunos = 0; // a variavel aponta a próxima posicao vazia e a quantidade de elementos.

    // adiciona no fim da lista.
    public void adiciona(Aluno aluno) {
        this.garanteEspaco();
        // guarda a variavel aluno direto na posicao onde está nulo. Não precisa percorrer o array inteiro.
        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
        // O problema desse algoritmo é a performance dele. Quanto maio o array, mais devagar é o programa.
        // O programa terá que percorrer a lista inteira para achar uma posição vazia. Inserir um aluno,
        // depende do tamanho da lista. Possui complexidade O de N.
//        for(int i = 0; i < alunos.length; i++) {
//            if(alunos[i] == null) {
//                alunos[i] = aluno;
//                break;
//            }
//        }
    }
        // método auxiliar pro adiciona no meio
        private boolean posicaoValida(int posicao) {
            return posicao >= 0 && posicao <= totalDeAlunos;
        }

        private void garanteEspaco() {
            if(totalDeAlunos == alunos.length) {
                Aluno[] novoArray = new Aluno[alunos.length * 2];
                for(int i = 0; i < totalDeAlunos; i++) {
                    novoArray[i] = alunos[i];
                }
                this.alunos = novoArray;
            }
        }
        // adiciona no meio da lista. Empurra pra direita.
        public void adiciona(int posicao, Aluno aluno) {
            this.garanteEspaco();
            if(!posicaoValida(posicao)) {
                throw new IllegalArgumentException("posição inválida");
            }
            for(int i = totalDeAlunos -1; i >= posicao; i -= 1) {
                alunos[i+1] = alunos[i];
            }
            alunos[posicao] = aluno;
            totalDeAlunos++;
        }


    // método auxiliar pra validar se a posição no array está dentro do número de elementos.
    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < totalDeAlunos;
    }

    // método que traz o aluno, passando determinada posicao.
    public Aluno pega(int posicao) {
        if(!posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("posição inválida");
        }

        return alunos[posicao];
    }
    // empurra pra esquerda.
    public void remove(int posicao) {
        for(int i = posicao; i < totalDeAlunos; i++) {
            this.alunos[i] = this.alunos[i+1];
        }
        totalDeAlunos--;
    }
    // Esse método descobre se o aluno está ou não na lista
    public boolean contem(Aluno aluno) {
        // ao invés de percorrer o array inteiro, eu percorro somente as posições em que há elemento.
        //
        // total de alunos no lugar alunos.length. Assim não dá NullPointer.
        for(int i = 0; i < totalDeAlunos; i++) {
            if(aluno.equals(alunos[i])) {
                return true;
            }
        }
        return false;
    }
    // quantidade de alunos que estão nesse vetor
    public int tamanho() {
        return totalDeAlunos;
    }

    // pega todos os elementos do Array e chama o toString de deles.
    public String toString() {
        return Arrays.toString(alunos);
    }

}
