package edu.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.app.domains.Books;

public class CommonListResponse {

	 @JsonProperty("data")
     @JsonInclude(JsonInclude.Include.NON_NULL)
	 private List<Books> data;

	public CommonListResponse(List<Books> list) {
		super();
		this.data = list;
	}

	public List<Books> getData() {
		return data;
	}

	public void setData(List<Books> data) {
		this.data = data;
	}

	

}
