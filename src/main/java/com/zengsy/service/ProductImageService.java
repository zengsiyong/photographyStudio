package com.zengsy.service;

import com.zengsy.pojo.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlc on 2017-11-16.
 */

public interface ProductImageService {
    // 创建的这两个常量分别表示单个图片和详情图片
    String type_single = "type_single";
    String type_detail = "type_detail";

    // 根据产品id和图片类型查询
    List list(int pid, String type);

    void add(ProductImage pi);
    void delete(int id);
    ProductImage get(int id);
    void update(ProductImage pi);

}
