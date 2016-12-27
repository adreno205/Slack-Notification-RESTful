package ecorp.repository;

import ecorp.repository.entity.Show;
import ecorp.repository.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {

    public List<Show> findByTheatreNo(int theatreNo);

}
