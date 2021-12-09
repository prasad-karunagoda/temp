package test;

import instrumentsource.Instrument;
import instrumentsource.InstrumentSource;
import instrumentsource.primedb.PrimeDb;
import instrumentsource.yieldbook.YieldBook;
import workspace.WorkspaceStorage;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class Test {

    @org.junit.Test
    public void test() {
        Set<InstrumentSource> sources = new HashSet<>();
        sources.add(new PrimeDb());
        sources.add(new YieldBook());

        for (InstrumentSource s : sources) {
            s.loadInstruments(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    Set<Instrument> allInstruments = WorkspaceStorage.getInstance().getAllInstruments();
                    System.out.println(allInstruments.size() + " instruments in the workspace.");
                    allInstruments.forEach(System.out::println);
                    return null;
                }
            });
        }
    }
}
