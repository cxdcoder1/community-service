package com.example.community.log;

import com.alibaba.fastjson.JSON;
import com.example.community.entity.SysOperLog;
import com.example.community.entity.SysUser;
import com.example.community.log.utils.IpAdrressUtil;
import com.example.community.log.utils.LogUtil;
import com.example.community.log.utils.ServletUtils;
import com.example.community.service.SysOperLogService;
import com.example.community.utils.JwtUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.tomcat.jni.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author shafei
 * @version 1.0
 * @date 10:08 2019/9/7
 * fun:
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysOperLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.example.community.log.Log)")
    public void logPoinCut() {

    }

    //切面 配置通知
    @AfterReturning(value ="logPoinCut()" ,returning = "returning")
    public void saveSysLog(JoinPoint joinPoint,Object returning) throws Throwable {
        //保存日志
        SysOperLog sysLog = new SysOperLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

         //获取操作
        Log myLog = method.getAnnotation(Log.class);
        if (myLog != null) {
            String value = myLog.title();
            BusinessType businessType = myLog.businessType();
            //获取操作模块
            sysLog.setTitle(value);
            //获取操作类型
            sysLog.setBusinessType(businessType.getKey());
        }
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();

        //获取请求的操作方法名
        String methodName = method.getName();
        sysLog.setMethod(className+"."+methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();

        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        sysLog.setOperParam(params);


        //方法的请求方式
        HttpServletRequest request = ServletUtils.getRequest();
        String requestMethod = request.getMethod();
        sysLog.setRequestMethod(requestMethod);


        //请求的时间
        sysLog.setOperTime(new Date());


        //请求方法的url
        String requestURI = request.getRequestURI();
        sysLog.setOperUrl(requestURI);




        //获取执行方法后的返回参数
        sysLog.setJsonResult(returning.toString());

        //判断执行方法是否成功
        String returnings=JSON.toJSONString(returning);
        ObjectMapper mapper = new ObjectMapper();
        // 将 JSON 字符串解析为一个 JsonNode 对象
        JsonNode jsonNode = mapper.readTree(returnings);
        // 获取 status 键对应的值
        int status = jsonNode.get("status").asInt();
        if (status!=200){
            sysLog.setStatus(1);
        }

        //获取用户名
        String authHeader = request.getHeader("Authorization");
        Claims claims = JwtUtil.parseJWT(authHeader);
        Object sub = claims.get("sub");
        JsonNode jsonNodes = mapper.readTree(sub.toString());
        String userName=jsonNodes.get("userName").asText();
        sysLog.setOperName(userName);


        //获取用户ip地址
        HttpServletRequest a = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        sysLog.setOperIp(LogUtil.getLocalIP());
        boolean internalIp = IpAdrressUtil.isInternalIp(LogUtil.getLocalIP());
        //判断当前ip是否是外网ip
        if (internalIp){
            sysLog.setOperLocation("内网ip");
        }else {
            sysLog.setOperLocation("外网ip");
        }

        //调用service保存SysLog实体类到数据库
        sysLogService.insert(sysLog);
    }

}
