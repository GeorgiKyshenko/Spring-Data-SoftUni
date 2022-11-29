package bg.softuni.modelMapper.MainRunner;

import bg.softuni.modelMapper.DTOs.addresses.CreateAddressDTO;
import bg.softuni.modelMapper.DTOs.CreateEmployeeDTO;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

//{
//        "firstName": "Some Name",
//        "lasName": "Last Name",
//        "salary": 10,
//        "address": {
//        "country": "Bulgaria",
//        "city": "Sofia"
//        }
//        }

//@Component
public class JsonTestMain implements CommandLineRunner {

    /* Inner клас който създаваме за да парснем LocalDate
       JsonSerializer за да я покажем на потребителя
       JsonDeserializer за да я прочетем от потребителя */
    private static class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
        }

        @Override
        public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
        }
    }

    private final Scanner scanner;

    @Autowired
    public JsonTestMain(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        //.setPrettyPrinting "украсява" текста като го обгражда със скоби пренася полетата на нов ред и т.н,
        // ако не посочим .setPrettyPrinting връща или приема текст на ЕДИН ред !

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("dd-MM-YY")
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
//                .setPrettyPrinting()
                .create();

        CreateAddressDTO address1DTO = new CreateAddressDTO("Bulgaria", "Sofia");
        CreateAddressDTO address2DTO = new CreateAddressDTO("Germany", "Berlin");
        CreateAddressDTO address3DTO = new CreateAddressDTO("United Kingdom", "London");

        //от базата към потребителят, показване на обектите в JSON формат
        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO("Some Name", "Last Name", BigDecimal.TEN, LocalDate.now(), address1DTO);
        String json = gson.toJson(address1DTO);
        String json2 = gson.toJson(createEmployeeDTO);
        System.out.println(json2);

        //Връщане на колекция от JSON обекти.
        List<CreateAddressDTO> createAddressDTOList = List.of(address1DTO, address2DTO, address3DTO);
        System.out.println(gson.toJson(createAddressDTOList));


        //от JSON тип подаден от потребител, създаваме(записваме) обект в базата.
        String input = scanner.nextLine(); // тук трябва да премахнем PrettyPrinting, защото input очаква един ред от конзолата.
        String input2 = scanner.nextLine();

        //приемане на JSON обект от потребител
        CreateEmployeeDTO parsedDTO = gson.fromJson(input, CreateEmployeeDTO.class);

        //приемане на масив от AddressDTO, от JSON обекти (може да се на прави и с List<Object> но препоръчително да се избягва)
        CreateAddressDTO[] arrayOfDTO = gson.fromJson(input2, CreateAddressDTO[].class);

        System.out.println();
    }
}
