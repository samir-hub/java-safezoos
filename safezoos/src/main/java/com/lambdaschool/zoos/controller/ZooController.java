package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    // GET: localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    // GET: localhost:2019/zoos/zoos/2
    @GetMapping(value = "/zoos/{zooid}",
                produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable long zooid)
    {
        Zoo myZoo = zooService.findZooById(zooid);
        return new ResponseEntity<>(myZoo, HttpStatus.OK);
    }

    // GET: localhost:2019/zoos/Zoo Name
    @GetMapping(value = "/{name}",
                produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable String name)
    {
        Zoo myZoo = zooService.findZooByName(name);
        return new ResponseEntity<>(myZoo, HttpStatus.OK);
    }
}
