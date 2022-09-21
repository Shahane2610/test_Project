package com.test.TestProject.Service;

import com.test.TestProject.Dto.TestDto;
import com.test.TestProject.Entity.TestEntity;
import com.test.TestProject.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository repository;

    @Override
    public TestDto addDetail(TestEntity entity) {
        TestDto testDto = new TestDto();
        try {
            repository.save(entity);
            testDto.setStatus("Record inserted successfully !");
            return testDto;
        }
        catch (Exception e){
            e.printStackTrace();
            testDto.setStatus("Not inserted");

            return testDto;
        }
    }

    @Override
    public Object getall() {
        List<TestEntity> list = repository.findAll();
        TestDto testDto = new TestDto();
        if (list.isEmpty()) {
            testDto.setStatus("Empty Records . Please insert some !");
            return testDto;
        }
        return list;
    }

    @Override
    public Object getDetailById(long id) {
        TestEntity entity = repository.findById(id);
        TestDto testDto = new TestDto();
        if(entity==null){
            testDto.setStatus("No record found with this id : "+id);
            return testDto;
        }
        return entity;
    }

    @Override
    public TestDto updateDetail(long id, TestEntity entity) {
        TestEntity existingRecord = repository.findById(id);
        TestDto testDto = new TestDto();
        try{
            existingRecord.setName(entity.getName());
            existingRecord.setAge(entity.getAge());
            existingRecord.setAddress(entity.getAddress());
            testDto.setStatus("Updated SuccessFully !");
        }
        catch (Exception e){
            testDto.setStatus("Not updated successfully");
        }
        repository.save(existingRecord);
        return testDto;
    }

    @Override
    public TestDto deleteDetail(long id) {
        TestDto testDto = new TestDto();
        try{
            repository.deleteById(id);
            testDto.setStatus("Removed Successfully");
        }
        catch (Exception e){
            testDto.setStatus("Not removed");
        }
        return testDto;
    }
}



