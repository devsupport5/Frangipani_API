package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.model.OrderItems;
import com.ui.spring.springboot2jpacrudexample.service.OrderItemService;

@CrossOrigin
@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailsController {

	@Autowired
	OrderItemService orderService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/orderdetail/{id}")
	public List<OrderItems> getAllOrder(@PathVariable(value = "id") Long id) {
		List<OrderItems> orderdetail = orderService.getUserOrderItemsHistory(id);
		return orderdetail;
	}

	/*@GetMapping("/orderdetail/{id}")
	public ResponseEntity<OrderItems> getOrderById(@PathVariable(value = "id") Long orderDTO) {
		Order order = orderService.getOrderById(orderDTO).get();
		return ResponseEntity.ok().body(convertToDto(order));
	}*/ 
	/*
	@GetMapping("/getUserOrdersHistory/{userId}")
	public List<OrderDTO> getUserOrdersHistory(@PathVariable(value = "userId") Long orderDTO) {
		List<Order> orders = orderService.getUserOrdersHistory(orderDTO);
		return orders.stream().map(this::convertToDto).collect(Collectors.toList());
	} */

/*	@PostMapping("/order")
	public Order createSlider(@Valid @RequestBody OrderDTO orderDTO) {
		return orderService.createOrder(convertToEntity(orderDTO));
	}*/

/*	@PutMapping("/sliders/{id}")
	public ResponseEntity<Slider> updateSlider(@PathVariable(value = "id") Long sliderId,
			@Valid @RequestBody Slider SliderDetails) throws ResourceNotFoundException {
		Slider Slider = SliderService.getSliderById(sliderId)
				.orElseThrow(() -> new ResourceNotFoundException("Slider not found for this id :: " + sliderId));

		Slider.setId(SliderDetails.getId());
		Slider.setSliderName(SliderDetails.getSliderName());
		Slider.setDescription(SliderDetails.getDescription());
		Slider.setIsActive(SliderDetails.getIsActive());
		final Slider updatedSlider = SliderService.updateSlider(SliderDetails);
		return ResponseEntity.ok(updatedSlider);
	}

	@DeleteMapping("/sliders/{id}")
	public Map<String, Boolean> deleteSlider(@PathVariable(value = "id") Long sliderId)
			throws ResourceNotFoundException {
		Slider Slider = SliderService.getSliderById(sliderId)
				.orElseThrow(() -> new ResourceNotFoundException("Slider not found for this id :: " + sliderId));

		SliderService.deleteSlider(Slider);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	*/
	/*public OrderDTO convertToDto(Order order) {
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}
	
	public Order  convertToEntity(OrderDTO orderDTO) {
		Order order = modelMapper.map(orderDTO, Order.class);
		return order;
	}*/
	
	 
}
