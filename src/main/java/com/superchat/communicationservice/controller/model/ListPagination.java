package com.superchat.communicationservice.controller.model;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class ListPagination {
    private Integer prev;
    private Integer next;
    private Long total;

    public ListPagination(Page<?> page) {
        this.prev = page.isFirst() ? null : page.getPageable().getPageNumber();
        this.next = page.isLast() ? null : page.getPageable().getPageNumber() + 1;
        this.total = page.getTotalElements();
    }
}
