package com.example.advquerying;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;

    @Autowired
    public Runner(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

//        String sizeType = scanner.nextLine();
//
//        Size size = Size.valueOf(sizeType);
//
//        shampooRepository.findBySizeOrderById(size)
//                .forEach(System.out::println);

        String firstIngredient = scanner.nextLine();
        String secondIngredient = scanner.nextLine();

        Set<String> ingredientsName = Set.of(firstIngredient, secondIngredient);

        shampooRepository.findByIngredientsNames(ingredientsName)
                .forEach(System.out::println);

    }
}
