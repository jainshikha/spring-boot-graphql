package com.tech.impli.graphql.springbootgraphql.resource;

import com.tech.impli.graphql.springbootgraphql.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ecuModelResource")
@RestController
public class EcuModelResource {
  public static final String ROOT_PATH = "/item";
  @Autowired GraphQLService graphQLService;

  @PostMapping
  public ResponseEntity<Object> getAllEcuModel(@RequestBody String query) {
    ExecutionResult executionResult = graphQLService.getGraphQL().execute(query);
    return new ResponseEntity<>(executionResult, HttpStatus.OK);
  }
}
