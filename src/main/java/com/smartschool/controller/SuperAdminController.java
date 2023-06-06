package com.smartschool.controller;

import com.smartschool.pojo.*;
import com.smartschool.service.AccountService;
import com.smartschool.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.passay.*;

@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {
    /*
    L’administrateur système pourra ajouter des comptes de type (Etudiant /
Enseignant/Cadre Administrateur). Pour créer un compte l’administrateur
système commence par rechercher une personne (étudiant par Code Massar,
Enseignant/Cadre Administrateur par CIN) puis il aura un bouton sur lequel
il faut cliquer pour afficher un formulaire qui permet de choisir le rôle du
compte, le login d’un compte est la concaténation du nom et prénom de la
personne. Si il y a des doublons, un chiffre doit être ajouté à la fin (Exemple :
tarikboudaa, tarikboudaa1, tarikboudaa2,… ). Un mot de passe doit être
généré aléatoirement et affiché à l’écran et il doit être haché avant qu’il soit
stocké en base de données.
L’administrateur du système pourra également effectuer les actions
suivantes :
- Changer le rôle d’un utilisateur
- Réinitialiser le mot de passe d’un compte
- Désactiver un compte/Réactiver un compte
- Afficher les actions effectuées par un utilisateur donné (les pages
visitées dans l’application).
- Afficher l’historiques des connexions à l’application : afficher les
utilisateurs ayant accédés à l’application, leurs adresses IP, et la
date/heure de connexion.
     */

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    @Autowired
    RoleService roleService;

    @Autowired
    EventLoggingService eventLoggingService;

    String event = "SuperAdmin";

    @GetMapping("/addAccount")
    public String addAccountPage() {
        eventLoggingService.save(new EventLogging(event, "Add Account Page"));
        return "superAdmin/addAccount";
    }

    @PostMapping("/addAccount")
    public String addAccount(@ModelAttribute("account") Account account, String role, Model model) {
        eventLoggingService.save(new EventLogging(event, "Add Account"));
        if(role.equals("student")) {
            Student s = studentService.findByCne(account.getUsername());
            if(s != null) {
                account.setUsername(s.getFname() + s.getLname());
                if (accountService.findByUsername(account.getUsername()) != null) {
                    int i=1;
                    while (accountService.findByUsername(account.getUsername() + i) != null) {
                        i++;
                    }
                    account.setUsername(account.getUsername() + i);
                }
                account.setActive(true);
                account.setUser(s);
                //Generate a password and print
                String pwd = generatePassword();
                account.setPassword(BCrypt.hashpw(pwd, BCrypt.gensalt()));
                model.addAttribute("generatedPassword", pwd);
                accountService.save(account);
            }else {
                return "redirect:/superAdmin/addAccount?error";
            }
        } else if(role.equals("teacher") || role.equals("admin")) {
            Teacher t = teacherService.findByCin(account.getUsername());
            if (t != null){
                account.setUsername(t.getFname() + t.getLname());
                if (accountService.findByUsername(account.getUsername()) != null) {
                    int i=1;
                    while (accountService.findByUsername(account.getUsername() + i) != null) {
                        i++;
                    }
                    account.setUsername(account.getUsername() + i);
                }
                account.setActive(true);
                String pwd = generatePassword();
                account.setPassword(BCrypt.hashpw(pwd, BCrypt.gensalt()));
                model.addAttribute("generatedPassword", pwd);
                account.setUser(t);
                accountService.save(account);
            }else {
                return "redirect:/superAdmin/addAccount?error";
            }
        } else {
            return "redirect:/superAdmin/addAccount?error";
        }
        return "redirect:/superAdmin/addAccount?success";
    }

    @PostMapping("/changeRole")
    public String changeRole(String username, String role) {
        eventLoggingService.save(new EventLogging(event, "Change Role"));
        Account account = accountService.findByUsername(username);
        if(account != null && roleService.findByName(role) != account.getRole()) {
            account.setRole(roleService.findByName(role));
            accountService.save(account);
        }else {
            return "redirect:/superAdmin/addAccount?error";
        }
        return "redirect:/superAdmin/addAccount?success";
    }


    @PostMapping("/resetPassword")
    public String resetPassword(String username, Model model) {
        eventLoggingService.save(new EventLogging(event, "Reset Password"));
        Account account = accountService.findByUsername(username);
        if(account != null) {
            String pwd = generatePassword();
            account.setPassword(BCrypt.hashpw(pwd, BCrypt.gensalt()));
            model.addAttribute("generatedPassword", pwd);
            accountService.save(account);
        }else {
            return "redirect:/superAdmin/addAccount?error";
        }
        return "redirect:/superAdmin/addAccount?success";
    }

    @PostMapping("/disableAccount")
    public String disableAccount(String username) {
        eventLoggingService.save(new EventLogging(event, "Disable Account"));
        Account account = accountService.findByUsername(username);
        if(account != null) {
            account.setActive(false);
            accountService.save(account);
        }else {
            return "redirect:/superAdmin/addAccount?error";
        }
        return "redirect:/superAdmin/addAccount?success";
    }

    @PostMapping("/enableAccount")
    public String enableAccount(String username) {
        eventLoggingService.save(new EventLogging(event, "Enable Account"));
        Account account = accountService.findByUsername(username);
        if(account != null) {
            account.setActive(true);
            accountService.save(account);
        }else {
            return "redirect:/superAdmin/addAccount?error";
        }
        return "redirect:/superAdmin/addAccount?success";
    }

    public static String generatePassword(){
        CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
        CharacterRule special = new CharacterRule(EnglishCharacterData.Special);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generatePassword(8, alphabets, digits, special);
        return password;
    }
}
