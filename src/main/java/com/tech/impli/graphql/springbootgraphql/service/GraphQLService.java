package com.tech.impli.graphql.springbootgraphql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.impli.graphql.springbootgraphql.model.EcuModel;
import com.tech.impli.graphql.springbootgraphql.repos.EcuModelRepository;
import com.tech.impli.graphql.springbootgraphql.service.EcuModelDataFecher.AllEcuModelDataFetcher;
import com.tech.impli.graphql.springbootgraphql.service.EcuModelDataFecher.EcuModelDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class GraphQLService {
  @Value("classpath:graphql/schema.graphqls")
  Resource resource;

  @Autowired EcuModelRepository ecuModelRepository;

  private GraphQL graphQL;

  @Autowired private AllEcuModelDataFetcher allEcuModelDataFetcher;

  @Autowired private EcuModelDataFetcher ecuModelDataFetcher;

  @PostConstruct
  private void loadSchema() throws IOException {
    // load Data to the repository
    loadEcuModelDataINtoHSQL();
    // get the schema
    File schemaFile = resource.getFile();
    // parse schema
    TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);

    RuntimeWiring wiring = buildRuntimeWiring();
    GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
    graphQL = GraphQL.newGraphQL(schema).build();
  }

  private void loadEcuModelDataINtoHSQL() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Object jsonInput = new Object();
    /** Read object from file */
    List<EcuModel> ecuModel =
        Arrays.asList(
            mapper.readValue(
                new File("C:/Users/A119619981/T-system/Spector/taget_sw_json/11D.txt"),
                EcuModel[].class));

    try {
      JSONObject obj = new JSONObject("{interests : [{interestKey:Dogs}, {interestKey:Cats}]}");

      List<String> list = new ArrayList<String>();
      JSONArray array = obj.getJSONArray("interests");
      for (int i = 0; i < array.length(); i++) {
        list.add(array.getJSONObject(i).getString("interestKey"));
      }
      System.out.println("List is "+list);
    } catch (Exception e) {
      System.out.println(e);
    }

    Stream.of(ecuModel)
        .forEach(
            ecuList -> {
              ecuModelRepository.saveAll(ecuList);
            });
  }


  private RuntimeWiring buildRuntimeWiring() {
    return RuntimeWiring.newRuntimeWiring()
        .type(
            "Query",
            typeWiring ->
                typeWiring
                    .dataFetcher("allEcus", allEcuModelDataFetcher)
                    .dataFetcher("ecus", ecuModelDataFetcher))
        .build();
  }

  public GraphQL getGraphQL() {
    return graphQL;
  }
}
