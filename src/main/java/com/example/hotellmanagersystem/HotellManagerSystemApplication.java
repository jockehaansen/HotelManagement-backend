package com.example.hotellmanagersystem;

import com.example.hotellmanagersystem.models.Address;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.AddressRepository;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class HotellManagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotellManagerSystemApplication.class, args);


    }

    @Bean
    public CommandLineRunner enter(RoomRepository roomRepository, BookingRepository bookingRepository, AddressRepository addressRepository, CustomerRepository customerRepository) {
        Random random = new Random();

        return args -> {

            for (int i = 0; i < 20; i++) {
                Room room = new Room();
                room.setRoomNumber(i + 10);
                room.setBeds(random.nextInt(1,4));
                room.setCreated(LocalDate.now());
                roomRepository.save(room);
            }
            Address address = new Address(1L, "Tallkrogsvägen", "99", "12260", "Enskede", "Sweden", LocalDate.now(), null, null);
            addressRepository.save(address);
            Customer customer = new Customer();
            customer.setAddress(address);
            customer.setFirstName("Joakim");
            customer.setLastName("Hansen");
            customer.setPhoneNumber("070-1234567");
            customer.setEmail("example@email.com");
            customerRepository.save(customer);
            Booking booking = new Booking(LocalDate.now(), LocalDate.now().plusDays(2), 2000, LocalDate.now(), customer, List.of(roomRepository.findById(1L).orElse(null)));
            bookingRepository.save(booking);
        };

    }
}
