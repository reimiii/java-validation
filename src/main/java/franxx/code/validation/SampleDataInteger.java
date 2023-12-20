package franxx.code.validation;

import jakarta.validation.constraints.Min;

public class SampleDataInteger {

    @Min(value = 10)
    private DataInteger dataInteger;

    public DataInteger getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(DataInteger dataInteger) {
        this.dataInteger = dataInteger;
    }
}
