package com.smartschool.service;

import com.smartschool.pojo.Absence;
import com.smartschool.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;

    public AbsenceService() {
    }

    public AbsenceRepository getAbsenceRepository() {
        return absenceRepository;
    }

    public void setAbsenceRepository(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public void save(Absence absence) {
        absenceRepository.save(absence);
    }

    public void delete(Absence absence) {
        absenceRepository.delete(absence);
    }

    public Absence getAbsenceById(Long id) {
        return absenceRepository.getOne(id);
    }

    public Iterable<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    public boolean exists(Long id) {
        return absenceRepository.existsById(id);
    }

    public long count() {
        return absenceRepository.count();
    }

    public void deleteAll() {
        absenceRepository.deleteAll();
    }

    public void deleteById(Long id) {
        absenceRepository.deleteById(id);
    }

    public Iterable<Absence> saveAll(Iterable<Absence> iterable) {
        return absenceRepository.saveAll(iterable);
    }

    public Iterable<Absence> findAllById(Iterable<Long> iterable) {
        return absenceRepository.findAllById(iterable);
    }

}
