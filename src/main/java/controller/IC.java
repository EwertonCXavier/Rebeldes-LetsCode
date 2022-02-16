package controller;

import domain.Rebelde;
import enums.SortEnum;
import view.RebeldeView;

import java.io.*;
import java.util.*;
import java.util.List;

public class IC {
  RebeldeView rebeldeView = new RebeldeView();
  Random random = new Random();
  static Scanner input = new Scanner(System.in);
  List<String> rebelsFile = new LinkedList<>();
  LinkedList<Rebelde> rebeldes = new LinkedList<>();


  public IC() {
    rebeldes = new LinkedList<Rebelde>();
  }

  public void menu() throws FileNotFoundException, UnsupportedEncodingException {
    String response;
    rebeldeView.apresentacaoInicial();
    do {
      System.out.println("Você deseja adicionar um novo candidato? S - SIM; n - NAO");
      response = input.nextLine();
      switch (response.toUpperCase()) {
        case "S":
          this.request();
          break;
        case "N":
          sortMenu();
          rebeldeView.impressaoListaFinal(rebeldes);
          break;
        default:
          System.out.println("Entrada inválida!");
          menu();
          break;
      }
    } while (response.equalsIgnoreCase("S"));
  }

  public void sortList(SortEnum sortEnum) throws FileNotFoundException, UnsupportedEncodingException {
    SortAlgorithm sortAlgorithm = new SortAlgorithm(sortEnum);
    this.rebeldes = sortAlgorithm.mergeSort(this.rebeldes);
    rebeldeView.inserirRebelde(rebeldes);

  }


  public void sortMenu() throws FileNotFoundException, UnsupportedEncodingException {
    String sortVariable;
    System.out.println("Digite por qual propriedade deseja ordenar: N - Nome; I - Idade; R - Raça; O - Manter");
    sortVariable = input.nextLine();
    switch(sortVariable.toUpperCase()) {
      case "N":
        // TODO
        sortList(SortEnum.NOME);
        break;
      case "I":
        // TODO
        sortList(SortEnum.IDADE);
        break;
      case "R":
        // TODO
        sortList(SortEnum.RACA);
        break;
      case "O":
        // TODO
        System.out.println("Você decidiu por não ordenar!");
        break;
      default:
        System.out.println("Entrada inválida");
        sortMenu();
        break;

    }
  }


  public void request() throws FileNotFoundException, UnsupportedEncodingException {
    Rebelde rebelde = rebeldeView.addRebelde();
    if (random.nextInt(2) == 1) {
      System.out.println("Aceito!");
      rebeldes.add(rebelde);
    } else {
      System.out.println("Não aceito!");
    }

    for(int i = 0; i < rebeldes.size(); i++) {
      System.out.printf("Rebeldes[%d] = %s%n", i, rebeldes.get(i));
    }
  }

  public void getItemsInFile() throws IOException {
    BufferedReader writer = null;
    String currentLine;
    try {
      File rebelFile = new File("./rebeldes.txt");
      boolean exists = rebelFile.exists();
      System.out.println("Does this file exist? " + exists);
      if (exists) {
        writer = new BufferedReader(new FileReader("./rebeldes.txt"));
        while ((currentLine = writer.readLine()) != null) {
          rebelsFile.add(currentLine);
        }

        // Imprime o array criado
        for (int i = 0; i < rebelsFile.size(); i++) {
          System.out.printf("Linha[%d]: %s%n", i, rebelsFile.get(i));
        }
      } else {
        System.out.println("File does not exist!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      assert writer != null;
      writer.close();
    }
  }

//  public void sortItems() {
//    int start;
//    for (String s : rebelsFile) {
//      System.out.println("A substring NOME inicia em: " + s.indexOf("NOME"));
//      System.out.println("A substring NOME termina em: " + (s.indexOf("NOME") + "NOME".length() - 1));
//      start = (s.indexOf("NOME") + "NOME".length() + 2);
//      for (int i = start; i < s.length(); i++) {
//        System.out.print("" + s.charAt(i));
//        if (s.charAt(i) == ',') {
//          System.out.println("A posicao do indice é: " + i);
//          break;
//        }
//      }
//      System.out.println("\n");
//    }
//  }
}
