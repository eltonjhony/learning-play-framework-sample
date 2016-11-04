package utils.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by eltonjhony on 03/11/16.
 */
public class DiscountInput extends InputValidator implements Serializable {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean hasErrors() {
        return !isFieldsValid(InputField.create(id), InputField.create(name, 255L));
    }

}
