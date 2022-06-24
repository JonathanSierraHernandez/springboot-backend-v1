package com.backend.controller;

import com.backend.model.Inout;
import com.backend.model.Usr;
import com.backend.repository.InoutRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InoutController {

    // standard constructors

    @Autowired
    private InoutRepository inOutRepository;

    @GetMapping("/inout")
    public List<Inout> getInOut() { return (List<Inout>) inOutRepository.findAll(); }

    @PostMapping(value="/inout")
    public void addInOut(@RequestBody Inout inout) { inOutRepository.save(inout); }

    @DeleteMapping("/inout/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        inOutRepository.deleteById(id);
    }
}