class ListeValeur {
  private Valeur head;
  private static int valeurCounter;

  public ListeValeur() {
    head = new Valeur(null);
    valeurCounter = 0;
  }

  //determines the sorted index the object should have in the LinkedList
  public int indexPos(String data) {
    int position = 0;
    if (this.head != null) {
      Valeur valeurCurrent = this.head.getNextValeur();
      while (valeurCurrent != null
      && data.compareTo(valeurCurrent.getDataWord()) >= 0) {
        if (data.compareTo(valeurCurrent.getDataWord()) > 0) {
          position++;
          valeurCurrent = valeurCurrent.getNextValeur();
        } else {
          return position;
        }
      }
    }
    return position;
  }

  //is it in list?
  public boolean isDataInList(String data) {
    if (this.head != null) {
      Valeur valeurCurrent = this.head.getNextValeur();
      while (valeurCurrent != null) {
        if (data.compareTo(valeurCurrent.getDataWord()) == 0) {
          return true;
        }
        valeurCurrent = valeurCurrent.getNextValeur();
      }
    }
    return false;
  }

  //inserer data dans le LinkedList lexicographiquement
  //For intent of purposes, l'ordre est donc 0-9A-Za-z
  public void inserer(String valeur, int freq) {
    Valeur valeurTemp = new Valeur(new Info(valeur, freq));
    Valeur valeurCurrent = this.head;

    if (this.isDataInList(valeur)) {
      this.get(this.indexPos(valeur)).increaseFreq();
    } else {
      //n'execute pas si ne contient qu'un noeud
      if (valeurCurrent.getNextValeur() != null) {
        for (int i = 0; i < this.indexPos(valeur); i++) {
          valeurCurrent = valeurCurrent.getNextValeur();
        }
      }
      //if first element, set temp as the pointer of head
      //if not, insert nodes at indexPos
      valeurTemp.setNextValeur(valeurCurrent.getNextValeur());
      valeurCurrent.setNextValeur(valeurTemp);
      //compte des nombres d'elements dans la liste
      plusCounter();
    }
  }

  private boolean isElementIndex(int index) {
    return index >= 0 && index < this.size();
  }

  private String outOfBoundsMsg(int index) {
    return "Index: "+index+", Size: "+this.size();
  }

  private void checkElementIndex(int index) {
    if (!isElementIndex(index))
      throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  }

  public Valeur valeur(int index) {
    Valeur valeurCurrent = this.head;
    if (valeurCurrent != null) {
      valeurCurrent = this.head.getNextValeur();
      for (int i = 0; i < index; i++) {
        valeurCurrent = valeurCurrent.getNextValeur();
      }
    }
    return valeurCurrent;
  }

  public Info get(int index) {
    checkElementIndex(index);
    return valeur(index).getInfo();
  }

  public static void plusCounter() {
    valeurCounter++;
  }

  public int size() {
    return valeurCounter;
  }

  //la representation textuelle des LinkedList built-in
  //dans Java est fait en array. Mais ATTENTION, ce ne
  //sont PAS des arrays, Java ne fait que cacher leur
  //implementation interne!
  @Override
  public String toString() {
    String result = "[";

    if (head != null) {
      Valeur valeurCurrent = head.getNextValeur();
      while (valeurCurrent != null) {
        if (valeurCurrent.getNextValeur() == null) {
          result += valeurCurrent.getDataWord()
          + " " + valeurCurrent.getDataFreq();
          valeurCurrent = valeurCurrent.getNextValeur();
        } else {
          result += valeurCurrent.getDataWord()
          + " " + valeurCurrent.getDataFreq() + ", ";
          valeurCurrent = valeurCurrent.getNextValeur();
        }
      }
    }
    return result + "]";
  }
}