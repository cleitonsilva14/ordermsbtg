package br.com.btgbackend.orderms.dto;

import org.springframework.data.domain.Page;

public record PaginationResponse(int page, int size, Long totalElements, int totalPages) {

    public static PaginationResponse fromPage(Page<?> page){
        return new PaginationResponse(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
