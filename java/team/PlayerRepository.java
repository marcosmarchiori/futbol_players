package team;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import team.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

	 Player findByLastName(@Param("lastName") String lastName);

	  Club findById(int id);
}
