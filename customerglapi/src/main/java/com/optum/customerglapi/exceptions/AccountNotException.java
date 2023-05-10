package com.optum.customerglapi.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Data
public class AccountNotException extends RuntimeException implements GraphQLError {

    private String invalidField;
    public AccountNotException(String message){
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return GraphQLError.super.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return GraphQLError.super.toSpecification();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return  Collections.singletonMap("invalidField", invalidField);
    }
}
