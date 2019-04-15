package com.ideal.uam.service.report;

import com.ideal.uam.entity.Data_report;

import java.util.List;
import java.util.Map;

public interface DataReportService {

    //查询数据报表service层接口
    List<Map> getDataReportList();

}