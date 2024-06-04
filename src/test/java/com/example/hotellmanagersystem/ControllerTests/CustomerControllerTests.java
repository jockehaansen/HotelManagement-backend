package com.example.hotellmanagersystem.ControllerTests;

import com.example.hotellmanagersystem.controllers.CustomerController;
import com.example.hotellmanagersystem.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @MockBean
    private CommandLineRunner commandLineRunner;
    @MockBean
    private CustomerService customerService;

    @Test
    void createCustomer_shouldReturnNewCustomer_validFields(){
        //TODO
    }

    @Test
    void createCustomer_shouldReturnException_invalidFields(){
        //TODO
    }

    @Test
    void updateCustomer_shouldReturnUpdatedCustomer_customerFound(){
        //TODO
    }

    @Test
    void updateCustomer_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    void deleteCustomerByEmail_shouldReturnString_customerFound(){
        //TODO
    }

    @Test
    void deleteCustomerByEmail_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    void getAllCustomers_shouldReturnListOfCustomers(){
        //TODO
    }

    @Test
    void getAllBasicCustomerDTOs_shouldReturnListOfBasicCustomerDTOs(){
        //TODO
    }

    @Test
    void getAllDetailedCustomerDTOs_shouldReturnListOfDetailedCustomerDTOs(){
        //TODO
    }

    @Test
    void getCustomer_shouldReturnCustomer_customerFound(){
        //TODO
    }

    @Test
    void getCustomer_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    void getCustomerAsBasicDTO_shouldReturnBasicCustomerDTO_customerFound(){
        //TODO
    }

    @Test
    void getCustomerAsBasicDTO_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    void getCustomerAsDetailedDTO_shouldReturnDetailedCustomerDTO_customerFound(){
        //TODO
    }

    @Test
    void getCustomerAsDetailedDTO_shouldReturnException_customerNotFound(){
        //TODO
    }


}
