package com.polytech.polywebproj.service;

import com.polytech.polywebproj.model.Prom;
import com.polytech.polywebproj.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface PromService {

    Prom createProm(Prom prom);

    List<Prom> getProms();

    Optional<Prom> getPromById(Long id);

    Prom modifyProm(Long id, Prom prom);

    String deleteProm(Long id);
}
