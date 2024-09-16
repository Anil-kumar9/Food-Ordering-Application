package com.OrderService.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {

	@Id
	private int id;
	private int userId;
	private double totalPrice;
	@CreationTimestamp
	private LocalDateTime createdAt;
}
