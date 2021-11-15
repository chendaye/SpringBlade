package org.springblade.lengo.config;

import org.springblade.lengo.feign.BlogClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign 失败配置
 */
@Configuration
public class BlogFeignConfiguration {
	@Bean
	public BlogClientFallback blogClientFallback(){
		return new BlogClientFallback();
	}
}
