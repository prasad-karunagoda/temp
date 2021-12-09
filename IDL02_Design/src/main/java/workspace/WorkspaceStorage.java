package workspace;

import instrumentsource.Instrument;

import java.util.HashSet;
import java.util.Set;

public final class WorkspaceStorage {

    private static WorkspaceStorage singleton;

    private Set<Instrument> allInstruments = new HashSet<>();

    private WorkspaceStorage() {
    }

    public static WorkspaceStorage getInstance() {
        if (singleton == null) {
            singleton = new WorkspaceStorage();
        }
        return singleton;
    }

    public void addInstruments(Set<Instrument> newInstruments) {
        allInstruments.addAll(newInstruments);
    }

    public Set<Instrument> getAllInstruments() {
        return allInstruments;
    }
}
