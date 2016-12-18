package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoPickerImpl implements LottoPicker {

	private LottoProperties props;

	@Autowired
	public LottoPickerImpl(LottoProperties props) {
		this.props = props;
	}
	
	@Override
	public int[] pick() {
		List<Integer> allNumbers = new ArrayList<>();
		for(int i = 1; i <= props.getMaxNumber(); i++) {
			allNumbers.add(i);
		}
		Collections.shuffle(allNumbers);
		
		int[] picks = new int[props.getPickCount()];
		for (int i = 0; i < props.getPickCount(); i++) {
			picks[i] = allNumbers.get(i);
		}
		return picks;
	}
	
}
