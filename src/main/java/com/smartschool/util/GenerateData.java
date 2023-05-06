package com.smartschool.util;
import com.github.javafaker.*;
import com.smartschool.pojo.*;
import com.smartschool.pojo.Module;

public class GenerateData {

    public static Account generateAccount(){
        Faker faker = new Faker();
        Account account = new Account();

        account.setUsername(faker.name().username());
        account.setEmail(faker.internet().emailAddress());
        account.setPassword(faker.internet().password());
        account.setActive(true);
        Role r = new Role();
        r.setName("ROLE_STUDENT");
        account.setRole(r);
        return account;
    }

    //Generates user with 1 account associated
    public static User generateUser(){
        Faker faker = new Faker();
        Account account = generateAccount();

        User user = new User();
        user.setFname(faker.name().firstName());
        user.setLname(faker.name().lastName());
        user.setImage(faker.internet().image());
        user.setPhone(faker.phoneNumber().phoneNumber());
        user.addAccount(account);

        return user;
    }

    public static Teacher generateTeacher(){
        Faker faker = new Faker();
        Teacher teacher = new Teacher();

        teacher.setFname(faker.name().firstName());
        teacher.setLname(faker.name().lastName());
        teacher.setImage(faker.internet().image());
        teacher.setPhone(faker.phoneNumber().phoneNumber());

        return teacher;
    }

    public static Student generateStudent(){
        Faker faker = new Faker();
        Student student = new Student();

        student.setFname(faker.name().firstName());
        student.setLname(faker.name().lastName());
        student.setImage(faker.internet().image());
        student.setPhone(faker.phoneNumber().phoneNumber());

        return student;
    }

    public static Subject generateSubject(){
        Faker faker = new Faker();
        Subject subject = new Subject();

        subject.setName(faker.lorem().sentence());
        subject.setCode(faker.lorem().sentence());


        return subject;
    }

    public static SessionType generateSessionType(){

        Faker faker = new Faker();
        SessionType sessionType = new SessionType();

        sessionType.setName(faker.lorem().sentence());
        sessionType.setDescription(faker.lorem().sentence());

        return sessionType;
    }

    public static Absence generateAbsence(){
        Faker faker = new Faker();
        Absence absence = new Absence();
        absence.setReason(faker.lorem().sentence());
        absence.setDate(faker.date().birthday().toString());
        absence.setTime(faker.date().birthday().toString());
        absence.setStatus("Pending");
        absence.setSessionType(generateSessionType());
        absence.setSubject(generateSubject());
        return absence;
    }

    public static AbsenceJustification generateAbsenceJustification(){
        Faker faker = new Faker();
        AbsenceJustification absenceJustification = new AbsenceJustification();
        absenceJustification.setJustification(faker.lorem().sentence());
        absenceJustification.setAbsence(generateAbsence());
        absenceJustification.setUrl(faker.internet().url());
        return absenceJustification;
    }

    public static Branch generateBranch(){
        Branch branch = new Branch();
        branch.setName("Génie Informatique");
        branch.setCode("GI2");
        return branch;
    }

    public static Subscription generateSubscription(){
        Subscription subscription = new Subscription();
        subscription.setName("S1");
        subscription.setCode("S1");
        subscription.setLevel(generateLevel());

        return subscription;
    }

    public static Level generateLevel(){
        Level level = new Level();
        level.setName("L1");
        level.setCode("L1");
        level.setBranch(generateBranch());
        return level;
    }

    public static Module generateModule(){
        Module module = new Module();
        module.setName("Module 1");
        module.setCode("M1");
        return module;
    }

}
