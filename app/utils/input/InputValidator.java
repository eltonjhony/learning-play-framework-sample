package utils.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by eltonjhony on 03/11/16.
 */
public class InputValidator {

    @JsonIgnore
    protected boolean isFieldsValid(InputField... fields) {
        boolean isValid = true;
        for (InputField field : fields) {

            if (String.class.equals(field.value)) {
                String text = (String) field.value;
                if (StringUtils.isBlank(text) || isInvalidLength(text, field.maxLength)) {
                    isValid = false;
                    break;
                }
            }

            if (Long.class.equals(field.value)) {
                Long number = (Long) field.value;
                if (!NumberUtils.isDigits(String.valueOf(number))) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    private boolean isInvalidLength(String text, Long maxLength) {
        if (maxLength != null) {
            return text.length() > maxLength;
        }
        return false;
    }

    protected static class InputField {
        protected Object value;
        protected Long maxLength;

        public InputField(final Object value, final Long maxLength) {
            this.value = value;
            this.maxLength = maxLength;
        }

        protected static InputField create(final Object value) {
            return new InputField(
                    value,
                    null
            );
        }

        protected static InputField create(final Object value, final Long maxLength) {
            return new InputField(
                    value,
                    maxLength
            );
        }
    }
}
