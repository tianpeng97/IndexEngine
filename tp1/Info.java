class Info {
  private String word;
  private int freq;

  public Info(String word, int freq) {
    this.word = word;
    this.freq = freq;
  }

  public String getWord() {
    return this.word;
  }

  public int getFreq() {
    return this.freq;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public void setFreq(int freq) {
    this.freq = freq;
  }

  public void increaseFreq() {
    this.freq++;
  }
}