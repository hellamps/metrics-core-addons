package com.github.addon.metrics.decorator;

import com.codahale.metrics.Counter;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MinimumThresholdExceedingCounter implements UpdateListener {

    private final Counter exceedingCounter;
    private final long threshold;

    public MinimumThresholdExceedingCounter(Counter exceedingCounter, long threshold) {
        this.exceedingCounter = Objects.requireNonNull(exceedingCounter);
        this.threshold = threshold;
    }

    @Override
    public void onUpdate(long value) {
        if (value < threshold) {
            exceedingCounter.inc();
        }
    }

    public Counter getExceedingCounter() {
        return exceedingCounter;
    }

    public long getThreshold() {
        return threshold;
    }
    
}
