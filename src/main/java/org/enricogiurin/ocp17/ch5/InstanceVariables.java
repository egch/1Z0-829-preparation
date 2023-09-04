package org.enricogiurin.ocp17.ch5;

public class InstanceVariables {
  private int x;
  final int y;
  public transient  int z;
  protected volatile  String name;


  public InstanceVariables(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
