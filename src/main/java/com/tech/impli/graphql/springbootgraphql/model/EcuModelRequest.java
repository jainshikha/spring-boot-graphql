package com.tech.impli.graphql.springbootgraphql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table
@JsonIgnoreProperties(value = { "id"})
        public class EcuModelRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private EcuModel[] ecu_models;

}
