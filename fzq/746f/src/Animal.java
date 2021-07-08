/**
 * Created by FanZeQiu on 2021/6/21
 */
public class Animal {

    protected Language language;
    protected Action action;

    public void hello() {
        System.out.println("开始说话");
        language.speak();
        System.out.println("说话结束\n");
    }

    public void doSomething() {
        System.out.println("开始动作");
        action.love();
        System.out.println("动作结束\n");
    }
}
