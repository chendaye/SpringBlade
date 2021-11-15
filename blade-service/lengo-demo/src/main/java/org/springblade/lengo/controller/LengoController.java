package org.springblade.lengo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.lengo.entity.Blog;
import org.springblade.lengo.service.BlogService;
import java.util.List;
import java.util.Map;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class LengoController {

	@Autowired
	private BlogService service;

	@GetMapping("/info2")
	public String info(String name){
		return "Hello, My Name is " + name;
	}

	/**
	 * 新增
	 * mybatis-plus 已经内置了基本的增删改查
	 * @param blog
	 * @return
	 */
	@PostMapping("/save")
	public R save(@RequestBody Blog blog){
		return R.status(service.save(blog));
	}

	/**
	 * 修改
	 * @param blog
	 * @return
	 */
	@PostMapping("/update")
	public R update(@RequestBody Blog blog){
		return R.status(service.updateById(blog));
	}

	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@PostMapping("/remove")
	public R remove(@RequestParam String ids){
		return R.status(service.removeByIds(Func.toIntList(ids)));
	}

	/**
	 * 获取单条记录
	 * @param id
	 * @return
	 */
	@GetMapping("/detail")
	public R<Blog> detail(Integer id){
		Blog detail = service.getById(id);
		return R.data(detail);
	}

	/**
	 * 查询多条记录
	 * @return
	 */
	@GetMapping("/list")
	public R<List<Blog>> list(){
		List<Blog> list = service.list();
		return R.data(list);
	}

	/**
	 * 分页
	 */
	@GetMapping("/page")
	public R<IPage<Blog>> page(@ApiIgnore @RequestParam Map<String, Object> blog, Query query) {
		IPage<Blog> pages = service.page(Condition.getPage(query), Condition.getQueryWrapper(blog, Blog.class));
		return R.data(pages);
	}
}
