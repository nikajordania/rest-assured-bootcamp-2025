package data.model.lecture_4.petstore.lombok;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;
}
