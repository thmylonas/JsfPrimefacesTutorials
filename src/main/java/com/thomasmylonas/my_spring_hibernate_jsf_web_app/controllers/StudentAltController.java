package com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.controllers._base.AbstractController;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.data_access_layer.entities.StudentAlt;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.service_layer.services.api_services.StudentAltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A simple sample API, on the StudentAlt entity (alternative)
 */
@Controller
@RequestMapping(path = "/")
public class StudentAltController extends AbstractController {

    @Autowired
    private StudentAltService studentAltService;

    // http://localhost:8080/MySpringHibernateJsfWebApp/student-alt/{id}
    @RequestMapping(path = "student-alt/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentAlt getStudentAltById(@PathVariable Long id) {
        StudentAlt studentAlt = studentAltService.getStudentAltById(id);
        LOGGER.info("The studentAlt with id = " + id + ", is the\n" + studentAlt);
        return studentAlt;
    }

    @RequestMapping(path = "student-alt", method = RequestMethod.GET)
    public String getStudentAltPage(Model model) {
        model.addAttribute("studentAltService", studentAltService);
        return "student_alt";
    }
}
