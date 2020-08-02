package controller;

import domain.SysLog;
import service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime; //��ʼʱ��
    private Class clazz; //���ʵ���
    private Method method;//���ʵķ���

    //ǰ��֪ͨ  ��Ҫ�ǻ�ȡ��ʼʱ�䣬ִ�е�������һ����ִ�е�����һ������
    @Before("execution(* controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();//��ǰʱ����ǿ�ʼ���ʵ�ʱ��
        clazz = jp.getTarget().getClass(); //����Ҫ���ʵ���
        String methodName = jp.getSignature().getName(); //��ȡ���ʵķ���������
        Object[] args = jp.getArgs();//��ȡ���ʵķ����Ĳ���

        //��ȡ����ִ�еķ�����Method����
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); //ֻ�ܻ�ȡ�޲����ķ���
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, classArgs);
        }
    }

    //����֪ͨ
    @After("execution(* controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime(); //��ȡ���ʵ�ʱ��

        String url = "";
        //��ȡurl
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.��ȡ���ϵ�@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.��ȡ�����ϵ�@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //��ȡ���ʵ�ip
                    String ip = request.getRemoteAddr();

                    //��ȡ��ǰ�������û�
                    SecurityContext context = SecurityContextHolder.getContext();//���������л��˵�ǰ��¼���û�
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //����־�����Ϣ��װ��SysLog����
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time); //ִ��ʱ��
                    sysLog.setIp(ip);
                    sysLog.setMethod("[����] " + clazz.getName() + "[������] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //����Service��ɲ���
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}
