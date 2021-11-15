package org.springblade.lengo.feign;

import org.springblade.common.constant.CommonConstant;
import org.springblade.core.tool.api.R;
import org.springblade.lengo.entity.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Blog Feign
 * Feign是一种声明式、模板化的HTTP客户端。在Spring Cloud中使用Feign,
 * 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验,开发者完全感知不到这是远程方法,
 * 更感知不到这是个HTTP请求。
 * @author Chill
 */
@FeignClient(
	//定义Feign指向的service-id
	value = CommonConstant.APPLICATION_LENGO_NAME
	//定义hystrix配置类
	// fallback = BlogClientFallback.class
)
public interface BlogClient{

	/**
	 * 接口前缀
	 */
	String API_PREFIX = "/api/blog";

	/**
	 * 获取详情
	 *
	 * @param id 主键
	 * @return
	 */
	@GetMapping(API_PREFIX + "/detail")
	R<Blog> detail(@RequestParam("id") Integer id);

}
