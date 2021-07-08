/**
 * Created by FanZeQiu on 2021/6/21
 */
public class Dog extends Animal implements Language, Action {

    public Dog() {
        super();
        this.language = this;
        this.action = this;
    }

    @Override
    public void speak() {
        System.out.println("wang!");
    }

    @Override
    public void love() {
        System.out.println("摇尾巴");
    }
}
