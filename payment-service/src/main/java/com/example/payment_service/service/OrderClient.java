package com.example.payment_service.service;

import com.example.payment_service.dto.OrderStatusUpdateRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Order;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Component
public class OrderClient {

    private final RestTemplate restTemplate;

    public OrderClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void updateOrderStatus(String orderId, String status) {
        String url = "http://localhost:8082/orders/" + orderId + "/status?status=" + status;

        log.info("Updating order status. OrderId={}, NewStatus={}, URL={}", orderId, status, url);

        try {
            OrderStatusUpdateRequestDto requestDto = new OrderStatusUpdateRequestDto();
            restTemplate.patchForObject(url, requestDto, String.class);

            log.info("Order status updated successfully. OrderId={}, Status={}", orderId, status);

        } catch (HttpStatusCodeException ex) {
            // Handles HTTP 4xx / 5xx responses
            log.error("HTTP error while updating order status. OrderId={}, Status={}, HTTPStatus={}, ResponseBody={}",
                    orderId, status, ex.getStatusCode(), ex.getResponseBodyAsString(), ex);

        } catch (ResourceAccessException ex) {
            // Handles connection timeouts, refused connections, etc.
            log.error("Connection error while accessing Order Service at {}. OrderId={}, Status={}",
                    url, orderId, status, ex);

        } catch (Exception ex) {
            // Catch-all for unexpected errors
            log.error("Unexpected error occurred while updating order status. OrderId={}, Status={}",
                    orderId, status, ex);
        }
    }
}
