package ma.ensam.examen.service;

import ma.ensam.examen.dao.enteties.Action;
import ma.ensam.examen.dao.enteties.Don;
import ma.ensam.examen.dao.repositories.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonManager implements DonService{
    @Autowired
    public DonRepository donRepository;

    @Override
    public Don addDon(Don don) {
        return donRepository.save(don);
    }

    @Override
    public Page<Don> getAllDons(int page, int size) {
        return donRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Don getDonById(Long id) {
        return donRepository.findById(id).get();
    }

    @Override
    public boolean deleteDon(Don don) {
        donRepository.delete(don);
        if(donRepository.findById(don.getId()).isPresent()) return true;
        return false;
    }

    @Override
    public double getTotalMoney() {
        List<Don> dons = donRepository.findAll();
        double total = 0;
        for(Don don : dons) total += don.getMontant();
        return total;
    }
}
