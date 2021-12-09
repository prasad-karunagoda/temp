package instrumentsource.primedb;

import instrumentsource.Instrument;
import instrumentsource.InstrumentDataConverter;
import instrumentsource.InstrumentSource;
import workspace.WorkspaceStorage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class PrimeDb implements InstrumentSource {

    private final InstrumentDataConverter dataConverter = new PrimeDbDataConverter();

    @Override
    public void loadInstruments(Callable<Object> callback) {
        List<String> sampleInstruments = Arrays.asList("PrimeIns1", "PrimeIns2", "PrimeIns3");
        Set<Instrument> instruments = sampleInstruments.stream()
                .map(ins -> getInstrumentDataConverter().convert(ins))
                .collect(Collectors.toSet());
        WorkspaceStorage.getInstance().addInstruments(instruments);

        try {
            callback.call();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public InstrumentDataConverter getInstrumentDataConverter() {
        return dataConverter;
    }
}
