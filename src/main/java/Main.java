import controller.IC;
import domain.Raca;
import domain.Rebelde;
import view.RebeldeView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static domain.Raca.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new IC().menu();
  }
}
