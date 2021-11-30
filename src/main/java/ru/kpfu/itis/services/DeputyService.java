package ru.kpfu.itis.services;

import ru.kpfu.itis.form.VoteForm;
import ru.kpfu.itis.models.Deputy;

import java.util.List;
import java.util.Optional;

public interface DeputyService {
    void save(Deputy entity);
    void delete(Deputy entity);
    void update(Deputy entity);
    Optional<Deputy> findById(Long id);
    Optional<Deputy> findByFirst_Name(String first_name);
    List<Deputy> getAllDeputy();
    List<Deputy> getVoteDeputy(VoteForm voteForm);
}
