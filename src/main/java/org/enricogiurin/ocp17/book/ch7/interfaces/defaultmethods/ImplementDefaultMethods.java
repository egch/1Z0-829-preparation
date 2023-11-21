package org.enricogiurin.ocp17.book.ch7.interfaces.defaultmethods;

interface Crawl {

  abstract void wriggle();
}

interface Dance {

  public void wriggle();
}

public class ImplementDefaultMethods implements Crawl, Dance {

  @Override
  public void wriggle() {

  }
}