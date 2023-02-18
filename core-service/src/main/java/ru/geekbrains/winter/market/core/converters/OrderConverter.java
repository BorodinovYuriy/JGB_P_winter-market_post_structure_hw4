package ru.geekbrains.winter.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.winter.market.api.OrderDto;
import ru.geekbrains.winter.market.core.entities.Order;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {
    private final OrderItemConverter orderItemConverter;

    public OrderDto entityToDto(Order order) {
        // TODO: 14.02.2023 встроить в OrderDto
        return OrderDto.builder()
                .id(order.getId())
                .address(order.getAddress())
                .phone(order.getPhone())
                .totalPrice(order.getTotalPrice())
                .username(order.getUsername())
                .items(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()))
                .build();


//        orderDto.setId(order.getId());
//        orderDto.setAddress(order.getAddress());
//        orderDto.setPhone(order.getPhone());
//        orderDto.setTotalPrice(order.getTotalPrice());
//        orderDto.setUsername(order.getUsername());
//        orderDto.setItems(order.getItems().stream().map(orderItemConverter::entityToDto).collect(Collectors.toList()));
//        return orderDto;
    }
}
