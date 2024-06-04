package com.example.hotellmanagersystem.ControllerTests;

import com.example.hotellmanagersystem.controllers.CustomerController;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidCustomerAttributesException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @MockBean
    private CommandLineRunner commandLineRunner;
    @MockBean
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void createCustomer_shouldReturnNewCustomer_validFields() throws Exception {
        Customer expectedResponse = new Customer();
        when(customerService.isCustomerFieldsValid(expectedResponse)).thenReturn(true);
        when(customerService.createCustomer(any(Customer.class))).thenReturn(expectedResponse);

        mockMvc.perform(post("/customers/create").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expectedResponse)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    @WithMockUser
    void createCustomer_shouldReturnException_invalidFields() {
        //TODO
    }

    @Test
    @WithMockUser
    void updateCustomer_shouldReturnUpdatedCustomer_customerFound() throws Exception {
        Customer customer = new Customer();
        Customer expectedResponse = new Customer();
        when(customerRepository.findAll()).thenReturn(List.of(customer));
        when(customerService.getAllCustomers()).thenReturn(List.of(customer));
        when(customerService.updateCustomer(customer)).thenReturn(expectedResponse);

        mockMvc.perform(put("/customers/update").with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expectedResponse)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    void updateCustomer_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    @WithMockUser
    void deleteCustomerByEmail_shouldReturnString_customerFound() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("example@email.com");
        String expectedResponse = "Customer with email " + customer.getEmail() + " has been deleted successfully";

        when(customerRepository.findAll()).thenReturn(List.of(customer));
        when(customerService.deleteCustomerByEmail(customer.getEmail())).thenReturn(expectedResponse);

        mockMvc.perform(delete("/customers/delete/{email}", customer.getEmail()).with(csrf()))
                        .andExpect(status().isOk())
                        .andExpect(content().string(expectedResponse));
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
