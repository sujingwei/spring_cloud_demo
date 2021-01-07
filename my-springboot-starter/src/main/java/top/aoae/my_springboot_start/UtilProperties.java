package top.aoae.my_springboot_start;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 计算当前时间的精度 
 * TODO 这个类用于读取配置文件
 * @author leyao
 *
 */
@ConfigurationProperties(prefix = "util.date") // 根记yml文件配置
public class UtilProperties {
	// 经度
	private Double latitude = 120d;
	// 时区
	private int zone;
	
	private String patternString = "yyyy-MM-dd hh:mm:ss";

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	public String getPatternString() {
		return patternString;
	}

	public void setPatternString(String patternString) {
		this.patternString = patternString;
	}
	
}
