import controller.IC;
import domain.Rebelde;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static domain.Raca.*;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    Rebelde rebelde = new Rebelde();

    rebelde.setNome("Unknown");
    rebelde.setIdade(46);
    rebelde.setRaca(RAKATA);

    /**
     * TODO
     *
     * Primeiro passo: Definir a quantidade de usuários que serão adicionados através de solicitação via usuário
     * Segundo passo: Mudar o tipo do vetor defindo em domain/Rebelde.java de Array para ArrayList (variável)
     * Terceiro passo: Criar uma instância de IC para cada um dos candidatos a rebeldes através de loop (inicialmente)
     * Quarto passo: Tentar otimizar a main através da criação de uma view ou controller responsáveis por esse gerenciamento
     *
     **/

    IC ic = new IC(rebelde);

    ic.request();
  }
}
