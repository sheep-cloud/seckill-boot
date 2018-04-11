package cn.colg.configuration;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import cn.hutool.core.util.CharsetUtil;

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
		// 设置默认字符集
		converter.setDefaultCharset(CharsetUtil.CHARSET_UTF_8);
		FastJsonConfig config = new FastJsonConfig();
		// 设置序列化规则
		config.setSerializerFeatures(
					SerializerFeature.WriteDateUseDateFormat,				// 日期时间	毫秒	->	"yyyy-MM-dd HH:mm:ss"
					SerializerFeature.WriteMapNullValue,					// 输出值为null的字段
					SerializerFeature.WriteNullStringAsEmpty,				// String null	->	""	
					SerializerFeature.WriteNullListAsEmpty,					// List null	->	[]
					SerializerFeature.DisableCircularReferenceDetect		// 消除对同一对象循环引用
				);
		
		converter.setFastJsonConfig(config);
		return new HttpMessageConverters(converter);
	}
	
}
