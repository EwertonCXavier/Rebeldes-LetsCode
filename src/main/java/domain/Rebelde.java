package domain;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Rebelde implements IRebelde {
  @NotNull(message="É necessário ter um nome.")
  private String nome;
  @NotNull(message="É necessária idade.")
  private int idade;
  @NotNull(message="É necessária Raça.")
  private Raca raca;
  private static PrintWriter writer = null;

  @Override
  public void inserirRebelde(@NonNull LinkedList<Rebelde> rebeldes) throws FileNotFoundException, UnsupportedEncodingException {

    try {
      File rebelFile = new File("./rebeldes.txt");
      boolean exists = rebelFile.exists();
      System.out.println("Does this file exist? " + exists);

      if (exists) {
        writer = new PrintWriter(new BufferedWriter(new FileWriter("rebeldes.txt", true)));
        if(rebeldes.size() > 0) {
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
