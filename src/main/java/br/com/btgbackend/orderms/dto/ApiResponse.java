package br.com.btgbackend.orderms.dto;

import java.util.List;

public record ApiResponse<C>(List<C> data, PaginationResponse response){

}
