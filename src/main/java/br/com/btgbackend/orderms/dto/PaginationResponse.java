package br.com.btgbackend.orderms.dto;

public record PaginationResponse(int page, int size, int totalElements, int totalPages) {
}
