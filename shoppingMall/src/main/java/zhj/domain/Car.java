package zhj.domain;

import java.io.Serializable;

/**
 * 购物车实体类
 */
public class Car implements Serializable {
    private int uid;
    private int gid;
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
