package com.smartschool.controller;

import com.smartschool.pojo.Student;
import com.smartschool.pojo.User;
import com.smartschool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String overview(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "studentOverview";
    }

    @GetMapping("/addStudent")
    public String addStudentPage(){
        return "addStudent";
    }


    //La recherche par nom ou cne
    @PostMapping("/search")
    public String searchStudent(@RequestParam("param") String param, @RequestParam("valeur") String valeur, Model model){
        if (param.equals("cne")){
            Student student = studentService.findByCne(valeur);
            if (student == null){
                model.addAttribute("error", "Student not found");
                return "studentOverview";
            }
            model.addAttribute("student", student);
        } else if (param.equals("name")) {
            Student student = studentService.findByName(valeur);
            if (student == null){
                model.addAttribute("error", "Student not found");
                return "studentOverview";
            }
            model.addAttribute("student", student);
        }
        return "studentOverview";
    }



    //Export to csv
    @GetMapping("/users/export")
    public void exportToCSV(HttpServletResponse response) throws Exception {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        ArrayList<Student> listUsers = (ArrayList<Student>) studentService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"User ID", "E-mail", "Full Name", "Roles", "Enabled"};
        String[] nameMapping = {"id", "email", "fullName", "roles", "enabled"};

        csvWriter.writeHeader(csvHeader);

        for (User user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
        csvWriter.close();
    }
}
