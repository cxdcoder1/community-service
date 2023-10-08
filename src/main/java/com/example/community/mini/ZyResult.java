package com.example.community.mini;

import com.example.community.utils.ObjectUtil;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Optional;

/**
 * 响应结果封装
 *
 * @author yangdi
 */
public class ZyResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 承载数据
     */
    private T data;

    /**
     * 返回消息
     */
    private String msg;

    public ZyResult() {

    }

    private ZyResult(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private ZyResult(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private ZyResult(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private ZyResult(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private ZyResult(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.success = ResultCode.SUCCESS.code == code;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable ZyResult<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtil.nullSafeEquals(ResultCode.SUCCESS.code, x.code))
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable ZyResult<?> result) {
        return !ZyResult.isSuccess(result);
    }

    /**
     * 返回ZyResult
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> data(T data) {
        return data(data, Constants.DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 返回ZyResult
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> data(T data, String msg) {
        return data(HttpServletResponse.SC_OK, data, msg);
    }

    /**
     * 返回ZyResult
     *
     * @param code 状态码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> data(int code, T data, String msg) {
        return new ZyResult<>(code, data, data == null ? Constants.DEFAULT_NULL_MESSAGE : msg);
    }

    /**
     * 返回ZyResult
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> success(String msg) {
        return new ZyResult<>(ResultCode.SUCCESS, msg);
    }

    /**
     * 返回ZyResult
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> success(IResultCode resultCode) {
        return new ZyResult<>(resultCode);
    }

    /**
     * 返回ZyResult
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> success(IResultCode resultCode, String msg) {
        return new ZyResult<>(resultCode, msg);
    }

    /**
     * 返回ZyResult
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> fail(String msg) {
        return new ZyResult<>(ResultCode.FAILURE, msg);
    }


    /**
     * 返回ZyResult
     *
     * @param code 状态码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> fail(int code, String msg) {
        return new ZyResult<>(code, null, msg);
    }

    /**
     * 返回ZyResult
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> fail(IResultCode resultCode) {
        return new ZyResult<>(resultCode);
    }

    /**
     * 返回ZyResult
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> ZyResult<T> fail(IResultCode resultCode, String msg) {
        return new ZyResult<>(resultCode, msg);
    }

    /**
     * 返回ZyResult
     *
     * @param flag 成功状态
     * @return R
     */
    public static <T> ZyResult<T> status(boolean flag) {
        return flag ? success(Constants.DEFAULT_SUCCESS_MESSAGE) : fail(Constants.DEFAULT_FAILURE_MESSAGE);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ZyResult{" +
                "code=" + code +
                ", success=" + success +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
