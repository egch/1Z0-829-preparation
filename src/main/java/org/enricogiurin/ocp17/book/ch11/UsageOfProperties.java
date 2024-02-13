package org.enricogiurin.ocp17.book.ch11;

import java.time.LocalDate;
import java.util.Properties;

public class UsageOfProperties {

  public static void main(String[] args) {
    new UsageOfProperties().readProperties();
  }

  void readProperties() {
    Properties properties = buildProperties();
    String value = properties.getProperty("azure-1");
    System.out.println(value);
    value = properties.getProperty("azure-10", "not existing");
    System.out.println(value);

    value = properties.getProperty("azure-10");  //null
    System.out.println(value);

    //I need to cast
    LocalDate date = (LocalDate) properties.get("today");
    System.out.println(date); //2024-02-13

  }

  Properties buildProperties() {
    Properties properties = new Properties();
    //put: Object/Object
    properties.put("azure-1", "AZ-900");
    properties.put("azure-2", "AZ-204");
    properties.put("azure-3", "AZ-104");
    //setProperty: String/String
    properties.setProperty("java-17", "1Z0-829");
    properties.put("today", LocalDate.now());
    return properties;
  }

}
