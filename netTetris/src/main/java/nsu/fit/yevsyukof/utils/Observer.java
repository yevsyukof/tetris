package nsu.fit.yevsyukof.utils;

import nsu.fit.yevsyukof.model.ModelStates;

public interface Observer {

    void handleEvent(ModelStates curModelState);
}
