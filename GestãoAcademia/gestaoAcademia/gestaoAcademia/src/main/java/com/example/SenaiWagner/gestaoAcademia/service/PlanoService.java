package com.example.SenaiWagner.gestaoAcademia.service;

import com.example.SenaiWagner.gestaoAcademia.dto.PlanoDTO;
import com.example.SenaiWagner.gestaoAcademia.entity.Plano;
import com.example.SenaiWagner.gestaoAcademia.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano findById(Long id) {
        return planoRepository.findById(id).orElseThrow();
    }

    public List<Plano> findAll() {
        return planoRepository.findAll();
    }

    public Plano save(Plano plano) {
        return planoRepository.save(plano);
    }

    public Plano update(Long id, Plano dados) {
        Plano plano = findById(id);
        plano.setNome(dados.getNome());
        plano.setValorMensal(dados.getValorMensal());
        return planoRepository.save(plano);
    }

    public void delete(Long id) {
        planoRepository.deleteById(id);
    }

    public PlanoDTO toDTO(Plano plano) {
        return new PlanoDTO(plano.getId(), plano.getNome(), plano.getValorMensal());
    }
}
