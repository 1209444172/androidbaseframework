package com.model;

import com.interfaces.RowsBeanInterface;
import com.interfaces._IdInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





public class HomePageListRowsBean implements Serializable, RowsBeanInterface, _IdInterface {

    @Override
    public String get_iid() {
        return get_id();
    }

    @Override
    public String get_iChanged() {
        return getPosttime();
    }

    /**
     * _id : 1507796
     * title : 澳洲政府拟修订企业竞争法 四大银行首当其冲
     * classify : ["2014","2008","2097","5059","1488942108"]
     * source_name : 今日澳洲
     * totalcount : 311
     * annotation : 1491791551
     * posttime : 1473057000
     * photo : ["https://cdn36.jinriaozhou.com/2016-09-05/3b1c-1473057340.jpg"]
     * comm_nums : 5
     * topic : 6426
     * annotation_name : 专题
     * showtype : 0
     */

    private String _id;
    private String title;
    private String source_name="";
    private String totalcount;
    private String annotation = "";
    private String posttime;
    private String comm_nums;
    private String topic;
    private String annotation_name;
    private String description;
    private String showtype = "0";
    private List<String> classify;
    private List<String> photo;

    private String biglike = "";
    private String width = "";
    private String height = "";
    private boolean isLike = true;
    private String path = "";
    private String pos = "";
    private String iskeep  = "";

    //短视频
    private String video_id = "";
    private String videourl = "";
    private String video_type = "";

    private List<String> authorImage;
    private String distance = "";
    private String vitem = "";
    private String author = "";
    private String device = "";
    private String address = "";
    private String created = "";
    private String anonymousPhoto = "";
    private String url;
    private String is_user = "";
    private String ishide = "";
    private String keep_nums = "";

    private List<CommentBean> comment_sms = new ArrayList<>();
    private List<VideoBean> rows = new ArrayList<>();


    public String getKeep_nums() {
        return keep_nums;
    }

    public void setKeep_nums(String keep_nums) {
        this.keep_nums = keep_nums;
    }

    public String getIskeep() {
        return iskeep;
    }

    public void setIskeep(String iskeep) {
        this.iskeep = iskeep;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getBiglike() {
        return biglike;
    }

    public void setBiglike(String biglike) {
        this.biglike = biglike;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getChanged() {
        return getPosttime();
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }

    public void setComm_nums(String comm_nums) {
        this.comm_nums = comm_nums;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAnnotation_name(String annotation_name) {
        this.annotation_name = annotation_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    public void setClassify(List<String> classify) {
        this.classify = classify;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSource_name() {
        return source_name;
    }

    public String getTotalcount() {
        return totalcount;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getPosttime() {
        return posttime;
    }

    public String getComm_nums() {
        return comm_nums;
    }

    public String getTopic() {
        return topic;
    }

    public String getAnnotation_name() {
        return annotation_name;
    }

    public String getDescription() {
        return description;
    }

    public String getShowtype() {
        return showtype;
    }

    public List<String> getClassify() {
        return classify;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<String> getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(List<String> authorImage) {
        this.authorImage = authorImage;
    }

    public String getVitem() {
        return vitem;
    }

    public void setVitem(String vitem) {
        this.vitem = vitem;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;

    }


    public List<CommentBean> getComment_sms() {
        return comment_sms;
    }

    public void setComment_sms(List<CommentBean> comment_sms) {
        this.comment_sms = comment_sms;
    }

    public String getAnonymousPhoto() {
        return anonymousPhoto;
    }

    public void setAnonymousPhoto(String anonymousPhoto) {
        this.anonymousPhoto = anonymousPhoto;
    }

    public void setRows(List<VideoBean> rows) {
        this.rows = rows;
    }

    public List<VideoBean> getRows() {
        return rows;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIs_user() {
        return is_user;
    }

    public void setIs_user(String is_user) {
        this.is_user = is_user;
    }

    public String getIshide() {
        return ishide;
    }

    public void setIshide(String ishide) {
        this.ishide = ishide;
    }
}
