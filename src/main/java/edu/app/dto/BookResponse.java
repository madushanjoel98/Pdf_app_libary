package edu.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.app.domains.Books;

public class BookResponse {
	 @JsonProperty("data")
     @JsonInclude(JsonInclude.Include.NON_NULL)
	 private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BookResponse(Object data) {
		super();
		this.data = data;
	}
	 
}
