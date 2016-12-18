package lotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LottoPickerController {

	private LottoPicker picker;

	@Autowired
	public LottoPickerController(LottoPicker picker) {
		this.picker = picker;
	}
	
	@GetMapping("/random")
	public int[] random() {
		return picker.pick();
	}
	
}
