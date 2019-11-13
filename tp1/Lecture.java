import java.io.*;

class Lecture {
  ListeValeur listeValeur;

  public void lire_lignes(String nom) {
    //String[] lignes;
    // ouverture du fichier
    try {
      BufferedReader input = new BufferedReader(new FileReader(nom));
      // lire et traiter chaque ligne
      String ligne;
      String[] lignes;
      listeValeur = new ListeValeur();
      ligne = input.readLine();
      while (ligne != null) {
        // Split String into words 
        lignes = ligne.split("[ !\"\\#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]+");
        for (String word : lignes) {
          listeValeur.inserer(word, 1);
        }
        ligne = input.readLine();
      }
      input.close();
    }
    catch (IOException e) {
      System.err.println("erreur fichier" + e.toString());
    }
  }
}