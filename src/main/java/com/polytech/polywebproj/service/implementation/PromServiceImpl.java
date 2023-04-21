package com.polytech.polywebproj.service.implementation;

import com.polytech.polywebproj.model.Prom;
import com.polytech.polywebproj.repository.PromRepository;
import com.polytech.polywebproj.service.PromService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromServiceImpl implements PromService {

    private final PromRepository promRepository;

    public PromServiceImpl(PromRepository promRepository) {
        this.promRepository = promRepository;
    }

    @Override
    public Prom createProm(Prom prom) {
        return promRepository.save(prom);
    }

    @Override
    public List<Prom> getProms() {
        return promRepository.findAll();
    }

    @Override
    public Optional<Prom> getPromById(Long id) {
        return promRepository.findById(id);
    }

    @Override
    public Prom modifyProm(Long id, Prom prom) {
        return promRepository.findById(id)
                .map(p-> {
                    p.setPromName(prom.getPromName());
                    return promRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Prom not found"));
    }

    @Override
    public String deleteProm(Long id) {
        promRepository.deleteById(id);
        return "Prom deleted";
    }
}
