package com.example.hotellmanagersystem;

import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class HotellManagerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotellManagerSystemApplication.class, args);


    }

    @Bean
    public CommandLineRunner enter(RoomRepository roomRepository, BookingRepository bookingRepository) {
        Random random = new Random();

        return args -> {

            for (int i = 0; i < 20; i++) {
                Room room = new Room();
                room.setRoomNumber(i + 10);
                room.setBeds(random.nextInt(1,4));
                room.setCreated(LocalDate.now());
                roomRepository.save(room);
            }
        };

    }
}
