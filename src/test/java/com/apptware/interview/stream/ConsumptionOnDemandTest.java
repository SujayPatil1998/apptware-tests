package com.apptware.interview.stream;

import static com.apptware.interview.stream.PaginationService.FULL_DATA_SIZE;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ConsumptionOnDemandTest {

  @Autowired private DataReader dataReader;

  @Test
  void testConsumptionOnDemand() {
    int limit = 2; // Define a small limit for testing purposes

    // Test limited data fetching as Stream<String>
    try (Stream<String> limitedDataStream = dataReader.fetchLimitadData(limit)) {
      List<String> limitedData = limitedDataStream.collect(Collectors.toList());
      Assertions.assertThat(limitedData).hasSize(limit);
    }

    // Test full data fetching as Stream<String>
    try (Stream<String> fullDataStream = dataReader.fetchFullData()) {
      List<String> fullData = fullDataStream.collect(Collectors.toList());
      Assertions.assertThat(fullData).hasSizeGreaterThanOrEqualTo(limit);
    }
  }
}
