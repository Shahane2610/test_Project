package com.test.TestProject.Repository;

import com.test.TestProject.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity,Long> {

    TestEntity findById(long id);

}
