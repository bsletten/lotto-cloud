package lotto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MultiPickController {

	private MultiPickerProps props;
	private RestTemplate rest;

	@Autowired
	public MultiPickController(MultiPickerProps props, @LoadBalanced RestTemplate rest) {
		this.props = props;
		this.rest = rest;
	}
	
	@GetMapping("/pick")
	public List<int[]> pick() {
		List<int[]> picks = new ArrayList<>();;
		for(int i = 0; i < props.getTicketCount(); i++) {
			picks.add(rest.getForObject("http://lotto-picker/random", int[].class));
		}
		return picks;
	}
	
}
