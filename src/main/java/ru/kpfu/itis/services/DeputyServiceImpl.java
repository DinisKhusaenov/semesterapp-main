package ru.kpfu.itis.services;

import ru.kpfu.itis.form.VoteForm;
import ru.kpfu.itis.models.Deputy;
import ru.kpfu.itis.repositories.DeputyRepository;

import java.util.List;
import java.util.Optional;

public class DeputyServiceImpl implements DeputyService {

    private final DeputyRepository deputyRepository;

    public DeputyServiceImpl(DeputyRepository deputyRepository) {
        this.deputyRepository = deputyRepository;
    }

    @Override
    public void save(Deputy entity) {
        deputyRepository.save(entity);
    }

    @Override
    public void delete(Deputy entity) {
        deputyRepository.delete(entity);
    }

    @Override
    public void update(Deputy entity) {
        deputyRepository.update(entity);
    }

    @Override
    public Optional<Deputy> findById(Long id) {
        return deputyRepository.findById(id);
    }

    @Override
    public Optional<Deputy> findByFirst_Name(String first_name) {
        return Optional.empty();
    }

    @Override
    public List<Deputy> getAllDeputy() {
        return deputyRepository.findAll();
    }

    @Override
    public List<Deputy> getVoteDeputy(VoteForm voteForm) {
        return deputyRepository.getVoteDeputy(voteForm);
    }
}
