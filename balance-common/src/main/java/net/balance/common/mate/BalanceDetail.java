package net.balance.common.mate;

import java.util.HashMap;
import java.util.Map;

/**
 * balance 数据载体
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
public class BalanceDetail {

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

	public BalanceDetail() {
	}

	public BalanceDetail(int code, String msg, Map<String, Object> detail) {
		this.code = code;
		this.msg = msg;
		this.detail = detail;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getDetail() {
		return detail;
	}

	public void setDetail(Map<String, Object> detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "BalanceDetail{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", detail=" + detail +
				'}';
	}
}
