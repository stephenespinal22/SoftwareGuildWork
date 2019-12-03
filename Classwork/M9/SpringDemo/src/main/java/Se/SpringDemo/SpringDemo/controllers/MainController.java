/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Se.SpringDemo.SpringDemo.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author stephenespinal
 */
//give class meta data
//will always retur string

@Controller
public class MainController {

    //basically what we are doing here is http requests going back and forth
    //when you hit submit on a form you just doing a http request
    //the request will get directed to this method and you have request in a variavble
    //then you have the variables then at that point you can do whatever dao, anythibg
    
    //list is an array thats an abstract type that allows you to pass in a type
    //that stores data dynamically
    
    //check if you can add dependency that restarts server every time you save!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
    //difference between this and M2 is we are sending html template
    //difference between this and Javascript is this has the html and server talk so nothing is
    //sent to the browser
    
    //on spring initilizer add spring data jdbc and mysql driver or aadd them to pom file
    
    //this is model binding, spring mathcing up the parameter with what was sent from client
//    @PostMapping("editStudent")
//public String performEditStudent(@Valid Student student) {
//    
String name = "John";
    int number = 42;
    
       //every time we do getmapping we have model
    @GetMapping("test")
    public String testPage(Model model) {
        
        model.addAttribute("number", number);
        model.addAttribute("firstName", name);
        
        return "test";
    }
    
    @PostMapping("testForm")
    public String testForm(HttpServletRequest request) {
        name = request.getParameter("formFirstName");
        number = Integer.parseInt(request.getParameter("formNumber"));
        
        //tell spring to redirect user to mapping test
        return "redirect:/test";
    }

       @GetMapping("testList") 
    public String testList(Model model) {
        List<Integer> numbers = new ArrayList<>();
        
        numbers.add(0);
        numbers.add(10);
        numbers.add(6);
        numbers.add(35);
        
        model.addAttribute("numberList", numbers);
        
        return "testList";
    }
    
      @GetMapping("testConditional")
    public String testConditional(Model model) {
        
        model.addAttribute("truth", true);
        model.addAttribute("theNumber", 33);
        model.addAttribute("aString", "testing");
        
        return "testConditional";
    }
}
