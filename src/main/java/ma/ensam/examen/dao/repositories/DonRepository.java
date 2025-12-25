package ma.ensam.examen.dao.repositories;

import ma.ensam.examen.dao.enteties.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonRepository extends JpaRepository<Don,Long> {
}