package com.smartschool.pojo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "absence")
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private String date;
    private String time;
    private String status;
    @ManyToOne
    @JoinColumn(name = "session_type_id", nullable = false)
    private SessionType sessionType;

    @OneToMany(mappedBy = "absence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AbsenceJustification> absenceJustifications;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public List<AbsenceJustification> getAbsenceJustifications() {
        return absenceJustifications;
    }

    public void setAbsenceJustifications(List<AbsenceJustification> absenceJustifications) {
        this.absenceJustifications = absenceJustifications;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

}

//An absence can have one sessionType, but one sessionType can have multiple absences