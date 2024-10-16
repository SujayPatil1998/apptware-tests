package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.Repository.dataRepository;
import com.apptware.interview.stream.Service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SServiceImpl implements SService {


    @Autowired
    private dataRepository dataRepository;

    @Override
    public List<String> getAllData() {
        return this.dataRepository.randomData();
    }
}
