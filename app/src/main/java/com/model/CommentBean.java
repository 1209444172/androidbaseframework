package com.model;

import com.interfaces._IdInterface;

import java.io.Serializable;
import java.util.List;

public class CommentBean implements Serializable, _IdInterface {

    @Override
    public String get_iid() {
        return get_id();
    }

    @Override
    public String get_iChanged() {
        return getChanged();
    }

    /**
     * _id : 1481519176
     * nid : 1508044
     * uid : 6
     * pid : 0
     * cid : 0
     * changed : 1481519176
     * status : 1
     * rpnums : 21
     * commlike : 6
     * subject : Nicole 悉尼 英文
     * addr : 位置 : Sydney,国家 : Australia,区 : Darling Harbour,省 : NSW,省 : NSW
     * device : iPhone9,3
     * name : Qson
     * avatar : http://cdn36.jinriaozhou.com/2016/avatar/20161213/658500d908633d.jpg
     * chlids : [{"_id":1482395910,"uid":1482226157,"pid":1481519176,"cid":1481519176,"created":1482395910,"commlike":0,"subject":"是个认同和日韩等国的郭德纲","name":"15900672948","avatar":"http://cdn36.jinriaozhou.com/2016/avatar/20161220/148222615758590046ed66f.jpg","islike":0}]
     */

    private String _id;
    private String nid;
    private String uid;
    private String pid;
    private String cid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    private String changed;
    private String status;
    private String rpnums;
    private String commlike;
    private String subject;
    private String addr;
    private String device;
    private String name;
    private String avatar;
    private List<ChlidsEntity> chlids;
    private String pushLikeContent;
    private List<LikeUsersBean> users;
    private boolean isLike = false;
    private String vitem = "";
    private String ispost = "";
    private String istop="";

    @Override
    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    private String source_name;

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRpnums(String rpnums) {
        this.rpnums = rpnums;
    }

    public void setCommlike(String commlike) {
        this.commlike = commlike;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setChlids(List<ChlidsEntity> chlids) {
        this.chlids = chlids;
    }

    public String get_id() {
        return _id;
    }

    public String getNid() {
        return nid;
    }

    public String getUid() {
        return uid;
    }

    public String getPid() {
        return pid;
    }

    public String getChanged() {
        return changed;
    }

    public String getStatus() {
        return status;
    }

    public String getRpnums() {
        return rpnums;
    }

    public String getCommlike() {
        return commlike;
    }

    public String getSubject() {
        return subject;
    }

    public String getAddr() {
        return addr;
    }

    public String getDevice() {
        return device;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<ChlidsEntity> getChlids() {
        return chlids;
    }

    public String getPushLikeContent() {
        return pushLikeContent;
    }

    public void setPushLikeContent(String pushLikeContent) {
        this.pushLikeContent = pushLikeContent;
    }

    public static class ChlidsEntity {
        /**
         * _id : 1482395910
         * uid : 1482226157
         * pid : 1481519176
         * cid : 1481519176
         * created : 1482395910
         * commlike : 0
         * subject : 是个认同和日韩等国的郭德纲
         * name : 15900672948
         * vitem : 1497337445
         * avatar : http://cdn36.jinriaozhou.com/2016/avatar/20161220/148222615758590046ed66f.jpg
         * islike : 0
         */

        private String _id;
        private String uid;
        private String pid;
        private String cid;
        private String created;
        private String commlike;
        private String subject;
        private String name;
        private String vitem;

        public String getVitem() {
            return vitem;
        }

        public void setVitem(String vitem) {
            this.vitem = vitem;
        }

        private String avatar;
        private String islike;
        private String ispost = "";

        public void set_id(String _id) {
            this._id = _id;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public void setCommlike(String commlike) {
            this.commlike = commlike;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setIslike(String islike) {
            this.islike = islike;
        }

        public String get_id() {
            return _id;
        }

        public String getUid() {
            return uid;
        }

        public String getPid() {
            return pid;
        }

        public String getCid() {
            return cid;
        }

        public String getCreated() {
            return created;
        }

        public String getCommlike() {
            return commlike;
        }

        public String getSubject() {
            return subject;
        }

        public String getName() {
            return name;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getIslike() {
            return islike;
        }

        public String getIspost() {
            return ispost;
        }

        public void setIspost(String ispost) {
            this.ispost = ispost;
        }
    }

    public String getShowtype() {
        return "0";
    }

    public String getTitle() {
        return getName();
    }

    public List<String> getPhoto() {
        return null;
    }

    public List<LikeUsersBean> getUsers() {
        return users;
    }

    public void setUsers(List<LikeUsersBean> users) {
        this.users = users;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public String getVitem() {
        return vitem;
    }

    public void setVitem(String vitem) {
        this.vitem = vitem;
    }

    public String getIspost() {
        return ispost;
    }

    public void setIspost(String ispost) {
        this.ispost = ispost;
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }
}
