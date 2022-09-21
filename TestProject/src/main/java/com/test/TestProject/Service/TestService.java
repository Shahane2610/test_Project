package com.test.TestProject.Service;

import com.test.TestProject.Dto.TestDto;
import com.test.TestProject.Entity.TestEntity;

import java.util.List;

public interface TestService {


    TestDto addDetail(TestEntity entity);

    Object getall();

    Object getDetailById(long id);

    TestDto updateDetail(long id, TestEntity entity);

    TestDto deleteDetail(long id);
}
