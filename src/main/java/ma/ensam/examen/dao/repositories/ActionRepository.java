package ma.ensam.examen.dao.repositories;

import ma.ensam.examen.dao.enteties.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {
}
