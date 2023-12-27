package org.enricogiurin.ocp17.book.ch4.array;

public class MultiDimensionalArray {

  void tricky() {
    int[][][] array3D = new int[2][2][2];
    //a3d is 3D array, a2D is 2D array
    int[][] a3D[], a2D;
    a3D = new int[2][2][2];  //3D array
    a2D = new int[3][3];  //2D array
  }

  void weird() {
    int[][] weird = new int[2][2];
    int[] weirder[] = new int[2][2];
    //so ugly!
    int[] ugly[][] = new int[2][2][4];
  }

}
