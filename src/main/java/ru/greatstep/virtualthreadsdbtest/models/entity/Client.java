package ru.greatstep.virtualthreadsdbtest.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "client",schema = "public")
public class Client {

    @Id
    private Long id;

    private String fullName;

    private String clientCode;

}