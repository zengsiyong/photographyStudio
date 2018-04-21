package com.zengsy.service.impl;


import com.zengsy.mapper.PropertyValueMapper;
import com.zengsy.pojo.Product;
import com.zengsy.pojo.Property;
import com.zengsy.pojo.PropertyValue;
import com.zengsy.pojo.PropertyValueExample;
import com.zengsy.service.PropertyService;
import com.zengsy.service.PropertyValueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.ProblemReporter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xlc on 2017-12-03.
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    PropertyValueMapper propertyValueMapper;

    @Autowired
    PropertyService propertyService;

    private final static Logger log = Logger.getLogger("PhotographyStudio_log");

    // 这个方法的作用是初始化PropertyValue。 因为对于PropertyValue的管理，没有增加，只有修改
    @Override
    public void init(Product p) {
        // 根据商品id获取该商品所有的对应的所有属性
        List<Property> pts = propertyService.list(p.getCid());
        log.info("根据商品id获取该商品所有的对应的所有属性List<Property> pts" + pts);
        // 再根据属性ptid和产品pid去查询并插入初始数据
        for (Property pt : pts) {
            PropertyValue pv = get(pt.getId(), p.getId());
            if (null == pv) {
                pv = new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
                log.info("当前判断出propertyValue表中不存在属性，执行插入语句，插入当前产品id和分类对应的属性id");
            }
        }
    }

    @Override
    public void update(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }

    // 根据属性id和产品id获取PropertyValue对象
    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
        log.info("查看当前根据pid和ptid查PropertyValue是否存在记录" + pvs);
        if (pvs.isEmpty()) {
            return null;
        }
        log.info("查看当前根据pid和ptid查PropertyValue是否存在记录pvs.get(0)" + pvs.get(0));
        return pvs.get(0);
    }
    // 根据产品id获取所有的属性值
    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv :result) {
            Property property = propertyService.get(pv.getPtid());
            pv.setProperty(property);

        }
        return result;
    }
}
