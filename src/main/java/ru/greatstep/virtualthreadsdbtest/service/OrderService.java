package ru.greatstep.virtualthreadsdbtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.greatstep.virtualthreadsdbtest.mapper.OrderMapper;
import ru.greatstep.virtualthreadsdbtest.models.dto.Response;
import ru.greatstep.virtualthreadsdbtest.repository.ClientRepository;
import ru.greatstep.virtualthreadsdbtest.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderMapper orderMapper;

    public Mono<Response> findOrders(String clientCode) {
        return clientRepository.findClientByClientCode(clientCode)
                .zipWhen(client -> orderRepository.findOrdersByClientId(client.getId()).collectList())
                .flatMap(tuple2 -> Mono.just(orderMapper.toResponse(clientCode, tuple2.getT2())));
    }

}
