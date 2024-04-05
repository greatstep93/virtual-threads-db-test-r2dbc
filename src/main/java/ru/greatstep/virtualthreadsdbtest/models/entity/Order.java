package ru.greatstep.virtualthreadsdbtest.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order", schema = "public")
public class Order {

    @Id
    private Long id;

    private String orderNumber;

    private Long clientId;

}