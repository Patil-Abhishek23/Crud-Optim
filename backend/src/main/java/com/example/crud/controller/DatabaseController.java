package com.example.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crud.service.DatabaseService;

import java.util.List;

@RestController
@RequestMapping("/database")
// @CrossOrigin(origins = "http://localhost:5173")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/tables")
    public List<String> getTableNames() {
        return databaseService.getTableNames();
    }
}