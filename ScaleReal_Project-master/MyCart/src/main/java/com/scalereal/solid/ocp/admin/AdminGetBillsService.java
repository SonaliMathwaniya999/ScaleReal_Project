package com.scalereal.solid.ocp.admin;

import java.util.List;

import com.scalereal.model.BillGenerate;

public interface AdminGetBillsService {
	List<BillGenerate> getBills();
}
