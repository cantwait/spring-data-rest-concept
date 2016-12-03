package com.example;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
	
	private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors = new ArrayList<>();

}
