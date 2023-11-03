package org.enricogiurin.ocp17.book.ch9;

import java.util.Set;
import java.util.TreeSet;

public class UseOfComparable {

  public static void main(String[] args) {
    new UseOfComparable().sort();
  }
  void sort() {
    HumanBiometrics p1 = new HumanBiometrics(100, 180);
    HumanBiometrics p2 = new HumanBiometrics(90, 170);
    HumanBiometrics p3 = new HumanBiometrics(75, 190);
    HumanBiometrics p4 = new HumanBiometrics(105, 180);
    TreeSet<HumanBiometrics> people = new TreeSet<>(Set.of(p1, p2, p3, p4));
    people.forEach(System.out::println);
  }
}

record HumanBiometrics(int weight, int height) implements Comparable<HumanBiometrics> {

    private double calculateBMI() {
      // Calculate BMI using the formula: BMI = weight (kg) / (height^2) (m^2)
      return (double) weight / (height * height);
    }

  /**
   * We order the human beings based on the BMI index.
   */
  @Override
    public int compareTo(HumanBiometrics other) {
      // Compare based on BMI values
      double thisBMI = this.calculateBMI();
      double otherBMI = other.calculateBMI();
      return Double.compare(thisBMI, otherBMI);
    }
}
