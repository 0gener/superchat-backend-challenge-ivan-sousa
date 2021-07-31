package com.superchat.communicationservice.controller.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public abstract class ListResponse<T, P> {
    private List<T> items;
    private ListPagination pagination;

    public ListResponse(Page<P> page) {
        this.items = page.getContent().stream().map(p -> convert(p)).collect(Collectors.toList());
        this.pagination = new ListPagination(page);
    }

    public abstract T convert(P item);
}
