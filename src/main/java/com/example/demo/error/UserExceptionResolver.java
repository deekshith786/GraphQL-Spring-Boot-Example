package com.example.demo.error;

import graphql.*;
import graphql.language.*;
import java.util.*;

public class UserExceptionResolver  extends RuntimeException implements GraphQLError {

    public UserExceptionResolver(String message) {
        super(message);
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.ValidationError;
    }

}
