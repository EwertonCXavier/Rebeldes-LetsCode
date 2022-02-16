package controller;

import domain.Rebelde;
import enums.SortEnum;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
@Setter
@AllArgsConstructor
public class SortAlgorithm {
  private SortEnum sortParam;

  private LinkedList<Rebelde> merge(LinkedList<Rebelde> esquerda, LinkedList<Rebelde> direita) {
    // Cria o array auxiliar
    LinkedList<Rebelde> array = new LinkedList<>();
    // "Tamanhos" dos arrays da esquerda e direita, nesta ordem
    int leftSize = esquerda.size();
    int rightSize = direita.size();

    switch(sortParam) {
      case NOME:
        while(leftSize != 0 && rightSize != 0) {
          assert esquerda.peek() != null;
          assert direita.peek() != null;
          if(esquerda.peek().getNome().compareTo(direita.peek().getNome()) < 0) {
            array.add(esquerda.poll());
            leftSize--;
          } else {
            array.add(direita.poll());
            rightSize--;
          }
        }
        break;
      case IDADE:
        while(leftSize != 0 && rightSize != 0) {
          assert esquerda.peek() != null;
          assert direita.peek() != null;
          if(esquerda.peek().getIdade() < direita.peek().getIdade()) {
            array.add(esquerda.poll());
            leftSize--;
          } else {
            array.add(direita.poll());
            rightSize--;
          }
        }
        break;
      case RACA:
        while(leftSize != 0 && rightSize != 0) {
          assert esquerda.peek() != null;
          assert direita.peek() != null;
          if(esquerda.peek().getRaca().compareTo(direita.peek().getRaca()) < 0) {
            array.add(esquerda.poll());
            leftSize--;
          } else {
            array.add(direita.poll());
            rightSize--;
          }
        }
        break;
    }
    if(esquerda.size() > 0) {
      array.addAll(esquerda);
    } else if (direita.size() > 0) {
      array.addAll(direita);
    }

    return array;
  }


  public LinkedList<Rebelde> mergeSort(LinkedList<Rebelde> rebeldes) {
    if(rebeldes == null || rebeldes.size() <= 1) {
      return rebeldes;
    }

    int halfList = (int) Math.floor(rebeldes.size() / 2);

    LinkedList<Rebelde> leftHalf = new LinkedList<>(rebeldes.subList(0, halfList));
    LinkedList<Rebelde> rightHalf = new LinkedList<>(rebeldes.subList(halfList, rebeldes.size()));
    return merge(mergeSort(leftHalf), mergeSort(rightHalf));
  }

}
