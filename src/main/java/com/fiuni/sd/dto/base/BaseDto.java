package com.fiuni.sd.dto.base;

import java.io.Serializable;

public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer _id;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

}
