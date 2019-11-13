import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter your command(s).");

    String input;
    String actualCmd;
    String destination;

    do {
      input = reader.nextLine();
      actualCmd = input.split(" ")[0];

      if (actualCmd.equals("indexer")) {

        destination = input.split(" ")[1];
        try {
          File path = new File(destination);
          if (path.canRead()) {
            if (path.isFile()) {
              Lecture file = new Lecture();
              file.lire_lignes(path.getName());
              System.out.println(file.listeValeur);
            } else {
              // folder...
            }
          } else {
            System.out.println("File cannot be read.");
          }
        } catch (Exception e) {
          System.out.println("Not a valid path.");
        }
      } else if (actualCmd.equals("inverser")) {
  
      } else if (actualCmd.equals("afficher")) {

      } else if (actualCmd.equals("rechercher")) {

      } else if (actualCmd.equals("quit")) {
        System.out.println("You have exited the program.");
        reader.close();
      } else {
        System.out.println("This command is invalid");
      }
    } while (!actualCmd.equals("quit"));
  }
}