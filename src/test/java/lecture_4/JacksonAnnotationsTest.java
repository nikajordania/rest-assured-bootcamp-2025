package lecture_4;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class JacksonAnnotationsTest {

    @Test
    public void testJsonSetter() {
        Car car = new Car();
        car.setBrand("BMW");
        car.allSetter("carBrand", "Toyota");
        System.out.println(car.getBrand());
        System.out.println(car.getUnrecognizedFields());

        String complexJson = """
                {
                    "carBrand": "Mercedes",
                    "color": "Red",
                    "year": "2020",
                    "engineType": "V8",
                    "unrecognizedField1": "value1",
                    "unrecognizedField2": "value2"
                
                }
                """;

        String complexJson2 = """
                {
                    "carBrand": "Mercedes",
                    "color": "Red",
                    "year": "2020",
                    "engineType": "V8",
                    "unrecognizedField1": "value1",
                    "unrecognizedField2": "value2",
                    "subObject": {
                        "nestedField1": "nestedValue1",
                        "nestedField2": "nestedValue2",
                        "unrecognizedField3": "value3"
                    }
                }
                """;

        // Simulate deserialization
        ObjectMapper mapper = new ObjectMapper();

        try {
            Car deserializedCar = mapper.readValue(complexJson2, Car.class);
            System.out.println("Deserialized Car Brand: " + deserializedCar.getBrand());
            System.out.println("Unrecognized Fields: " + deserializedCar.getUnrecognizedFields());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

@Getter
@Setter
class Car {
    @JsonSetter("carBrand")
    private String brand;
    private Map<String, String> unrecognizedFields = new HashMap<>();

    private Map<String, Object> subObject;

    @JsonAnySetter
    public void allSetter(String fieldName, String fieldValue) {
        unrecognizedFields.put(fieldName, fieldValue);
    }

    @JsonAnyGetter
    Map<String, String> map = Map.of(
            "name", "Jack",
            "surname", "wolfskin"
    );
}
