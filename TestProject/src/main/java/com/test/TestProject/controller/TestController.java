package com.test.TestProject.controller;

import com.test.TestProject.Entity.TestEntity;
import com.test.TestProject.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestService service;


    @PostMapping("/addDetail")
    public Object addDetail(@RequestBody TestEntity entity) {
        return service.addDetail(entity);
    }

    //  List all employees
    @GetMapping("/getAllDetail")
    public Object getAll() {
        return service.getall();

    }

    // Get employees by it's id
    @GetMapping("/getDetailById/{id}")
    public Object getDetailById(@PathVariable long id){
        return  service.getDetailById(id);
    }


    // Update/Edit selected employee details
    @PutMapping("/updateDetail/{id}")
    public Object updateDetail(@PathVariable long id, @RequestBody TestEntity entity) {
        return service.updateDetail(id,entity);
    }

    // Remove selected employee record
    @DeleteMapping("/deleteDetail/{id}")
    public Object deleteDetail(@PathVariable long id) {
        return service.deleteDetail(id);
    }

}











//    @PostMapping("/addDetail")
//    public TestEntity addDetail(@RequestBody TestEntity detail) {
//        return service.saveDetail(detail);
//    }
//
//    @PostMapping("/addDetails")
//    public List<TestEntity> addDetails(@RequestBody List<TestEntity> details) {
//        return service.saveDetails(details);
//    }
//
//
//    @GetMapping("/Details")
//    public List<TestEntity> findAllProducts() {
//        return service.getDetails();
//    }
//
//    @GetMapping("/detailById/{id}")
//    public TestEntity findProductById(@PathVariable int id) {
//        return service.getDetailById(id);
//    }
//
//    @GetMapping("/detail/{name}")
//    public TestEntity findProductByName(@PathVariable String name) {
//        return service.getDetailByName(name);
//    }
//
//    @PutMapping("/update")
//    public TestEntity updateProduct(@RequestBody TestEntity detail) {
//        return service.updateDetail(detail);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteDetail(@PathVariable int id) {
//        return service.deleteDetail(id);
//    }



