package com.polytech.polywebproj.controller;

import com.polytech.polywebproj.model.Prom;
import com.polytech.polywebproj.model.Speciality;
import com.polytech.polywebproj.service.PromService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polywebproj/prom")
public class PromController {
    private final PromService promService;

    public PromController(PromService promService) {
        this.promService = promService;
    }

    @PostMapping("/create")
    public Prom createProm(@RequestBody Prom prom) {
        return promService.createProm(prom);
    }

    @GetMapping
    public List<Prom> getProms() {
        return promService.getProms();
    }

    @GetMapping(value="/{id}")
    public Optional<Prom> getPromById(@PathVariable Long id) {
        return promService.getPromById(id);
    }

    @PutMapping("/update/{id}")
    public Prom modifyProm(@PathVariable Long id, @RequestBody Prom prom) {
        return promService.modifyProm(id, prom);
    }

    @DeleteMapping("/delete")
    public String deleteProm(Long id) {
        return promService.deleteProm(id);
    }
}
