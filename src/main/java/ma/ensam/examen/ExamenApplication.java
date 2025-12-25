package ma.ensam.examen;

import ma.ensam.examen.dao.enteties.Action;
import ma.ensam.examen.dao.enteties.ActionStatus;
import ma.ensam.examen.dao.enteties.Don;
import ma.ensam.examen.dao.enteties.DonType;
import ma.ensam.examen.service.DonService;
import ma.ensam.examen.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ExamenApplication implements CommandLineRunner {
    @Autowired
    DonService donService;
    @Autowired
    IActionService actionService;
    @Override
    public void run(String... args) throws Exception {
        Action action1 = new Action(
                null,
                "act1",
                new Date(),
                50000.0,
                ActionStatus.PREPARATION,
                null,
                null
        );
        actionService.addAction(action1);

        Action action2 = new Action(
                null,
                "act2",
                new Date(),
                50000.0,
                ActionStatus.PREPARATION,
                null,
                null
        );
        actionService.addAction(action2);

        Action action3 = new Action(
                null,
                "act3",
                new Date(),
                50000.0,
                ActionStatus.PREPARATION,
                null,
                null
        );
        actionService.addAction(action3);

        Action action4 = new Action(
                null,
                "act4",
                new Date(),
                50000.0,
                ActionStatus.PREPARATION,
                null,
                null
        );
        actionService.addAction(action4);

        Action action5 = new Action(
                null,
                "act5",
                new Date(),
                50000.0,
                ActionStatus.PREPARATION,
                null,
                null
        );
        actionService.addAction(action5);

        Don don1 = new Don(null, "aid 1", 5000.0, DonType.ARGENT, action1);
        donService.addDon(don1);
        Don don2 = new Don(null, "aid 2", 15000.0, DonType.ARGENT, action2);
        donService.addDon(don2);
        Don don3 = new Don(null, "aid 3", 3000.0, DonType.BIEN, action3);
        donService.addDon(don3);
        Don don4 = new Don(null, "aid 4", 8000.0, DonType.ARGENT, action1);
        donService.addDon(don4);
        Don don5 = new Don(null, "aid 5", 12000.0, DonType.ARGENT, action2);
        donService.addDon(don5);
        Don don6 = new Don(null, "aid 6", 2500.0, DonType.BIEN, action4);
        donService.addDon(don6);
        Don don7 = new Don(null, "aid 7", 20000.0, DonType.ARGENT, action3);
        donService.addDon(don7);
        Don don8 = new Don(null, "aid 8", 30000.0, DonType.BIEN, action5);
        donService.addDon(don8);
        Don don9 = new Don(null, "aid 9", 25000.0, DonType.ARGENT, action3);
        donService.addDon(don9);
        Don don10 = new Don(null, "aid 10", 10000.0, DonType.ARGENT, action1);
        donService.addDon(don10);
        Don don11 = new Don(null, "aid 11", 13000.0, DonType.BIEN, action2);
        donService.addDon(don11);
        Don don12 = new Don(null, "aid 12", 16000.0, DonType.ARGENT, action5);
        donService.addDon(don12);
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamenApplication.class, args);
    }

}
