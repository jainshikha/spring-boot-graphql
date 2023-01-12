package com.tech.impli.graphql.springbootgraphql.repos;

import com.tech.impli.graphql.springbootgraphql.model.EcuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EcuModelRepository extends JpaRepository<EcuModel, String> {

  List<EcuModel> findBySwVersionNumberAndHwVersionNumberAndSparePartNumber(
      String swVersionNumber, String sw_version_number, String hw_version_number);
}
