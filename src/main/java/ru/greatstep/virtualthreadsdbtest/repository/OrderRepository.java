package ru.greatstep.virtualthreadsdbtest.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.greatstep.virtualthreadsdbtest.models.entity.Order;

@Repository
public interface OrderRepository extends R2dbcRepository<Order, Long> {

    @Query("SELECT * FROM orders o WHERE o.client_id = :clientId")
    Flux<Order> findOrdersByClientId(Long clientId);

}
