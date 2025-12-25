package ma.ensam.examen.web;

import ma.ensam.examen.dao.enteties.Don;
import ma.ensam.examen.service.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DonController {
    @Autowired
    public DonService donService;

    @GetMapping("/")
    public String listDons(Model model,
                               @RequestParam(name = "page", defaultValue = "0" ) int page,
                               @RequestParam(name = "taille", defaultValue = "5" ) int taille) {
        Page<Don> dons = donService.getAllDons(page,taille);
        model.addAttribute("listDons", dons);
        model.addAttribute("totalDons",donService.getTotalMoney());
        model.addAttribute("currentPage", page);
        int[] pages = new int[dons.getTotalPages()];
        model.addAttribute("pages", pages);
        return "dons";
    }
}