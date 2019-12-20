package jxnu.chisha.test;

import javax.persistence.*;

/**
 * @program: chisha
 * @ClassName StoreDomain
 * @description: TODO
 * @author: zy
 * @create: 2019-12-11 09:08
 * @Version 1.0
 **/
@Entity
@Table(name = "store", schema = "chisha", catalog = "")
public class StoreDomain {
    private int storeNo;
    private String storeOwner;
    private String storeAddr;
    private String storeTel;

    @Id
    @Column(name = "store_no")
    public int getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(int storeNo) {
        this.storeNo = storeNo;
    }

    @Basic
    @Column(name = "store_owner")
    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    @Basic
    @Column(name = "store_addr")
    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }

    @Basic
    @Column(name = "store_tel")
    public String getStoreTel() {
        return storeTel;
    }

    public void setStoreTel(String storeTel) {
        this.storeTel = storeTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StoreDomain that = (StoreDomain) o;

        if (storeNo != that.storeNo) return false;
        if (storeOwner != null ? !storeOwner.equals(that.storeOwner) : that.storeOwner != null) return false;
        if (storeAddr != null ? !storeAddr.equals(that.storeAddr) : that.storeAddr != null) return false;
        if (storeTel != null ? !storeTel.equals(that.storeTel) : that.storeTel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeNo;
        result = 31 * result + (storeOwner != null ? storeOwner.hashCode() : 0);
        result = 31 * result + (storeAddr != null ? storeAddr.hashCode() : 0);
        result = 31 * result + (storeTel != null ? storeTel.hashCode() : 0);
        return result;
    }
}
