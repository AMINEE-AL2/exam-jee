package ma.ensam.examen.service;

import ma.ensam.examen.dao.enteties.Action;
import ma.ensam.examen.dao.enteties.Don;
import ma.ensam.examen.dao.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IactionServiceImpl implements IActionService{
    @Autowired
    public ActionRepository actionRepository;

    @Override
    public Action addAction(Action action) {
        if(action!=null) actionRepository.save(action);
        return null;
    }

    @Override
    public List<Don> getDonsByAction(Action action) {
        return action.getDons();
    }

    @Override
    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    @Override
    public Action getActionById(Long id) {
        return actionRepository.findById(id).get();
    }
}
