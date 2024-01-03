package org.enricogiurin.ocp17.book.ch11;

import java.util.Properties;

public class UsageOfProperties {

  public static void main(String[] args) {
    new UsageOfProperties().readProperties();
  }

  void readProperties() {
    Properties properties = buildProperties();
    Object o = properties.getProperty("azure-1");
    System.out.println(o);
    o = properties.getProperty("azure-10", "not existing");
    System.out.println(o);

    o = properties.get("azure-10");  //null
    System.out.println(o);
  }

  Properties buildProperties() {
    Properties properties = new Properties();
    properties.put("azure-1", "AZ-900");
    properties.put("azure-2", "AZ-204");
    properties.put("azure-3", "AZ-104");
    properties.put("java-17", "1Z0-829");
    return properties;
  }

}
