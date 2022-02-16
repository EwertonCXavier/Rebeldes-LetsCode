package view;

import controller.IC;
import domain.IRebelde;
import domain.Raca;
import domain.Rebelde;
import lombok.NonNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class RebeldeView implements IRebelde {
  private static PrintWriter writer = null;

  public Rebelde addRebelde() {
    Rebelde rebelde = Rebelde.builder()
        .nome(candidateName())
        .idade(candidateAge())
        .raca(candidateRace())
        .build();

    return rebelde;
  }

  public void apresentacaoInicial() throws FileNotFoundException, UnsupportedEncodingException {
    System.out.println("Seja bem-vindo à aplicação de seleção de Rebeldes: ");
  }

  public void impressaoListaFinal(LinkedList<Rebelde> rebeldes) {
    // Imprime todos os aprovados, na ordem selecionada
    for (int i = 0; i < rebeldes.size(); i++) {
      System.out.printf("Rebelde[%d] = %s%n", i, rebeldes.get(i));
    }
    System.out.println("Muito obrigado por ter acessado a aplicação. Abaixo é exibida a lista:");
  }

  public String candidateName() {
    Scanner input = new Scanner(System.in);
    String nome;
    System.out.print("Digite o nome do candidato à rebelde: ");
    nome = input.nextLine();

    return nome;
  }

  public int candidateAge() {
    Scanner input = new Scanner(System.in);
    int idade;
    try {
      System.out.print("Digite a idade do candidato à rebelde: ");
      idade = input.nextInt();
      while (idade <= 0) {
        System.out.print("Digite a idade do candidato à rebelde: ");
        idade = input.nextInt();
      }
    } catch (InputMismatchException e) {
      input.next();
      System.out.println("Tipo inválido!");
      System.out.print("Digite novamente a idade do candidato à rebelde: ");
      idade = input.nextInt();
    }
    input.nextLine();

    return idade;
  }

  public Raca candidateRace() {
    Scanner input = new Scanner(System.in);
    String raca;
    Raca racaEnum = null;

    System.out.print("Digite a raca do candidato à rebelde: ");
    raca = input.nextLine().toUpperCase();

    while (!raca.equalsIgnoreCase("HUMANO") && !raca.equalsIgnoreCase("GREE") && !raca.equalsIgnoreCase("RAKATA")) {
      System.out.print("Digite a raca do candidato à rebelde: ");
      raca = input.nextLine().toUpperCase();
    }
    racaEnum = Raca.valueOf(raca);
    System.out.printf("Raca Enum: %s\n", racaEnum);

    return racaEnum;
  }


  @Override
  public void inserirRebelde(@NonNull LinkedList<Rebelde> rebeldes) throws FileNotFoundException, UnsupportedEncodingException {

    try {
      File rebelFile = new File("./rebeldes.txt");
      boolean exists = rebelFile.exists();
      System.out.println("Does this file exist? " + exists);

      if (exists) {
        writer = new PrintWriter(new BufferedWriter(new FileWriter("rebeldes.txt", true)));
        if (rebeldes.size() > 0) {
          for (Rebelde rebelde : rebeldes) {
            writer.printf("NOME: %s, IDADE: %s e RACA: %s%n", rebelde.getNome(), rebelde.getIdade(), rebelde.getRaca());
          }
        }

      } else {
        writer = new PrintWriter("rebeldes.txt", StandardCharsets.UTF_8);
        writer.println("LISTA DE REBELDES ACEITOS: ");
        for (Rebelde rebelde : rebeldes) {
          writer.printf("NOME: %s, IDADE: %s e RACA: %s%n", rebelde.getNome(), rebelde.getIdade(), rebelde.getRaca());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      writer.close();
    }
  }


}
