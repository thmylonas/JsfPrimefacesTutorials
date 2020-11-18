package com.thomasmylonas.my_spring_hibernate_jsf_web_app.exception_handlers.handlers;

import com.thomasmylonas.my_spring_hibernate_jsf_web_app.models.ErrorStatus;
import com.thomasmylonas.my_spring_hibernate_jsf_web_app.exception_handlers.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionsHandlerController {

    @Autowired
    private ErrorStatus notFound404BackingBean;

//    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ExceptionHandler(ResourceNotFoundException.class)
    public String resourceNotFound(ResourceNotFoundException e) {
        long resourceId = e.getResourceId();
        String message = String.format(e.getMyMessage(), resourceId);
        e.setMyMessage(message);
//        MyError error = new MyError(404, "Pet [" + resourceId + "] not found");
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        notFound404BackingBean.setMessage(new ResponseEntity<>(e, HttpStatus.NOT_FOUND).getBody().getMyMessage());

        return "404_not_found";
    }
}
