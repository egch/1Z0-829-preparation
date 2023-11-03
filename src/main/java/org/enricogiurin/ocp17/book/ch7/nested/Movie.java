package org.enricogiurin.ocp17.book.ch7.nested;

public class Movie {

  private int butter = 5;

  private Movie() {
  }

  public static void main(String[] args) {
    Movie.Popcorn in = new Movie().new Popcorn();
    in.startMovie();  //10
  }

  protected class Popcorn {

    public static int butter = 10;

    private Popcorn() {
    }

    public void startMovie() {
      System.out.println(butter);
    }
  }
}
