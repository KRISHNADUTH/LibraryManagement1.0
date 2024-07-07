package com.krishna.LibraryManageMent.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorDetails {
    Date timestamp;
    String message;
    String errorDetails;
}
