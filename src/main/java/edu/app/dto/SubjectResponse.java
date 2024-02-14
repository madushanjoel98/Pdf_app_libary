package edu.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.app.domains.Books;
import edu.app.domains.Category;
import edu.app.domains.Subcategory;

public class SubjectResponse {
	@JsonProperty("data")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Category> data;

	public SubjectResponse(List<Category> data) {
		super();
		this.data = data;
	}

	public List<Category> getData() {
		return data;
	}

	public void setData(List<Category> data) {
		this.data = data;
	}

	

}
