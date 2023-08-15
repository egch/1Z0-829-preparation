package org.enricogiurin.ocp11.practice.ch3;

public class Chicken {

  private Integer eggs = 2;

  //Non-Static Blocks
  {
    this.eggs = 3;
  }

  public Chicken(Integer eggs) {
    this.eggs = eggs;
  }
}
