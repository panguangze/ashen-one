package com.ashenone.admin.component;
import com.ashenone.common.utils.WebServiceUtils;
import com.ashenone.db.entity.OperationRecord;
import com.ashenone.db.repository.OperationRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Create by panguangze on 2019/11/5
 * 日志切面
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {
    @Autowired
    private OperationRepository operationRepository;
    @Pointcut("@annotation(com.ashenone.admin.component.annotation.ControllerLog)")
    public void controllerAspect() {
    }
    @After("controllerAspect()")
    public void doControllerAfter(JoinPoint joinPoint) {
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //根据反射获取方法
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        //获取方法描述
        String methodDesc = "";
        if (method.isAnnotationPresent(ApiOperation.class)) {
            methodDesc = method.getAnnotation(ApiOperation.class).value();
        }
        //获取ip地址
        String ip = WebServiceUtils.getIpAddress(request);
        //获取方法的参数
        String params = "";
        try {
            params = WebServiceUtils.obj2json( joinPoint.getArgs());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        OperationRecord record = new OperationRecord(method.getName(), methodDesc, ip, params);
        operationRepository.save(record);
    }
}
