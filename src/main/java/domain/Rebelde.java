package domain;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Rebelde implements IRebelde{
  private String nome;
  private int idade;
  private Raca raca;

  public Rebelde() {
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getIdade() {
    return this.idade;
  }

  public void setRaca(Raca raca) {
    this.raca = raca;
  }

  public Raca getRaca() {
    return this.raca;
  }

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
    PrintWriter writer = null;
    try {
      writer = new PrintWriter("rebeldes.txt", "UTF-8");
      writer.println("LISTA DE REBELDES ACEITOS: ");
      writer.println("Nome: " + rebelde.getNome() + ", Idade: " + rebelde.getIdade() + " e Raca: " + rebelde.getRaca());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } finally {
      writer.close();
    }
  }
}
