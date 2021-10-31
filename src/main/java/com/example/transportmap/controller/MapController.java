package com.example.transportmap.controller;

import com.example.transportmap.model.TransportMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
public class MapController {

    @GetMapping
    public TransportMap getMap() {
        return new TransportMap("test");
    }


}

