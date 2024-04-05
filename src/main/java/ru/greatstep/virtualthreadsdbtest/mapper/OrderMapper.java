package ru.greatstep.virtualthreadsdbtest.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import ru.greatstep.virtualthreadsdbtest.models.dto.Response;
import ru.greatstep.virtualthreadsdbtest.models.entity.Order;

@Component
public class OrderMapper {

    public Response toResponse(String clientName, List<Order> orders) {
        return new Response(clientName, orders.stream().map(Order::getOrderNumber).toList());
    }

}
