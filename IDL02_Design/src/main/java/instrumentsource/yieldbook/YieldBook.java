package instrumentsource.yieldbook;

import instrumentsource.Instrument;
import instrumentsource.InstrumentDataConverter;
import instrumentsource.InstrumentSource;
import workspace.WorkspaceStorage;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class YieldBook implements InstrumentSource {

    private final InstrumentDataConverter dataConverter = new YieldBookDataConverter();

    @Override
    public void loadInstruments(Callable<Object> callback) {
        List<String> sampleInstruments = Arrays.asList("YBIns1", "YBIns2", "YBIns3");
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
