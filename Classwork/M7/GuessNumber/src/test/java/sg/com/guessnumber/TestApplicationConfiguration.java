/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.com.guessnumber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 *
 * @author stephenespinal
 */

//These three annotations will replicate what the @SpringBootApplication annotation does,
//except we can not add in our filter to exclude the CommandLineRunner class. We will be referencing
//this file from our test files later, but we need it in place for the tests to even start up correctly. 
//If we did not have the CommandLineRunner, like for instance in a web application, we would not need this class.
//
//Each of our test files is going to have the same set of annotations at the top of the class:
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestApplicationConfiguration.class)
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
        value = CommandLineRunner.class))
@EnableAutoConfiguration
public class TestApplicationConfiguration {

}