package zhj.domain;

import java.io.Serializable;

/**
 * 订单实体类
 */
public class Orders implements Serializable {
    private int oid;
    private int uid;
    private int gid;
    private int num;
    private double money;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", num=" + num +
                ", money=" + money +
                '}';
    }
}
