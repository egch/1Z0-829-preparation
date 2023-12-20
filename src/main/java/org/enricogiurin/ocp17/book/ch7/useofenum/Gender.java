package org.enricogiurin.ocp17.book.ch7.useofenum;

public enum Gender {
  MALE {
    @Override
    public String description() {
      return "male";
    }
  }, FEMALE {
    @Override
    public String description() {
      return "female";
    }
  };
  public abstract String description();
}
