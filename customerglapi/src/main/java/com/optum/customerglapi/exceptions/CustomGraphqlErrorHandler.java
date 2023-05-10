package com.optum.customerglapi.exceptions;
/*
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CustomGraphqlErrorHandler implements GraphQLErrorHandler {
    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        if (errors instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) errors;
            if (exceptionError.getException() instanceof GraphQLError) {
                return  exceptionError.getException();
            }
        }
        return errors;
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getNested).collect(Collectors.toList());
    }
}
*/