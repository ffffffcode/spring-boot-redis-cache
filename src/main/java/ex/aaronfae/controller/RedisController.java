package ex.aaronfae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.aaronfae.entity.Phone;
import ex.aaronfae.service.impl.PhoneServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/redis")
@Api(tags = "Redis API 测试")
public class RedisController {

	@Autowired
	private PhoneServiceImpl phoneService;

	@Autowired
	private StringRedisTemplate redisTemplate;

	@PostMapping("set/{key}/{value}")
	@ApiOperation(value = "设置缓存")
	public String set(@PathVariable String key, @PathVariable String value) {
		redisTemplate.opsForValue().set(key, value);
		return "set " + key + " " + value;
	}

	@GetMapping("get/{key}")
	@ApiOperation(value = "根据key获取缓存")
	public String get(@PathVariable String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@PostMapping("phones")
	@ApiOperation(value = "保存Phone")
	public Integer savePhone(String name) {
		return phoneService.savePhone(name);
	}

	@GetMapping("phones")
	@ApiOperation(value = "查询Phone")
	public Phone getPhone(Integer index) {
		return phoneService.getPhone(index);
	}

}
