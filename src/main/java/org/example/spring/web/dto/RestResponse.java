package org.example.spring.web.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class RestResponse {
    public static Map<String, Object> response(HttpStatus status, Object results,Object type) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", status.value());
        response.put("results", results);
        response.put("type", type);
        return response;
    }

    public static Map<String, Object> responseError (BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return response;
    }

    public static Map<String, Object> responsePaginate(HttpStatus status, Object results, Object pages,
            Object currentPage, Object totalPages, Object totalItems,Boolean first,Boolean last,String type) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", status.value());
        response.put("results", results);
        response.put("pages", pages);
        response.put("currentPage", currentPage);
        response.put("totalPages", totalPages);
        response.put("totalItems", totalItems);
        response.put("first", first);
        response.put("last", last);
        response.put("type", type);
        return response;
    }
}
