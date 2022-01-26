import controller.IC;
import domain.Rebelde;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static domain.Raca.HUMANO;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    Rebelde rebelde = new Rebelde();
    IC ic = new IC(rebelde);

    rebelde.setNome("Teste");
    rebelde.setIdade(29);
    rebelde.setRaca(HUMANO);

    System.out.println(rebelde.toString());

    ic.request();
  }
}
