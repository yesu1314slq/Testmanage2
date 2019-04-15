package com.ideal.uam.service.report;

import com.ideal.uam.entity.Data_report;
import com.ideal.uam.mapper.report.DataReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataReportServiceImpl implements DataReportService{
    @Autowired
    private DataReportMapper dataReportMapper;

    //查询数据报表service层实现
    @Override
    public List<Map> getDataReportList(){
        List<Data_report> listDr=dataReportMapper.getDataReportList();
        List<Map> listDataReport=new ArrayList<Map>();
        for(Data_report dt:listDr){
            Map map=new HashMap();
            map.put("name",dt.getName());
            map.put("count",dt.getCount());
            listDataReport.add(map);
        }
        return listDataReport;
    }
}
