package com.smartschool.service;

import com.smartschool.pojo.EventLogging;
import com.smartschool.repository.EventLoggingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Service
public class EventLoggingService {

        @Autowired
        private EventLoggingRepository eventLoggingRepository;

        public void save(EventLogging eventLogging) {
            eventLoggingRepository.save(eventLogging);
        }

        public void delete(EventLogging eventLogging) {
            eventLoggingRepository.delete(eventLogging);
        }

        public EventLogging getEventLoggingById(Long id) {
            return eventLoggingRepository.getOne(id);
        }

        public Iterable<EventLogging> getAllEventLoggings() {
            return eventLoggingRepository.findAll();
        }

        public boolean exists(Long id) {
            return eventLoggingRepository.existsById(id);
        }

        public long count() {
            return eventLoggingRepository.count();
        }

        public void deleteAll() {
            eventLoggingRepository.deleteAll();
        }

        public void deleteById(Long id) {
            eventLoggingRepository.deleteById(id);
        }

        public Iterable<EventLogging> saveAll(Iterable<EventLogging> iterable) {
            return eventLoggingRepository.saveAll(iterable);
        }

        public Iterable<EventLogging> findAllById(Iterable<Long> iterable) {
            return eventLoggingRepository.findAllById(iterable);
        }


}
