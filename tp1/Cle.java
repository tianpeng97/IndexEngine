class Cle {
  private String data;
  private Cle nextCle;
  private ListeValeur nextListeValeur;

  public Cle(String data) {
    this.data = data;
    nextCle = null;
    nextListeValeur = null;
  }

  public Cle(String data, Cle nextCle) {
    this.data = data;
    this.nextCle = nextCle;
    nextListeValeur = null;
  }

  public Cle(String data, Cle nextCle, ListeValeur nextListeValeur) {
    this.data = data;
    this.nextCle = nextCle;
    this.nextListeValeur = nextListeValeur;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Cle getNextCle() {
    return nextCle;
  }

  public void setNextCle(Cle nextCle) {
    this.nextCle = nextCle;
  }

  public ListeValeur getNextListeValeur() {
    return nextListeValeur;
  }

  public void setNextListeValeur(ListeValeur nextListeValeur) {
    this.nextListeValeur = nextListeValeur;
  }
}