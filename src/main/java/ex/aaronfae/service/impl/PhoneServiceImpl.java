package ex.aaronfae.service.impl;

import java.util.HashMap;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import ex.aaronfae.entity.Phone;

@Service
public class PhoneServiceImpl {

	private HashMap<Integer, Phone> map = new HashMap<Integer, Phone>();

	@CacheEvict(value = "phones", key = "'phone_'+#result")
	public Integer savePhone(String name) {
		map.put(1, new Phone(1, name));
		return 1;
	}

	@Cacheable(value = "phones", key = "'phone_'+#index")
	public Phone getPhone(Integer index) {
		System.out.println("Phone from service.");
		return map.get(index);
	}

}
