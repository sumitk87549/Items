package com.inventory.mini.demo.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.mini.demo.JwtUtils;
import com.inventory.mini.demo.MyUserDetailsService;
import com.inventory.mini.demo.auth.AuthenticationRequest;
import com.inventory.mini.demo.auth.AuthenticationResponse;
import com.inventory.mini.demo.entity.Item;
import com.inventory.mini.demo.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtils jwtTokenUtils;

	private ItemService itemService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Incorrect Username or Password");
			// TODO: handle exception
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtils.generateToken(authenticationRequest.getUsername());

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@Autowired
	public ItemRestController(ItemService theItemdao) {
		itemService = theItemdao;
	}

	@RequestMapping("/user")
	public Principal User(Principal principal) {
		return principal;
	}

	@GetMapping("/items")
	public List<Item> findAll() {
		return itemService.findAll();
	}

	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable int itemId) {
		Item item = itemService.findById(itemId);

		if (item == null) {
			throw new RuntimeException("Item id not found - " + itemId);
		}

		return item;
	}

	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {

		item.setId(0);

		itemService.save(item);

		return item;
	}

	@PutMapping("/items")
	public Item updateItem(@RequestBody Item item) {

		itemService.save(item);

		return item;
	}

	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable int itemId) {

		Item item = itemService.findById(itemId);

		if (item == null) {
			throw new RuntimeException("Item id not found - " + itemId);
		}

		itemService.deleteById(itemId);

		return "Deleted Successfully";
	}

}
