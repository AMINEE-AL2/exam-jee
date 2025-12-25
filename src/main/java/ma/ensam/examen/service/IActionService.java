package ma.ensam.examen.service;

import ma.ensam.examen.dao.enteties.Action;
import ma.ensam.examen.dao.enteties.Don;

import java.util.List;

public interface IActionService {
    Action addAction(Action action);
    List<Don> getDonsByAction(Action action);
    List<Action> getAllActions();
    Action getActionById(Long id);
}