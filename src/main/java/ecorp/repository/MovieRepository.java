package ecorp.repository;

import ecorp.repository.entity.Movie;
import ecorp.repository.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select s from Movie s where s.movieId = ?1")
    Movie findOneBymovieID(int movieId);

}
