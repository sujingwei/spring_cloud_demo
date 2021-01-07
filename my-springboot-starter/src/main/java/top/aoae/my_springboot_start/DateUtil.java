package top.aoae.my_springboot_start;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;

public class DateUtil {
	
	@Autowired
	private UtilProperties utilProperties;
	
	public String getLocalTime() {
		int zone = 0;
		if (utilProperties.getLatitude() != null) {
			// 计算出时区
			zone = (int)Math.round((utilProperties.getLatitude() * DateTimeConstants.HOURS_PER_DAY) / 360);
		}
		DateTimeZone dZone = DateTimeZone.forOffsetHours(zone);
		return new DateTime(dZone).toString(utilProperties.getPatternString());
	}

}
