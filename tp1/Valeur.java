class Valeur {
  private Info data;
  private Valeur nextValeur;

  public Valeur(Info data) {
    this.data = data;
    nextValeur = null;
  }

  public Valeur(Info data, Valeur nextValeur) {
    this.data = data;
    this.nextValeur = nextValeur;
  }

  public Info getInfo() {
    return this.data;
  }

  public String getDataWord() {
    return data.getWord();
  }

  public int getDataFreq() {
    return data.getFreq();
  }

  public void setDataWord(String data) {
    this.data.setWord(data);
  }

  public void setDataFreq(int data) {
    this.data.setFreq(data);
  }

  public Valeur getNextValeur() {
    return nextValeur;
  }

  public void setNextValeur(Valeur nextValeur) {
    this.nextValeur = nextValeur;
  }
}