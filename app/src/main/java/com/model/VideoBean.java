package com.model;

import com.interfaces._IdInterface;

import java.io.Serializable;
import java.util.List;


public class VideoBean implements Serializable, _IdInterface {
    @Override
    public String get_iid() {
        return get_id();
    }

    @Override
    public String get_iChanged() {
        return getChanged();
    }

    /**
     * _id : 231499391876128
     * title : 你笑了算你输，没笑算我输！
     * photo : ["http://47.92.35.152:18080/image/2017-06-05/14966699790541923056339253147001.jpg"]
     * videourl : http://v6.365yg.com/video/m/114678a00001d2f6e4f193522009ec6a2dc493483a8b0c688d96e258c5/?Expires=1496673578&AWSAccessKeyId=qh0h9TdcEMoS2oPj7aKX&Signature=O41ASlwQq9tVSbMh5ZKmboim2Kk%3D
     * videoId :
     * created : 1499391876
     * source_name : 今日头条
     * comm_nums : 0
     * biglike : 0
     * totalcount : 1212099
     * changed : 1499391876
     * uid : 10000662
     * authorImage :
     * authorName :
     * path : http://syd.drgrab.ca:1234/video-231499391876128
     * showtype : 4
     */

    private String _id;
    private String title;
    private String videourl;
    private String videoId;
    private String created;
    private String source_name;
    private String comm_nums;
    private String biglike;
    private String totalcount;
    private String changed;
    private String uid;
    private String authorImage;
    private String authorName;
    private String path;
    private String showtype;
    private List<String> photo;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getComm_nums() {
        return comm_nums;
    }

    public void setComm_nums(String comm_nums) {
        this.comm_nums = comm_nums;
    }

    public String getBiglike() {
        return biglike;
    }

    public void setBiglike(String biglike) {
        this.biglike = biglike;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getShowtype() {
        return showtype;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }
}
