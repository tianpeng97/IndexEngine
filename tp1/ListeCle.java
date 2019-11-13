//Tian Peng
//Michel Nguyen

class ListeCle {
  private Cle head;
  private static int listeCleCounter;

  public ListeCle() {
    head = new Cle(null);
    listeCleCounter = 0;
  }

  //determines the sorted index the object should have in the LinkedList
  public int indexPos(String data) {
    int position = 0;
    if (this.head != null) {
      Cle listCleCurrent = this.head.getNextCle();
      while (listCleCurrent != null
      && data.compareTo(listCleCurrent.getData()) > 0) {
        position++;
        listCleCurrent = listCleCurrent.getNextCle();
      }
    }
    return position;
  }

  //inserer data dans le LinkedList lexicographiquement
  //For intent of purposes, l'ordre est donc 0-9A-Za-z
  public void inserer(String data) {
    Cle listeCleTemp = new Cle(data);
    Cle listeCleCurrent = head;

    //si l'objet LinkedList n'a pas ete construit
    if (listeCleCurrent != null) {
      //n'execute pas si ne contient qu'un noeud
      if (listeCleCurrent.getNextCle() != null) {
        //listeCleCurrent at i is the node before indexPos
        //used for inserting nodes
        for (int i = 0; i < this.indexPos(data); i++) {
          listeCleCurrent = listeCleCurrent.getNextCle();
        }
      }
    }

    //if first element, set temp as the pointer of head
    //if not, insert nodes at indexPos
    listeCleTemp.setNextCle(listeCleCurrent.getNextCle());
    listeCleCurrent.setNextCle(listeCleTemp);

    //compte des nombres d'elements dans la liste
    plusCounter();
  }

  public static int getListeCleCounter() {
    return listeCleCounter;
  }

  public static void plusCounter() {
    listeCleCounter++;
  }

  public static void minusCounter() {
    listeCleCounter--;
  }

  public int size() {
    return getListeCleCounter();
  }

  //la representation textuelle des LinkedList built-in
  //dans Java est fait en array. Mais ATTENTION, ce ne
  //sont PAS des arrays, Java ne fait que cacher leur
  //implementation interne!
  @Override
  public String toString() {
    String result = "[";

    if (head != null) {
      Cle listeCleCurrent = head.getNextCle();
      while (listeCleCurrent != null) {
        if (listeCleCurrent.getNextCle() == null) {
          result += listeCleCurrent.getData();
          listeCleCurrent = listeCleCurrent.getNextCle();
        } else {
          result += listeCleCurrent.getData() + ", ";
          listeCleCurrent = listeCleCurrent.getNextCle();
        }
      }
    }
    return result + "]";
  }

  //Testing...
  public static void main(String[] args) {
    ListeCle list = new ListeCle();
    int i = list.indexPos("7");
    System.out.println(i);

    list.inserer("2");
    list.inserer("0");
    list.inserer("7");
    list.inserer("4");
    list.inserer("6");

    // [0,2,4,6,7] should come out sorted
    System.out.println(list);
  }
}