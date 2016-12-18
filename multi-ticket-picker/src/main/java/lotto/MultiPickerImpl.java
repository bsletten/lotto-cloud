package lotto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class MultiPickerImpl implements MultiPicker {

	private MultiPickerProps props;
	private RestTemplate rest;

	@Autowired
	public MultiPickerImpl(MultiPickerProps props, @LoadBalanced RestTemplate rest) {
		this.props = props;
		this.rest = rest;
	}
	
	@Override
	@HystrixCommand(fallbackMethod="defaultPicks")
	public List<int[]> pick() {
		List<int[]> picks = new ArrayList<>();;
		for(int i = 0; i < props.getTicketCount(); i++) {
			picks.add(rest.getForObject("http://lotto-picker/random", int[].class));
		}
		return picks;
	}
	
	public List<int[]> defaultPicks() {
		List<int[]> picks = new ArrayList<>();;
		picks.add(new int[] {1, 2, 3, 4, 5, 6});
		return picks;
	}

}
