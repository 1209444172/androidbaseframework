package com.model;

import java.io.Serializable;



public class LikeUsersBean implements Serializable {

    /**
     * _id : 1482724217
     * uid : 1482481242
     * name : 火星网友
     * avatar : http://cdn36.jinriaozhou.com/2016/avatar/20161223/1482481242585ce4e416393.jpg
     */

//    private String _id;
    private String uid;
    private String name;
    private String avatar;
    private String photo;
    private String nickyname;
    private String vitem = "";

//    public void set_id(String _id) {
//        this._id = _id;
//    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
//
//    public String get_id() {
//        return _id;
//    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNickyname() {
        return nickyname;
    }

    public void setNickyname(String nickyname) {
        this.nickyname = nickyname;
    }

    public String getVitem() {
        return vitem;
    }

    public void setVitem(String vitem) {
        this.vitem = vitem;
    }
}
