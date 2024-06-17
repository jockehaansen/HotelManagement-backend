package com.example.hotellmanagersystem.ControllerTests;

import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.controllers.CustomerController;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @BeforeEach
    void init(){
        assertNotNull(commandLineRunner);
        assertNotNull(customerService);
        assertNotNull(customerRepository);
    }

    @Test
    @WithMockUser
    void createCustomer_shouldReturnNewCustomer_validFields() throws Exception {
        DetailedCustomerDTO expectedResponse = new DetailedCustomerDTO();
        when(customerService.createCustomer(any(DetailedCustomerDTO.class))).thenReturn(expectedResponse);

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
    @WithMockUser
    void getAllCustomers_shouldReturnListOfCustomers() throws Exception {
        List<Customer> expectedResponse = List.of(new Customer(), new Customer());
        when(customerService.getAllCustomers()).thenReturn(expectedResponse);

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    @WithMockUser
    void getAllBasicCustomerDTOs_shouldReturnListOfBasicCustomerDTOs() throws Exception {
        List<BasicCustomerDTO> expectedResponse = List.of(new BasicCustomerDTO(), new BasicCustomerDTO());
        when(customerService.getAllCustomersAsBasicDTO()).thenReturn(expectedResponse);

        mockMvc.perform(get("/customers/basic"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    @WithMockUser
    void getAllDetailedCustomerDTOs_shouldReturnListOfDetailedCustomerDTOs() throws Exception {
        List<DetailedCustomerDTO> expectedResponse = List.of(new DetailedCustomerDTO(), new DetailedCustomerDTO());
        when(customerService.getAllCustomersAsDetailedDTO()).thenReturn(expectedResponse);

        mockMvc.perform(get("/customers/detailed"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    @WithMockUser
    void getCustomer_shouldReturnCustomer_customerFound() throws Exception {
        Customer expectedResult = new Customer();
        expectedResult.setEmail("test@example.com");
        when(customerService.getCustomerByEmail(expectedResult.getEmail())).thenReturn(expectedResult);

        mockMvc.perform(get("/customers/customer/{email}", expectedResult.getEmail()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    void getCustomer_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    @WithMockUser
    void getCustomerAsBasicDTO_shouldReturnBasicCustomerDTO_customerFound() throws Exception {
        BasicCustomerDTO expectedResult = new BasicCustomerDTO();
        expectedResult.setEmail("test@example.com");
        when(customerService.getBasicCustomerDTOByEmail(expectedResult.getEmail())).thenReturn(expectedResult);

        mockMvc.perform(get("/customers/customer/{email}/basic", expectedResult.getEmail()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    void getCustomerAsBasicDTO_shouldReturnException_customerNotFound(){
        //TODO
    }

    @Test
    @WithMockUser
    void getCustomerAsDetailedDTO_shouldReturnDetailedCustomerDTO_customerFound() throws Exception {
        DetailedCustomerDTO expectedResult = new DetailedCustomerDTO();
        expectedResult.setEmail("test@example.com");
        when(customerService.getDetailedCustomerDTOByEmail(expectedResult.getEmail())).thenReturn(expectedResult);

        mockMvc.perform(get("/customers/customer/{email}/detailed", expectedResult.getEmail()))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
    }

    @Test
    void getCustomerAsDetailedDTO_shouldReturnException_customerNotFound(){
        //TODO
    }


}
