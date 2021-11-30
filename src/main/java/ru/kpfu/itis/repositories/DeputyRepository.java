package ru.kpfu.itis.repositories;

import ru.kpfu.itis.form.VoteForm;
import ru.kpfu.itis.models.Deputy;

import java.util.List;
import java.util.Optional;

public interface DeputyRepository extends CrudRepository<Deputy> {
    Optional<Deputy> findByName(String first_name);
    List<Deputy> getVoteDeputy(VoteForm voteForm);


}
