package com.kushmiruk.videocourse.practice.movietheater.domain;

public abstract class DomainObject {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
