package com.company.hrm.common;

public class ErrMsg {
	public static interface userErr{
		String LOGIN_ERROR = "登录失败!";
		String DUPLICATE_USERNAME = "注册失败!用户名重复!";
		String REGIST_EMPTY_ERROR = "注册失败!请检查是否有未输入项!";
		String REGIST_PASSWORD_ERROR = "密码输入不一致,请检查!";
		String REGIST_ERROR = "注册失败!请检查输入项!";
	}
	public static interface empErr{
		String NO_PRIORITY = "无查看权限,请重新登录!";
		String FINDALL_ERROR = "未知错误或列表为空!";
		String SAVE_ERROR = "新建员工失败";
		String DELETE_ERROR = "删除员工失败";
		String FIND_BY_ID_ERROR = "查找员工ID失败!";
		String UPDATE_ERROR = "更新失败";
		String FIND_BY_NAME_ERROR = "查找员工姓名失败!";
		
	}
	public static interface deptErr{
		
	}
}
