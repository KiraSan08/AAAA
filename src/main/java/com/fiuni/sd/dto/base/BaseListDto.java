package com.fiuni.sd.dto.base;

import java.util.List;
import java.io.Serializable;

public abstract class BaseListDto<DTO extends BaseDto> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DTO> _dtos;
	private Integer _total;
	private Integer _page;
	private Integer _totalPages;
	private Boolean _hasNext;
	private Boolean _hasPrev;

	protected List<DTO> getList() {
		return _dtos;
	}

	protected void setList(final List<DTO> dtos) {
		_dtos = dtos;
	}

	public Integer getTotal() {
		return _total;
	}
	
	public void setTotal(Integer total) {
		_total = total;
	}

	public Integer getTotalPages() {
		return _totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		_totalPages = totalPages;
	}

	public Integer getPage() {
		return _page;
	}

	public void setPage(Integer page) {
		_page = page;
	}

	public Boolean get_hasNext() {
		return _hasNext;
	}

	public void set_hasNext(Boolean _hasNext) {
		this._hasNext = _hasNext;
	}

	public Boolean get_hasPrev() {
		return _hasPrev;
	}

	public void set_hasPrev(Boolean _hasPrev) {
		this._hasPrev = _hasPrev;
	}
	
	public Integer getNextPage() {
		return _hasNext?_page+1:_page;
	}

	public Integer getPrevPage() {
		return _hasPrev?_page-1:_page;
	}

}