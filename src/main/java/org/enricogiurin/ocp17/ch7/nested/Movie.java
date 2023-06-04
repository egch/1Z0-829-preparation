package org.enricogiurin.ocp17.ch7.nested;

public class Movie {
    private int butter = 5;

    private Movie() {
    }

    protected class Popcorn {
        private Popcorn() {
        }

        public static int butter = 10;

        public void startMovie() {
            System.out.println(butter);
        }
    }

    public static void main(String[] args) {
        Movie.Popcorn in = new Movie().new Popcorn();
        in.startMovie();  //10
    }
}
