package com.smartschool.service;

import com.smartschool.pojo.Subscription;
import com.smartschool.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionRepository subscriptionRepository;


    public void save(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    public void delete(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

    public Subscription findById(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    public Iterable<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Iterable<Subscription> findAllById(Iterable<Long> ids) {
        return subscriptionRepository.findAllById(ids);
    }

    public long count() {
        return subscriptionRepository.count();
    }

    public boolean existsById(Long id) {
        return subscriptionRepository.existsById(id);
    }

    public void deleteById(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public void deleteAll() {
        subscriptionRepository.deleteAll();
    }

    public void deleteAll(Iterable<Subscription> subscriptions) {
        subscriptionRepository.deleteAll(subscriptions);
    }

    public Iterable<Subscription> saveAll(Iterable<Subscription> subscriptions) {
        return subscriptionRepository.saveAll(subscriptions);
    }



    

}
