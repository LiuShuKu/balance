package net.balance.common.system.model;

/**
 * 定义系统状态码
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public enum BalanceCode {

	/**
	 * 未定义Code
	 */
	CodeNull(-1, "code undefined"),

	/**
	 * 一切正常
	 */
	CodeOK(0, "OK"),

	/**
	 * 内部服务器错误
	 */
	CodeInternalError(50, "Internal Error"),

	/**
	 * 数据校验失败
	 */
	CodeValidationFailed(51, "Validation Failed"),

	/**
	 * 数据库操作错误
	 */
	CodeDbOperationError(52, "Database Operation Error"),

	/**
	 * 当前操作的给定参数无效
	 */
	CodeInvalidParameter(53, "Invalid Parameter"),

	/**
	 * 缺少当前操作的参数
	 */
	CodeMissingParameter(54, "Missing Parameter"),

	/**
	 * 该功能不能这样使用
	 */
	CodeInvalidOperation(55, "Invalid Operation"),

	/**
	 * 该配置对当前操作无效
	 */
	CodeInvalidConfiguration(56, "Invalid Configuration"),

	/**
	 * 当前操作缺少配置
	 */
	CodeMissingConfiguration(57, "Missing Configuration"),

	/**
	 * 该操作尚未实施
	 */
	CodeNotImplemented(58, "Not Implemented"),

	/**
	 * 尚不支持该操作
	 */
	CodeNotSupported(59, "Not Supported"),

	/**
	 * 操作失败
	 */
	CodeOperationFailed(60, "Operation Failed"),

	/**
	 * 未经授权
	 */
	CodeNotAuthorized(61, "Not Authorized"),

	/**
	 * 安全原因
	 */
	CodeSecurityReason(62, "Security Reason"),

	/**
	 * 服务器正忙，请稍后再试
	 */
	CodeServerBusy(63, "Server Is Busy"),

	/**
	 * 未知错误
	 */
	CodeUnknown(64, "Unknown Error"),

	/**
	 * 资源不存在
	 */
	CodeNotFound(65, "Not Found"),

	/**
	 * 无效的请求
	 */
	CodeInvalidRequest(66, "Invalid Request"),

	/**
	 * 业务验证失败
	 */
	CodeBusinessValidationFailed(300, "Business Validation Failed"),

	;

	/**
	 * 状态码
	 */
	private int code;


	/**
	 * 响应信息
	 */
	private String msg;


	BalanceCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int code() {
		return code;
	}

	public String msg() {
		return msg;
	}


}
