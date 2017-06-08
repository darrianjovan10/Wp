package com.thomasdwidinata.ecomas.controllers;

import com.thomasdwidinata.ecomas.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.thomasdwidinata.ecomas.models.User;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author thomasdwidinata
 */
@Controller
@ComponentScan("com.thomasdwidinata.ecomas.services")
public class DefaultController {
    
    @Autowired
    private UserServices userServices;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getIndexPage(ModelMap models){
        List<User> users = userServices.findAllUser();
        models.put("listUser", users);
        return "index";
    }
    
    @RequestMapping(value="/add/user", method = RequestMethod.GET)
    public String addUser(){
        return "user/add";
    }
    
    @RequestMapping(value="/update/user/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") String id, ModelMap modelMap){
        modelMap.put("id", id);
        return "user/update";
    }
    
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public ResponseEntity<List<User>> listUsers(ModelMap models){
        List<User> users = userServices.findAllUser();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id){
        User user = userServices.findById(id);
        if(user == null){
            System.out.println("User with ID : " + id + " not found!");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
        System.out.println("Creating user : " + user.getUsername());
        userServices.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user){
        System.out.println("Updating User : " + id);
        User currentUser = userServices.findById(id);
        if(currentUser == null){
            System.out.println("User with ID : " + id + " was not found!");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setRole(user.getRole());
        userServices.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> removeUser(@PathVariable("id") String id){
        User user = userServices.findById(id);
        if(user == null){
            System.out.println("Unable to delete. User with ID : " + id + " was not found!");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
    
    
}