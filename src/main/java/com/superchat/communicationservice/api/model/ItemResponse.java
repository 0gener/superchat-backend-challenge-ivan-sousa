package com.superchat.communicationservice.api.model;

import lombok.Getter;

@Getter
public abstract class ItemResponse<T, E> {
    private T item;

    public ItemResponse(E entity) {
        this.item = convert(entity);
    }

    public abstract T convert(E entity);
}
