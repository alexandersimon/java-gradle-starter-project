package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get All User")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers() {
        logger.debug("Getting All users ......");
        List<User> user = null;
        try {
            user = userService.getAll();
            logger.debug("Getting All users ...... ::");
        } catch (Exception ex) {
            logger.error("Error occurred in searchUserById >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @Operation(summary = "Search User by userId")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> searchUserById(
            @Parameter(name = "userId",
                    description = "The Id of the User to be viewed",
                    required = true)
            @PathVariable Integer userId) {
        logger.debug("Searching for user with userId ::" + userId);
        User user = null;
        try {
            user = userService.getUserById(userId);
            logger.debug("Student found with userId ::" + userId);
        } catch (Exception ex) {
            logger.error("Error occurred in searchUserById >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @Operation(summary = "Search for all User whose age is the input age")
    @RequestMapping(value = "/isAge/{age}", method = RequestMethod.GET)
    public ResponseEntity<Object> filterUsersByAge(
            @Parameter(name = "age",
                    description = "filtering age",
                    required = true) @PathVariable Integer age) {
        User userList = null;
        try {
            userList = userService.getFirstbyAge(age);
        } catch (Exception ex) {
            logger.error("Error occurred in filterStudentsByAge >>", ex, ex.getMessage());
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

}
