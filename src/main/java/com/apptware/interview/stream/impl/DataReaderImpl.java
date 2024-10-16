package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.DataReader;
import com.apptware.interview.stream.PaginationService;

import java.util.List;
import java.util.stream.Stream;
import com.apptware.interview.stream.Service.SService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class DataReaderImpl implements DataReader {

  @Autowired
  private SService sService;

  @Autowired
  private PaginationService paginationService;

  @Override
  public Stream<String> fetchLimitadData(int limit) {
    return fetchPaginatedDataAsStream().limit(limit); // No collecting, returns Stream<String>
  }

  @Override
  public Stream<String> fetchFullData() {
    return fetchPaginatedDataAsStream();
  }

  /**
   * This method is where the candidate should add the implementation.
   * Logs have been added to track the data fetching behavior.
   */
  private Stream<String> fetchPaginatedDataAsStream() {
      log.info("Fetching paginated data as stream.");

      // Example data stream; replace with actual fetching logic


      List<String> ls = this.sService.getAllData();
      Stream<String> dataStream = ls.stream();
      return dataStream.peek(item -> log.info("Fetched Item: {}", item));

  }
}
