package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice  //if there is any exception in any of controllers it will go through Advice to Dispacther
public class ProductControllerAdvices {

    //Dispatcher <-> ControllerAdvices <-> Contoller

    //WAY1
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
////        System.out.println("Got Product not found exception");
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
////        System.out.println("Got Product not found exception");
//
////        return exceptionDto;
//
//        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }


    //WAY2
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        System.out.println("Got Product not found exception");
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        System.out.println("Got Product not found exception");

        return exceptionDto;


    }


//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    private ResponseEntity<ExceptionDto> handlearrayIndexOutOfBoundException(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
//        return null;
//    }

//    @ExceptionHandler(NullPointerException.class)
//    private ResponseEntity<ExceptionDto>  handleNullPointerException(NullPointerException nullPointerException){
//        return null;
//    }

}
