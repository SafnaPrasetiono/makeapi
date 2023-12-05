package com.makeapi.model.response;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResultResponse {
    CustomResponse cResponse;
    private HttpStatus status;

    public void setResultGeneral(CustomResponse cResponsed) {
		this.cResponse = cResponsed;
        this.status = cResponsed.getStatus();
	}

    public CustomResponse getResponsed(){
        return cResponse;
    }

    public HttpStatus getStatusResponse(){
        return status;
    }
}
