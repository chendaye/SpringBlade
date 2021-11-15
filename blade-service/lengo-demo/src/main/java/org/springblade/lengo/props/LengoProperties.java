package org.springblade.lengo.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * DemoProperties
 *
 * @author Chill
 */
@Data
@ConfigurationProperties(prefix = "demo")
public class LengoProperties {
	/**
	 * 名称
	 */
	private String name;
}
