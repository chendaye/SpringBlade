package org.springblade.lengo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 日志实体类
 * POJO / VO / DTO等等是会被其他模块依赖引用的，所以我们需要把实体类建在blade-demo-api工程内。
 */
@Data
@TableName("blade_blog") // mybatis-plus的注解
public class Blog implements Serializable {
	/**
	 * 一般实体类都需要用到缓存、序列化等，所以需要事先序列化接口
	 */
	private static final long serialVersionUID = 2655043435773140483L;

	private Integer id;

	private String blogTitle;

	private String blogContent;

	private LocalDateTime blogDate;

	private Integer isDeleted;
}
