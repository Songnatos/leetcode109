/**
 * Created by FanZeQiu on 2021/6/21
 */
public class Cat extends Animal implements Language, Action {

    public Cat() {
        super();
        this.language = this;
        this.action = this;
    }

    @Override
    public void speak() {
        System.out.println("miao!");
    }

    @Override
    public void love() {
        System.out.println("舔主人");
    }
}
