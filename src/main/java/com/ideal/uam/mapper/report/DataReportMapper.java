package com.ideal.uam.mapper.report;

import com.ideal.uam.entity.Data_report;

import java.util.List;


public interface DataReportMapper {

    //查询数据报表Dao层接口
    List<Data_report> getDataReportList();
}