package com.onlinemarketplace.marketplace.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketPlaceException extends RuntimeException
{

    private HttpStatus status;
    private String message;

}
