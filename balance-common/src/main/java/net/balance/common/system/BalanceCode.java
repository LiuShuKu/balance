package net.balance.common.system;

import java.util.HashMap;
import java.util.Map;

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
	CodeNull(-1, "code undefined", null),

	/**
	 * 一切正常
	 */
	CodeOK(0, "OK", null),

	/**
	 * 内部服务器错误
	 */
	CodeInternalError(50, "Internal Error", null),

	/**
	 * 数据校验失败
	 */
	CodeValidationFailed(51, "Validation Failed", null),

	/**
	 * 数据库操作错误
	 */
	CodeDbOperationError(52, "Database Operation Error", null),

	/**
	 * 当前操作的给定参数无效
	 */
	CodeInvalidParameter(53, "Invalid Parameter", null),

	/**
	 * 缺少当前操作的参数
	 */
	CodeMissingParameter(54, "Missing Parameter", null),

	/**
	 * 该功能不能这样使用
	 */
	CodeInvalidOperation(55, "Invalid Operation", null),

	/**
	 * 该配置对当前操作无效
	 */
	CodeInvalidConfiguration(56, "Invalid Configuration", null),

	/**
	 * 当前操作缺少配置
	 */
	CodeMissingConfiguration(57, "Missing Configuration", null),

	/**
	 * 该操作尚未实施
	 */
	CodeNotImplemented(58, "Not Implemented", null),

	/**
	 * 尚不支持该操作
	 */
	CodeNotSupported(59, "Not Supported", null),

	/**
	 * 操作失败
	 */
	CodeOperationFailed(60, "Operation Failed", null),

	/**
	 * 未经授权
	 */
	CodeNotAuthorized(61, "Not Authorized", null),

	/**
	 * 安全原因
	 */
	CodeSecurityReason(62, "Security Reason", null),

	/**
	 * 服务器正忙，请稍后再试
	 */
	CodeServerBusy(63, "Server Is Busy", null),

	/**
	 * 未知错误
	 */
	CodeUnknown(64, "Unknown Error", null),

	/**
	 * 资源不存在
	 */
	CodeNotFound(65, "Not Found", null),

	/**
	 * 无效的请求
	 */
	CodeInvalidRequest(66, "Invalid Request", null),

	/**
	 * 业务验证失败
	 */
	CodeBusinessValidationFailed(300, "Business Validation Failed", null),

	;

	/**
	 * 状态码
	 */
	private int code;
	/**
	 * 消息信息
	 */
	private String msg;
	/**
	 * 响应数据
	 */
	private Map<String, Object> detail = new HashMap<>(16);

	BalanceCode(int code, String msg, Map<String, Object> detail) {
		this.code = code;
		this.msg = msg;
		this.detail = detail;
	}

	public int code() {
		return code;
	}

	public String msg() {
		return msg;
	}

	public Map<String, Object> detail() {
		return detail;
	}
}
