package fr.epsi.jconte.refactoring.printer;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;

public class TestAppender extends AppenderSkeleton {

    private final List<LoggingEvent> log = new ArrayList<>();

    @Override
    protected void append(LoggingEvent loggingEvent) {
        log.add(loggingEvent);
    }

    @Override
    public void close() {
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public List<LoggingEvent> getLog() {
        return new ArrayList<>(log);
    }
}
