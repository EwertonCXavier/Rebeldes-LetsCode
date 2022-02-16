package domain;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public interface IRebelde {
  abstract void inserirRebelde(LinkedList<Rebelde> rebeldes) throws FileNotFoundException, UnsupportedEncodingException;
}
