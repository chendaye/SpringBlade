package org.springblade.lengo.feign;

import org.springblade.lengo.entity.Blog;
import org.springblade.lengo.service.BlogService;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 就是 SpringMvc的Controller
 * 因为Feign本质上是HTTP客户端，所以我们创建的BlogClientImpl其实就是SpringMVC的Controller，
 * 所以需要加上@RestController注解
 */
@RestController
// @AllArgsConstructor
public class BlogClientImpl implements BlogClient{
	@Autowired
	private BlogService service;


	/**
	 * 获取详情
	 * 该类相当于一个Controller， 调用 service 处理业务
	 * @param id 主键
	 * @return
	 */
	@Override
	@GetMapping(API_PREFIX + "/detail")
	public R<Blog> detail(Integer id) {
		/*模拟服务间调用异常*/
		// int cnt = 100 / 0;
		return R.data(service.getById(id));
	}
}
