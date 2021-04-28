package me.believeGod.reflect;

/**
 * @author LTJ
 * @version 1.0
 * @date 2021/4/28 10:24
 */
@Agx(describe = "飞行器")
public class  FlyCar extends Vehicle implements FlyAble{
    private Integer height=2000;
    public Integer level=4;

    @Override
    public void fly() {
        System.out.println(" flycar fly"+height);

    }

    private void checkLevel(Boolean enable){
        System.out.println("Level:" + level);
    }
}
