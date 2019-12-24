package com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.daos.StudentDao;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(path = "/")
public class StudentController implements WebMvcConfigurer /*implements GeneralController<Student>*/ {

    @Autowired
    private StudentDao studentDao;

    //    @Override
    @RequestMapping(path = "student/{id}", method = RequestMethod.GET)
    public Student getById(@PathVariable int id) {
        System.out.println("The student with id = " + id + ", is the\n" + studentDao.getOne(id));
        return studentDao.getOne(id);
    }

    @RequestMapping(path = "student", method = RequestMethod.GET)
    public String getStudentPage() {
        System.out.println("The student with id = 1, is the\n" + studentDao.getOne(1));
        return "student";
    }

//    @Override
//    public Student postById(long id, Student student) {
//        return null;
//    }
//
//    @Override
//    public Student deleteById(long id) {
//        return null;
//    }
//
//    @Override
//    public Student post(Student student) {
//        return null;
//    }
//
//    @Override
//    public Student put(Student student) {
//        return null;
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
