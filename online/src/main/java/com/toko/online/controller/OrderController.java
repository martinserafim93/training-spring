package com.toko.online.controller;

import com.toko.online.model.entity.Order;
import com.toko.online.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    // field
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/order-by-name")
    public ResponseEntity<Order> getProductByName(@RequestParam("productName") String productName) {
        return ResponseEntity.ok(orderService.getProductByName(productName));
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> listOrder() {
        var orders = orderService.getOrder();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/order")
    public String saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return "Data berhasil disimpan!";
    }

    @PutMapping("/order")
    public String updateOrder(@RequestParam int id, @RequestBody Order order) {
        orderService.updateOrder(order, id);
        return "Data berhasil diupdate!";
    }

    @DeleteMapping("/order")
    public String deleteOrder(@RequestParam int id) {
        orderService.deleteOrder(id);
        return "Data berhasil dihapus";
    }
}
