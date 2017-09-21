package com.kushmiruk.videocourse.practice.movietheater.service;

import com.kushmiruk.videocourse.practice.movietheater.domain.Auditorium;

import java.util.Set;

public interface AuditoriumService {
    /**
     * Getting all auditoriums from the system
     *
     * @return set of all auditoriums
     */
    Set<Auditorium> getAll();

    /**
     * Finding auditorium by name
     *
     * @param name Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    Auditorium getByName(String name);

}
