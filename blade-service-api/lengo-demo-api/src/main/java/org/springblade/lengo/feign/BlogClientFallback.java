package org.springblade.lengo.feign;

import java.time.LocalDateTime;
import org.springblade.core.tool.api.R;
import org.springblade.lengo.entity.Blog;
import org.springframework.stereotype.Component;

/**
 * 在一个分布式系统里，许多依赖不可避免的会调用失败，比如超时、异常等，
 * 如何能够保证在一个依赖出问题的情况下，不会导致整体服务失败，这个就是Hystrix需要做的事情。
 * Hystrix提供了熔断、隔离、Fallback、cache、监控等功能，能够在一个、或多个依赖同时出现问题时保证系统依然可用。
 */
@Component
public class BlogClientFallback implements BlogClient {
	@Override
	public R<Blog> detail(Integer id) {
		Blog blog = new Blog();
		blog.setBlogTitle("Hystrix");
		blog.setBlogContent("Hystrix");
		blog.setBlogDate(LocalDateTime.now());
		return R.data(blog);
	}
}
