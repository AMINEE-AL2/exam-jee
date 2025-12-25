package ma.ensam.examen.service;

import ma.ensam.examen.dao.enteties.Action;
import ma.ensam.examen.dao.enteties.Don;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DonService {
    Don addDon(Don don);
    Page<Don> getAllDons(int page, int size);
    Don getDonById(Long id);
    boolean deleteDon(Don don);
    double getTotalMoney();
}