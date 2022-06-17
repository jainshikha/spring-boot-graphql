package com.tech.impli.graphql.springbootgraphql.service.EcuModelDataFecher;

import com.tech.impli.graphql.springbootgraphql.model.EcuModel;
import com.tech.impli.graphql.springbootgraphql.repos.EcuModelRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AllEcuModelDataFetcher")
@Qualifier("AllEcuModelDataFetcher")
public class AllEcuModelDataFetcher implements DataFetcher<List<EcuModel>> {
  @Autowired EcuModelRepository ecuModelRepository;

  @Override
  public List<EcuModel> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
    return ecuModelRepository.findAll();
  }
}
