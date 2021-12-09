package instrumentsource;

import java.util.concurrent.Callable;

public interface InstrumentSource {

    void loadInstruments(Callable<Object> callback);

    InstrumentDataConverter getInstrumentDataConverter();
}
