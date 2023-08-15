package org.enricogiurin.ocp17.ch7.record;

public class InvalidRecords {

}

//records cannot include instance variables not listed in the declaration of the record,
// as it could break immutability.
record Music() {
  //instance field is not allowed in record
  // final int score = 10;
}


record Song(String lyrics) {

  //Cannot assign a value to final variable 'lyrics'
  Song {
    // this.lyrics = lyrics + "Hello World";
  } }


record March() {
  //attempting to assign weaker access privileges ('package-private'); was 'public'
  //@Override String toString() { return null; }
}
