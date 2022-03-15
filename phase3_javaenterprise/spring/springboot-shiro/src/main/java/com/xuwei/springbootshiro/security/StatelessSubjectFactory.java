package com.xuwei.springbootshiro.security;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**
 * @Description 设置不创建session
 * @Date 2022/2/28 11:24
 * @Author yxw
 */
public class StatelessSubjectFactory extends DefaultWebSubjectFactory {
    @Override
    public Subject createSubject(SubjectContext context) {
        // 不创建 session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
