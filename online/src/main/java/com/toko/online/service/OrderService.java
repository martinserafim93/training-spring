package com.toko.online.service;

import com.toko.online.model.entity.Order;
import com.toko.online.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    // field
    @Autowired
    private OrderRepository orderRepository;

    public Order getProductByName(String productName) {
        return orderRepository.getByProductName(productName);
    }
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order, int id) {
        var dataOrder = orderRepository.findById(id);
        if(dataOrder.isPresent()) {
            dataOrder.get().setProductName(order.getProductName());
            dataOrder.get().setNumberOfProduct(order.getNumberOfProduct());
            orderRepository.save(order);
        }
    }

    public void deleteOrder(int id) {
        var dataOrder = orderRepository.findById(id);
        dataOrder.ifPresent(order -> orderRepository.delete(order));
    }
}
