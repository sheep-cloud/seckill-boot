package cn.colg.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import cn.hutool.core.collection.CollUtil;

/**
 * java配置类
 *
 * @author colg
 */
@Configuration
public class JavaConfig {

	/**
	 * 使用阿里 FastJson 作为JSON MessageConverter <br />
	 * 
	 * <a href="http://www.cnblogs.com/zf29506564/p/6669870.html">fastjson SerializerFeature详解</a>
	 * 
	 * @return
	 */
	@Bean
	public HttpMessageConverters httpMessageConverters() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		// 设置字符集
		converter.setSupportedMediaTypes(CollUtil.newArrayList(MediaType.APPLICATION_JSON_UTF8));
		FastJsonConfig config = new FastJsonConfig();
		// 设置序列化规则
		config.setSerializerFeatures(
				// 日期时间 毫秒 -> "yyyy-MM-dd HH:mm:ss"
				SerializerFeature.WriteDateUseDateFormat,
				// 输出值为null的字段
				SerializerFeature.WriteMapNullValue,
				// String null -> ""
				SerializerFeature.WriteNullStringAsEmpty,
				// List null -> []
				SerializerFeature.WriteNullListAsEmpty,
				// 消除对同一对象循环引用
				SerializerFeature.DisableCircularReferenceDetect
			);
		converter.setFastJsonConfig(config);
		return new HttpMessageConverters(converter);
	}

}
