package com.smartschool.controller;

import com.smartschool.pojo.*;
import com.smartschool.pojo.Module;
import com.smartschool.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.*;
import org.supercsv.prefs.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.*;
import java.util.*;

@RequestMapping("/admin")
@Controller
public class AdminController {
    private String event = "admin";

    @Autowired
    EventLoggingService eventLoggingService;

    @Autowired
    StudentService studentService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    LevelService levelService;

    @Autowired
    BranchService branchService;

    @Autowired
    TeacherService teacherService;

    @GetMapping("/students")
    public String overview(Model model) {
        model.addAttribute("students", studentService.findAll());
        eventLoggingService.save(new EventLogging(event, "overview"));
        return "studentOverview";
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
        eventLoggingService.save(new EventLogging(event, "search"));
        return "studentOverview";
    }

    @GetMapping("/addStudent")
    public String addStudentPage(){
        eventLoggingService.save(new EventLogging(event, "addStudentPage"));
        return "addStudent";
    }

    //l'ajout d'un etudiant
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student, Model model){
        if (studentService.findByCne(student.getCne()) != null){
            model.addAttribute("error", "CNE already exists");
            return "addStudent";
        }
        eventLoggingService.save(new EventLogging(event, "addStudent"));
        studentService.save(student);
        return "studentOverview";
    }

    //Supprimer un etudiant
    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model){
        if (studentService.findById(id) == null){
            model.addAttribute("error", "Student not found");
            return "studentOverview";
        }
        studentService.deleteById(id);
        model.addAttribute("students", studentService.findAll());
        eventLoggingService.save(new EventLogging(event, "deleteStudent"));
        return "studentOverview";
    }

    //Modifier un etudiant (get)
    @GetMapping("/editStudent/{id}")
    public String editStudentPage(@PathVariable("id") Long id, Model model){
        Student student = studentService.findById(id);
        if (student == null){
            model.addAttribute("error", "Student not found");
            return "studentOverview";
        }
        model.addAttribute("student", student);
        eventLoggingService.save(new EventLogging(event, "editStudentPage"));
        return "editStudent";
    }

    //Modifier etudiant (post)
    @PostMapping("/editStudent/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model){
        if (studentService.findById(id) == null){
            model.addAttribute("error", "Student not found");
            return "studentOverview";
        }
        studentService.save(student);
        model.addAttribute("students", studentService.findAll());
        eventLoggingService.save(new EventLogging(event, "editStudent"));
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
        eventLoggingService.save(new EventLogging(event, "exportToCSV"));
    }


    @GetMapping("/elements")
    public String elementsPage(){
        eventLoggingService.save(new EventLogging(event, "elementsPage"));
        return "elements";
    }


    @GetMapping("/modules")
    public String modulesPage(){
        eventLoggingService.save(new EventLogging(event, "modulesPage"));
        return "modules";
    }

    @GetMapping("/classes")
    public String classesPage(){
        eventLoggingService.save(new EventLogging(event, "classesPage"));
        return "classes";
    }

    @GetMapping("/branches")
    public String branchesPage(){
        eventLoggingService.save(new EventLogging(event, "branchesPage"));
        return "branches";
    }

    //Crud for module

    @GetMapping("/addModule")
    public String addModulePage(){
        eventLoggingService.save(new EventLogging(event, "addModulePage"));
        return "addModule";
    }

    @PostMapping("/addModule")
    public String addModule(@ModelAttribute("module") Module module, Model model){
        if (moduleService.findByCode(module.getCode()) != null){
            model.addAttribute("error", "Code already exists");
            return "addModule";
        }
        moduleService.save(module);
        eventLoggingService.save(new EventLogging(event, "addModule"));
        return "modules";
    }

    @PostMapping("/deleteModule/{id}")
    public String deleteModule(@PathVariable("id") Long id, Model model){
        if (moduleService.findById(id) == null){
            model.addAttribute("error", "Module not found");
            return "modules";
        }
        moduleService.deleteById(id);
        model.addAttribute("modules", moduleService.findAll());
        eventLoggingService.save(new EventLogging(event, "deleteModule"));
        return "modules";
    }

    @GetMapping("/editModule/{id}")
    public String editModulePage(@PathVariable("id") Long id, Model model){
        Module module = moduleService.findById(id);
        if (module == null){
            model.addAttribute("error", "Module not found");
            return "modules";
        }
        model.addAttribute("module", module);
        eventLoggingService.save(new EventLogging(event, "editModulePage"));
        return "editModule";
    }

    @PostMapping("/editModule/{id}")
    public String editModule(@PathVariable("id") Long id, @ModelAttribute("module") Module module, Model model){
        if (moduleService.findById(id) == null){
            model.addAttribute("error", "Module not found");
            return "modules";
        }
        moduleService.save(module);
        model.addAttribute("modules", moduleService.findAll());
        eventLoggingService.save(new EventLogging(event, "editModule"));
        return "modules";
    }

    @PostMapping("/searchModule")
    public String searchModule(@RequestParam("param") String param, @RequestParam("valeur") String valeur, Model model){
        if (param.equals("code")){
            Module module = moduleService.findByCode(valeur);
            if (module == null){
                model.addAttribute("error", "Module not found");
                return "modules";
            }
            model.addAttribute("module", module);
        } else if (param.equals("name")) {
            Module module = moduleService.findByName(valeur);
            if (module == null){
                model.addAttribute("error", "Module not found");
                return "modules";
            }
            model.addAttribute("module", module);
        }
        eventLoggingService.save(new EventLogging(event, "searchModule"));
        return "modules";
    }

    //Crud for class
    @GetMapping("/addClass")
    public String addClassPage(){
        return "addClass";
    }

    @PostMapping("/addClass")
    public String addClass(@ModelAttribute("classe") Level classe, Model model){
        if (levelService.findByCode(classe.getCode()) != null){
            model.addAttribute("error", "Class already exists");
            return "addClass";
        }
        levelService.save(classe);
        eventLoggingService.save(new EventLogging(event, "addClass"));
        return "classes";
    }

    @PostMapping("/deleteClass/{id}")
    public String deleteClass(@PathVariable("id") Long id, Model model){
        if (levelService.getLevelById(id) == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        levelService.deleteById(id);
        model.addAttribute("classes", levelService.getAllLevels());
        eventLoggingService.save(new EventLogging(event, "deleteClass"));
        return "classes";
    }

    @GetMapping("/editClass/{id}")
    public String editClassPage(@PathVariable("id") Long id, Model model){
        Level classe = levelService.getLevelById(id);
        if (classe == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        model.addAttribute("classe", classe);
        eventLoggingService.save(new EventLogging(event, "editClassPage"));
        return "editClass";
    }

    @PostMapping("/editClass/{id}")
    public String editClass(@PathVariable("id") Long id, @ModelAttribute("classe") Level classe, Model model){
        if (levelService.getLevelById(id) == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        levelService.save(classe);
        model.addAttribute("classes", levelService.getAllLevels());
        eventLoggingService.save(new EventLogging(event, "editClass"));
        return "classes";
    }

    @PostMapping("/searchClass")
    public String searchClass(@RequestParam("param") String param, @RequestParam("valeur") String valeur, Model model){
        if (param.equals("code")){
            Level classe = levelService.findByCode(valeur);
            if (classe == null){
                model.addAttribute("error", "Class not found");
                return "classes";
            }
            model.addAttribute("classe", classe);
        } else if (param.equals("name")) {
            Level classe = levelService.findByName(valeur);
            if (classe == null){
                model.addAttribute("error", "Class not found");
                return "classes";
            }
            model.addAttribute("classe", classe);
        }
        eventLoggingService.save(new EventLogging(event, "searchClass"));
        return "classes";
    }

    //Crud for branch
    @GetMapping("/addBranch")
    public String addBranchPage(){
        eventLoggingService.save(new EventLogging(event, "addBranchPage"));
        return "addBranch";
    }

    @PostMapping("/addBranch")
    public String addBranch(@ModelAttribute("branch") Branch branch, Model model){
        if (branchService.findByCode(branch.getCode()) != null){
            model.addAttribute("error", "Branch already exists");
            return "addBranch";
        }
        branchService.saveBranch(branch);
        eventLoggingService.save(new EventLogging(event, "addBranch"));
        return "branches";
    }

    @PostMapping("/deleteBranch/{id}")
    public String deleteBranch(@PathVariable("id") Long id, Model model){
        if (branchService.getBranchById(id) == null){
            model.addAttribute("error", "Branch not found");
            return "branches";
        }
        branchService.deleteBranchById(id);
        model.addAttribute("branches", branchService.getAllBranches());
        eventLoggingService.save(new EventLogging(event, "deleteBranch"));
        return "branches";
    }

    @GetMapping("/editBranch/{id}")
    public String editBranchPage(@PathVariable("id") Long id, Model model){
        Branch branch = branchService.getBranchById(id);
        if (branch == null){
            model.addAttribute("error", "Branch not found");
            return "branches";
        }
        model.addAttribute("branch", branch);
        eventLoggingService.save(new EventLogging(event, "editBranchPage"));
        return "editBranch";
    }

    @PostMapping("/editBranch/{id}")
    public String editBranch(@PathVariable("id") Long id, @ModelAttribute("branch") Branch branch, Model model){
        if (branchService.getBranchById(id) == null){
            model.addAttribute("error", "Branch not found");
            return "branches";
        }
        branchService.saveBranch(branch);
        model.addAttribute("branches", branchService.getAllBranches());
        eventLoggingService.save(new EventLogging(event, "editBranch"));
        return "branches";
    }

    @PostMapping("/searchBranch")
    public String searchBranch(@RequestParam("param") String param, @RequestParam("valeur") String valeur, Model model){
        if (param.equals("code")){
            Branch branch = branchService.findByCode(valeur);
            if (branch == null){
                model.addAttribute("error", "Branch not found");
                return "branches";
            }
            model.addAttribute("branch", branch);
        } else if (param.equals("name")) {
            Branch branch = branchService.findByName(valeur);
            if (branch == null){
                model.addAttribute("error", "Branch not found");
                return "branches";
            }
            model.addAttribute("branch", branch);
        }
        eventLoggingService.save(new EventLogging(event, "searchBranch"));
        return "branches";
    }

    //associate modules to class (level)
    @GetMapping("/addModuleToClass/{id}")
    public String addModuleToClassPage(@PathVariable("id") Long id, Model model){
        Level classe = levelService.getLevelById(id);
        if (classe == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        model.addAttribute("classe", classe);
        model.addAttribute("modules", moduleService.findAll());
        eventLoggingService.save(new EventLogging(event, "addModuleToClassPage"));
        return "addModuleToClass";
    }

    @PostMapping("/addModuleToClass/{id}")
    public String addModuleToClass(@PathVariable("id") Long id, @RequestParam("module") Long moduleId, Model model){
        Level classe = levelService.getLevelById(id);
        if (classe == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        Module module = moduleService.findById(moduleId);
        if (module == null){
            model.addAttribute("error", "Module not found");
            return "classes";
        }
        classe.getModules().add(module);
        levelService.save(classe);
        model.addAttribute("classes", levelService.getAllLevels());
        eventLoggingService.save(new EventLogging(event, "addModuleToClass"));
        return "classes";
    }

    //add class to branch
    @GetMapping("/addClassToBranch/{id}")
    public String addClassToBranchPage(@PathVariable("id") Long id, Model model){
        Branch branch = branchService.getBranchById(id);
        if (branch == null){
            model.addAttribute("error", "Branch not found");
            return "branches";
        }
        model.addAttribute("branch", branch);
        model.addAttribute("classes", levelService.getAllLevels());
        eventLoggingService.save(new EventLogging(event, "addClassToBranchPage"));
        return "addClassToBranch";
    }

    @PostMapping("/addClassToBranch/{id}")
    public String addClassToBranch(@PathVariable("id") Long id, @RequestParam("classe") Long classeId, Model model){
        Branch branch = branchService.getBranchById(id);
        if (branch == null){
            model.addAttribute("error", "Branch not found");
            return "branches";
        }
        Level classe = levelService.getLevelById(classeId);
        if (classe == null){
            model.addAttribute("error", "Class not found");
            return "branches";
        }
        branch.getLevels().add(classe);
        branchService.saveBranch(branch);
        model.addAttribute("branches", branchService.getAllBranches());
        eventLoggingService.save(new EventLogging(event, "addClassToBranch"));
        return "branches";
    }

    //View modules of a class
    @GetMapping("/modules/{id}")
    public String viewModulesOfClassPage(@PathVariable("id") Long id, Model model){
        Level classe = levelService.getLevelById(id);
        if (classe == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        model.addAttribute("classe", classe);
        model.addAttribute("modules", classe.getModules());
        eventLoggingService.save(new EventLogging(event, "viewModulesOfClassPage"));
        return "modules";
    }

    //Affect a teacher to a class
    @GetMapping("/classes/{id}/addTeacher")
    public String addTeacherToClassPage(@PathVariable("id") Long id, Model model){
        Level classe = levelService.getLevelById(id);
        if (classe == null){
            model.addAttribute("error", "Class not found");
            return "classes";
        }
        model.addAttribute("classe", classe);
        model.addAttribute("teachers", teacherService.findAll());
        eventLoggingService.save(new EventLogging(event, "addTeacherToClassPage"));
        return "classes";
    }

}
