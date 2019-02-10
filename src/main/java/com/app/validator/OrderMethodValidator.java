package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

public class OrderMethodValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		OrderMethod om=(OrderMethod)target;
		/** for radio buttons*/
		/** checking wether empty or not if empty then throw error msg on ui*/
		if(StringUtils.isEmpty(om.getOrderMode())) {
			e.rejectValue("orderMode", "should select at least one mode");
		}


		/** for text inputs*/
		/** checking text field for non empty and not null data*/
		if(StringUtils.hasText(om.getOrderCode())) {
			e.rejectValue("orderCode", "code shoud be enterd");
		}else if(Pattern.matches("[A-Z]{4-6}", om.getOrderCode())){
			e.rejectValue("orderCode", "code value should be 4-6 chars upper case only ");
		}






	}

}
