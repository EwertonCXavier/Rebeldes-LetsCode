package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;

@Getter
@Setter
@NoArgsConstructor
public class Rebelde implements IRebelde{
  private String nome;
  private int idade;
  private Raca raca;
  PrintWriter writer = null;


  @Override
  public String toString() {
    return "Rebelde{" +
        "nome='" + nome + '\'' +
        ", idade=" + idade +
        ", raca=" + raca +
        '}';
  }

  @Override
  public void inserirRebelde(Rebelde rebelde) throws FileNotFoundException, UnsupportedEncodingException {

    try {
      File rebelFile = new File("./rebeldes.txt");
      boolean exists = rebelFile.exists();
      System.out.println("Does this file exist? " + exists);

      if(exists) {
        writer = new PrintWriter(new BufferedWriter(new FileWriter("rebeldes.txt", true)));
        writer.println("Nome: " + rebelde.getNome() + ", Idade: " + rebelde.getIdade() + " e Raca: " + rebelde.getRaca());
      } else {
        writer = new PrintWriter("rebeldes.txt", "UTF-8");
        writer.println("LISTA DE REBELDES ACEITOS: ");
        writer.println("Nome: " + rebelde.getNome() + ", Idade: " + rebelde.getIdade() + " e Raca: " + rebelde.getRaca());
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      writer.close();
    }
  }
}
