package ma.ensam.examen.web;
import ma.ensam.examen.dao.enteties.Action;
import ma.ensam.examen.dao.enteties.Organisateur;
import ma.ensam.examen.dao.repositories.OrganisateurRepository;
import ma.ensam.examen.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ActionController {
    @Autowired
    public IActionService actionService;
    @Autowired
    public OrganisateurRepository organisateurRepository;

    @GetMapping("/actions")
    public String listAction(Model model) {
        model.addAttribute("actions", actionService.getAllActions());
        return "actions";
    }

    @GetMapping("/ActionForm")
    public String ActionForm() {
        return "ajouterAction";
    }

    @GetMapping("/addAction")
    public String addAction(Model model,
                            @RequestParam(name = "id", defaultValue = "") Long id,
                            @RequestParam(name = "description") String description,
                            @RequestParam(name = "date_creation") Date date_creation,
                            @RequestParam(name = "double") double montant,
                            @RequestParam(name = "id_organisateur") Long id_organisateur) {
        Organisateur org = organisateurRepository.findById(id_organisateur).get();
        Action action = new Action();
        action.setDescription(description);
        action.setDate_creation(date_creation);
        action.setMontant(montant);
        action.setOrganisateur(org);
        if(actionService.addAction(action)!=null)
        {
            return "redirect:/actions";
        }
        return "error";
    }
    @GetMapping("/conferencesBySpeaker")
    public String donsByAction(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("dons", actionService.getDonsByAction(actionService.getActionById(id)));
        return "listeDons";
    }

}
