package com.interfaces;

import java.util.List;

/**
 * Created by jermy on 16-11-24.
 */

public interface RowsBeanInterface {
    public String get_id();

    public String getTitle();

    public String getSource_name();

    public String getPosttime();

    public String getTotalcount();

    public String getComm_nums();

    public String getShowtype();

    public List<String> getPhoto();

    public String getAnnotation();

    public String getAnnotation_name();
}
