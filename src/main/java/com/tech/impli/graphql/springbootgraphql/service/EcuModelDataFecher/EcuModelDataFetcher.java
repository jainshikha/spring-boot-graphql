package com.tech.impli.graphql.springbootgraphql.service.EcuModelDataFecher;

import com.tech.impli.graphql.springbootgraphql.model.EcuModel;
import com.tech.impli.graphql.springbootgraphql.repos.EcuModelRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EcuModelDataFetcher")
@Qualifier("EcuModelDataFetcher")
public class EcuModelDataFetcher implements DataFetcher<List<EcuModel>> {
  private final DataFetcher delegate;
  @Autowired EcuModelRepository ecuModelRepository;

  public EcuModelDataFetcher(DataFetcher delegate) {
    this.delegate = delegate;
  }

  @Override
  public List<EcuModel> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
    String sw_version_number = dataFetchingEnvironment.getArgument("swVersionNumber");
    String hw_version_number = dataFetchingEnvironment.getArgument("hwVersionNumber");
    String spare_part_number = dataFetchingEnvironment.getArgument("sparePartNumber");


    List<EcuModel> EcuModel =
        ecuModelRepository.findBySwVersionNumberAndHwVersionNumberAndSparePartNumber(
            sw_version_number, hw_version_number, spare_part_number);
    return EcuModel;
  }
}
