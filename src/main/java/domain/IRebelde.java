package domain;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface IRebelde {
  abstract void inserirRebelde(Rebelde rebelde) throws FileNotFoundException, UnsupportedEncodingException;
}
