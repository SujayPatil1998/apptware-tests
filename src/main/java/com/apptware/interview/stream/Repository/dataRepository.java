package com.apptware.interview.stream.Repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class dataRepository {

    int numberOfStrings = 10000;
    int stringLength = 10;
    Random random = new Random();
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//created random data with the help of random function
  public List<String> randomData() {
      List<String> stringList = Stream.generate(() -> getAllData(random, characters, stringLength))
              .limit(numberOfStrings)  // Limit to 100,000 strings
              .collect(Collectors.toList());

      return stringList;

  }
    private String getAllData(Random random, String characters, int length) {
        return random.ints(length, 0, characters.length())
                .mapToObj(characters::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
