package com.codewithsiva.controller;

import com.codewithsiva.dao.StudentDao;
import com.codewithsiva.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {



        @RequestMapping("/")
        public String showpage() {

            return "index";
        }

        @RequestMapping("/login")
        public String login(HttpServletRequest req, Model model) throws SQLException, ClassNotFoundException {

            StudentDao studentDao = new StudentDao();
            String Firstname = req.getParameter("Firstname");
            String Lastname = req.getParameter("Lastname");
            Student LoggedInUser = studentDao.loginuser(Firstname, Lastname);

            if (LoggedInUser != null) {
                ArrayList<Student> allstudents=studentDao.allStudent();
                model.addAttribute("Students",allstudents);
                return "home";
            } else {
                return "register";
            }
        }

        @RequestMapping("/Register")
        public String showReg() {
            return "register";
        }

        @RequestMapping("/FormRegister")

        public String showRegister(HttpServletRequest req) throws SQLException, ClassNotFoundException {
            StudentDao studentDao = new StudentDao();
            String Firstname = req.getParameter("Firstname");
            String Lastname = req.getParameter("Lastname");
            String Country = req.getParameter("Country");
            String Language = req.getParameter("Language");
            String OS = req.getParameter("OS");
            studentDao.NewUser(Firstname, Lastname, Country, Language, OS);

            return "index";
        }

    }

