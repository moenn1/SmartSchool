package com.smartschool.service;

import com.smartschool.pojo.AbsenceJustification;
import com.smartschool.repository.AbsenceJustificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AbsenceJustificationService {
    @Autowired
    private AbsenceJustificationRepository absenceJustificationRepository;

    public AbsenceJustificationService() {
    }

    public AbsenceJustificationRepository getAbsenceJustificationRepository() {
        return absenceJustificationRepository;
    }

    public void setAbsenceJustificationRepository(AbsenceJustificationRepository absenceJustificationRepository) {
        this.absenceJustificationRepository = absenceJustificationRepository;
    }

    public void save(AbsenceJustification absenceJustification) {
        absenceJustificationRepository.save(absenceJustification);
    }

    public void delete(AbsenceJustification absenceJustification) {
        absenceJustificationRepository.delete(absenceJustification);
    }

    public AbsenceJustification getAbsenceJustificationById(Long id) {
        return absenceJustificationRepository.getOne(id);
    }

    public Iterable<AbsenceJustification> getAllAbsenceJustifications() {
        return absenceJustificationRepository.findAll();
    }

    public boolean exists(Long id) {
        return absenceJustificationRepository.existsById(id);
    }

    public long count() {
        return absenceJustificationRepository.count();
    }

    public void deleteAll() {
        absenceJustificationRepository.deleteAll();
    }

    public void deleteById(Long id) {
        absenceJustificationRepository.deleteById(id);
    }

    public Iterable<AbsenceJustification> saveAll(Iterable<AbsenceJustification> iterable) {
        return absenceJustificationRepository.saveAll(iterable);
    }

    public Iterable<AbsenceJustification> findAllById(Iterable<Long> iterable) {
        return absenceJustificationRepository.findAllById(iterable);
    }

}
