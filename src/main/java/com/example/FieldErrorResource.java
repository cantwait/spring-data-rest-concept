package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FieldErrorResource {
	
	private String resource;
    private String field;
    private String code;
    private String message;

}
