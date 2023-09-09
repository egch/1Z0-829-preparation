package org.enricogiurin.ocp17.ch7.useofenum;

import java.math.BigDecimal;

public enum EnumImplementsInterface implements Wealth {
  //list of values come first
  RICH, POOR, NORMAL;

  @Override
  public BigDecimal getNetWealth() {
    return null;
  }
}

interface Wealth {

  BigDecimal getNetWealth();
}
