package com.aifule.jxc.site.aop;

import com.aifule.jxc.core.exception.AmountExp;
import com.aifule.jxc.site.common.util.AsmReflexUtil;
import com.aifule.jxc.site.web.WebController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * 监控controller接口的运行时间
 * <功能详细描述>
 *
 * @author libiao
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Aspect
@Component
public class ControllerMonitor {
    private static final Logger logger = LoggerFactory.getLogger("ControllerMonitor");

    public class ReqParamResult {
        private String argsLogFormat;
        private String validErrMsg;

        public String getArgsLogFormat() {
            return argsLogFormat;
        }

        public void setArgsLogFormat(String argsLogFormat) {
            this.argsLogFormat = argsLogFormat;
        }

        public String getValidErrMsg() {
            return validErrMsg;
        }

        public void setValidErrMsg(String validErrMsg) {
            this.validErrMsg = validErrMsg;
        }
    }

    /**
     * 监控com.ruanwang.dushuwang.web.controller包及其子包的所有public方法
     * <功能详细描述>com.ruanwang.dushuwang.web.controller..*.*(..))
     *
     * @see [类、类#方法、类#成员]
     */
    @Pointcut("execution(* com.aifule.jxc.site.web.controller..*.*(..))" +
            "")
    private void pointCutMethod() {
    }

    //声明环绕通知
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        WebController web = (WebController) pjp.getThis();
        String pathName = pjp.getSignature().getName();
        String classMethodName = pjp.getTarget().getClass() + "." + pathName;
        Object[] args = pjp.getArgs();
        ReqParamResult reqParamResult = getReqParamResult(pjp, args);
        if (reqParamResult.getValidErrMsg() != null) {
            return web.getFailResultMap(reqParamResult.getValidErrMsg());
        }
        logger.info(classMethodName + reqParamResult.getArgsLogFormat(), args);

        long begin = System.currentTimeMillis();
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable throwable) {
            if (throwable instanceof AmountExp) {
                o = web.getAmountLessResultMap(throwable.getMessage());
            } else {
                logger.error(throwable.getMessage(), throwable);
                o = web.getFailResultMap(throwable.getMessage());
            }
        }
        long end = System.currentTimeMillis();
        long duration_ms = end - begin;
        logger.info("methodName {}:{}ms", classMethodName, duration_ms);
        return o;
    }


    private ReqParamResult getReqParamResult(ProceedingJoinPoint pjp, Object[] args) {
        ReqParamResult reqParamResult = new ReqParamResult();
        if (args == null) {
            return reqParamResult;
        }

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Object target = pjp.getTarget();
        String[] argNames = AsmReflexUtil.getMethodParameterNamesByAsm4(target.getClass(), method);

        String logFormat = new String();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpServletRequest) {
                Integer userId = WebController.getSessionUid((HttpServletRequest) args[i]);
                logFormat += " ,sessionUid:{}";
                args[i] = userId;
            } else if (args[i] instanceof BindingResult) {
                BindingResult result = (BindingResult) args[i];
                for (ObjectError error : result.getAllErrors()) {
                    reqParamResult.setValidErrMsg(error.getDefaultMessage());
                    break;
                }
            } else {
                logFormat += " ," + argNames[i] + ":{}";
            }
        }
        reqParamResult.setArgsLogFormat(logFormat);
        return reqParamResult;
    }
}