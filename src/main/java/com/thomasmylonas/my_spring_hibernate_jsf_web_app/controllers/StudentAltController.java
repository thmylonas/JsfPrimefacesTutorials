package com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers._base.AbstractController;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.StudentAltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * A simple sample API, on the StudentAlt entity (alternative)
 */
@Controller
@RequestMapping(path = "/api/student-alt/")
public class StudentAltController extends AbstractController {

    private final StudentAltService studentAltService;

    @Autowired
    public StudentAltController(StudentAltService studentAltService) {
        this.studentAltService = studentAltService;
    }

    // http://localhost:8080/MySpringHibernateJsfWebApp/api/student-alt/1
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<StudentAlt> getStudentAltById(@PathVariable(name = "id") Long id) {
        StudentAlt studentAlt = studentAltService.getStudentAltById(id);
        LOGGER.info("The studentAlt with id = " + id + ", is the\n" + studentAlt);
        return new ResponseEntity<>(studentAlt, HttpStatus.OK);
    }

    // http://localhost:8080/MySpringHibernateJsfWebApp/api/student-alt/all-students-alt
    @RequestMapping(path = "all-students-alt", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<StudentAlt>> getAllStudentsAlt() {
        return new ResponseEntity<>(studentAltService.getAllStudentsAlt(), HttpStatus.OK);
    }

    // http://localhost:8080/MySpringHibernateJsfWebApp/api/student-alt
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StudentAlt> saveNewStudentAlt(@RequestBody StudentAlt studentAlt) {
        return new ResponseEntity<>(studentAltService.saveStudentAlt(studentAlt), HttpStatus.CREATED);
    }

    // http://localhost:8080/MySpringHibernateJsfWebApp/api/student-alt/1
    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<StudentAlt> updateExistingStudentAlt(@RequestBody StudentAlt studentAlt,
                                                               @PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(studentAltService.updateStudentAlt(studentAlt, id), HttpStatus.OK);
    }

    // http://localhost:8080/MySpringHibernateJsfWebApp/api/student-alt/1
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteExistingStudentAlt(@PathVariable(name = "id") Long id) {
        studentAltService.deleteStudentAlt(id);
    }

    @RequestMapping(path = "student-alt", method = RequestMethod.GET)
    public String getStudentAltPage(Model model) {
        model.addAttribute("studentAltService", studentAltService);
        return "student_alt";
    }
}
