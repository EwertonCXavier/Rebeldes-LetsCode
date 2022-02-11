import controller.IC;
import domain.Rebelde;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static domain.Raca.GREE;
import static domain.Raca.HUMANO;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    Rebelde rebelde = new Rebelde();
    IC ic = new IC(rebelde);

    rebelde.setNome("Not Human");
    rebelde.setIdade(46);
    rebelde.setRaca(GREE);

    System.out.println(rebelde.toString());

    ic.request();
  }
}
