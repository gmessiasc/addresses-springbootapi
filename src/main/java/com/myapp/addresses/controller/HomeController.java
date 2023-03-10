package com.myapp.addresses.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myapp.addresses.database.model.Person;
import com.myapp.addresses.service.PersonService;

@Controller
public class HomeController {

  private final PersonService personService;

  public HomeController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/")
  public String index(Model model){
      List<Person> person = personService.findAll(false);
      model.addAttribute("person", person);
      return "home/index";
  }

  @GetMapping("/person/{id}/delete")
  public String deletePerson(@PathVariable Long id){
      personService.delete(id);
      return "redirect:/";
  }

  
}
