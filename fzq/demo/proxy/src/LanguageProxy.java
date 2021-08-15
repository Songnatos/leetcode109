import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LanguageProxy implements InvocationHandler {
    private Object target;
    public LanguageProxy() {
    }
    public LanguageProxy(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始说话");
        Object result = method.invoke(target, args);
        System.out.println("说话结束");
        return result;
    }
}
