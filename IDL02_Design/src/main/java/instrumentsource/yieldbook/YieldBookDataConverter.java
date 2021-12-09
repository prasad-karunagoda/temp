package instrumentsource.yieldbook;

import instrumentsource.Instrument;
import instrumentsource.InstrumentDataConverter;

public class YieldBookDataConverter implements InstrumentDataConverter {

    @Override
    public Instrument convert(Object externalInstrument) {
        return new Instrument() {
            @Override
            public String toString() {
                return externalInstrument.toString();
            }
        };
    }
}
