package com.tech.impli.graphql.springbootgraphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table
public class EcuModel {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  private String gsg_name;
  private String[] diagnostic_addresses;
  private String sg_version_id;
  private int sgv_status_id;

  @JsonProperty("spare_part_number")
  @Column(name = "spare_part_number")
  private String sparePartNumber;

  private String hw_version_id;

  private String ecu_part_number;

  @JsonProperty("hw_version_number")
  @Column(name = "hw_version_number")
  private String hwVersionNumber;

  private String sw_version_id;

  @JsonProperty("sw_version_number")
  @Column(name = "sw_version_number")
  private String swVersionNumber;
}
