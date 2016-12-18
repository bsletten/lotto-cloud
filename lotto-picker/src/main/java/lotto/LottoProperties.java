package lotto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="lotto")
public class LottoProperties {

	private int pickCount;
	private int maxNumber;
	
	public int getPickCount() {
		return pickCount;
	}
	
	public void setPickCount(int pickCount) {
		this.pickCount = pickCount;
	}
	
	public int getMaxNumber() {
		return maxNumber;
	}
	
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
}
