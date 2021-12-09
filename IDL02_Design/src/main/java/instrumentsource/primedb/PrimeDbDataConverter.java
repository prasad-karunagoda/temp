package instrumentsource.primedb;

import instrumentsource.Instrument;
import instrumentsource.InstrumentDataConverter;

public class PrimeDbDataConverter implements InstrumentDataConverter {

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
