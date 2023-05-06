package com.smartschool;

import com.smartschool.pojo.*;
import com.smartschool.pojo.Module;
import com.smartschool.repository.*;
import com.smartschool.util.GenerateData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SmartschoolApplication {

	public static void main(String[] args) {

		//SpringApplication.run(SmartschoolApplication.class, args);
		//Generate data and save to database
		ApplicationContext context = SpringApplication.run(SmartschoolApplication.class, args);
		//generate user
		Teacher t = GenerateData.generateTeacher();
		UserRepository userRepository = context.getBean(UserRepository.class);
		userRepository.save(t);
		User u = GenerateData.generateUser();
		userRepository.save(u);
		Student s = GenerateData.generateStudent();
		userRepository.save(s);
		Level l = GenerateData.generateLevel();
		LevelRepository levelRepository = context.getBean(LevelRepository.class);
		levelRepository.save(l);
		Module m = GenerateData.generateModule();
		ModuleRepository moduleRepository = context.getBean(ModuleRepository.class);
		moduleRepository.save(m);
		Subject subject = GenerateData.generateSubject();
		SubjectRepository subjectRepository = context.getBean(SubjectRepository.class);
		subjectRepository.save(subject);
		SessionType sessionType = GenerateData.generateSessionType();
		SessionTypeRepository sessionTypeRepository = context.getBean(SessionTypeRepository.class);
		sessionTypeRepository.save(sessionType);
		Absence absence = GenerateData.generateAbsence();
		AbsenceRepository absenceRepository = context.getBean(AbsenceRepository.class);
		absenceRepository.save(absence);
		AbsenceJustification absenceJustification = GenerateData.generateAbsenceJustification();
		AbsenceJustificationRepository absenceJustificationRepository = context.getBean(AbsenceJustificationRepository.class);
		absenceJustificationRepository.save(absenceJustification);
		Account account = GenerateData.generateAccount();
		AccountRepository accountRepository = context.getBean(AccountRepository.class);
		accountRepository.save(account);




	}



}
