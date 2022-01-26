package controller;

import domain.Rebelde;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import static domain.Raca.*;

public class IC {
  Random random = new Random();
  Rebelde rebelde;

  public IC(Rebelde rebelde) {
    this.rebelde = rebelde;
  }

  public void request() throws FileNotFoundException, UnsupportedEncodingException {
    if ((rebelde.getRaca().equals(HUMANO) || rebelde.getRaca().equals(GREE) || rebelde.getRaca().equals(RAKATA)) && rebelde.getIdade() > 0 && !rebelde.getNome().equals("null")) {
      if (random.nextInt(2) == 1) {
        System.out.println("Aceito!");
        rebelde.inserirRebelde(rebelde);
      } else {
        System.out.println("Não aceito!");
      }
    } else {
      System.out.println("Raça não reconhecida!");
    }
  }
}
