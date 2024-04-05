package ru.greatstep.virtualthreadsdbtest.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.greatstep.virtualthreadsdbtest.models.entity.Client;

@Repository
public interface ClientRepository extends R2dbcRepository<Client, Long> {

    Mono<Client> findClientByClientCode(String clientCode);

}
