package com.kushmiruk.videocourse.practice.movietheater.service;

import com.kushmiruk.videocourse.practice.movietheater.domain.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public interface EventService {
    /**
     * Finding event by name
     *
     * @param name Name of the event
     * @return found event or <code>null</code>
     */
    Event getByName(String name);

    /**
     * Finding all events that air on specified date range
     *
     * @param from Start date
     * @param to   End date inclusive
     * @return Set of events
     */
    Set<Event> getForDateRange(LocalDate from, LocalDate to);

    /**
     * Return events from 'now' till the the specified date time
     *
     * @param to End date time inclusive
     *           s
     * @return Set of events
     */
    Set<Event> getNextEvents(LocalDateTime to);

}
