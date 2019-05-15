package automation.examples.site.pages.session;

import automation.examples.site.pages.Page;

public interface SessionPage extends Page {

    void waitForSessionIsCreated();

    void startSession();

    void waitForSessionIsStarted();

    void pauseSession();

    void waitForSessionIsPaused();

    void stopSession();

    void waitForSessionIsStopped();

    boolean isPauseButtonAvailable();

    boolean isStartButtonAvailable();

    boolean isStopButtonAvailable();

    String getSessionStatusValue();

    String getLinkForTrainingSession();
}
