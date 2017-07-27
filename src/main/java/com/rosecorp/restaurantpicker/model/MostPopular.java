package com.rosecorp.restaurantpicker.model;

public class MostPopular {
    private String name;
    private Long vote;

    public MostPopular() {
    }

    public MostPopular(String name, Long vote) {
        this.name = name;
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVote() {
        return vote;
    }

    public void setVote(Long vote) {
        this.vote = vote;
    }
}
