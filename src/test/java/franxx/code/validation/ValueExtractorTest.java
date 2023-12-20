package franxx.code.validation;

import franxx.code.validation.container.Data;
import franxx.code.validation.container.Entry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidationTest {

    @Test
    void sampleData() {
        SampleData sampleData = new SampleData();

        sampleData.setData(new Data<>());
        sampleData.getData().setData("   ");

        validate(sampleData);
    }

    @Test
    void sampleEntry() {
        SampleEntry sampleEntry = new SampleEntry();

        sampleEntry.setEntry(new Entry<>());

        sampleEntry.getEntry().setKey(" ");
        sampleEntry.getEntry().setValue(" ");

        validate(sampleEntry);
    }

    @Test
    void sampleDataInteger() {
        SampleDataInteger sampleDataInteger = new SampleDataInteger();

        sampleDataInteger.setDataInteger(new DataInteger());
        sampleDataInteger.getDataInteger().setData(0);

        validate(sampleDataInteger);
    }
}
