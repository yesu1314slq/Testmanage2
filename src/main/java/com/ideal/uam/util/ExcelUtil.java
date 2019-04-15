package com.ideal.uam.util;

import jxl.Workbook;
import jxl.format.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

public class ExcelUtil {

    /**
     *
     * @param fileName    文件名
     * @param Title       标题
     * @param listContent 内容
     * @param width       列宽
     * @param total       行数
     * @param response
     * @return
     */
    public final static String ExportExcel(String fileName, String[] Title, List<Object> listContent,
                                           int[] width,Integer total,HttpServletResponse response) {
        String result = "系统提示：Excel文件导出成功！";
        // 以下开始输出到EXCEL
        try {
            // 定义输出流，以便打开保存对话框______________________begin
            // HttpServletResponse response=ServletActionContext.getResponse();
            OutputStream os = response.getOutputStream();// 取得输出流
            response.reset();// 清空输出流
            response.setHeader("Content-disposition",
                    "attachment; filename=" + toUtf8String(fileName));

            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            // 定义输出流，以便打开保存对话框_______________________end

            /** **********创建工作簿************ */
            WritableWorkbook workbook = Workbook.createWorkbook(os);

            /** **********创建工作表************ */

            WritableSheet sheet = workbook.createSheet(fileName, 0);

            //wanglu add begin
            //循环设置列宽
            for(int i=0;i<width.length;i++){
                sheet.setColumnView(i, width[i]);
            }
            //设置列的默认行高（所有单元格）
            sheet.getSettings().setDefaultRowHeight(500);
            //循环设置行高
            for(int i=0;i<=total;i++){
                if(i==0)sheet.setRowView(i, 700);
                if(i!=0)sheet.setRowView(i, 500);
            }

            //高度设定  第一行 高度700
            //sheet.setRowView(0, 500);
            //设置所有列宽度
            //sheet.getSettings().setDefaultColumnWidth(19);
            //wanglu add end

            /** **********设置纵横打印（默认为纵打）、打印纸***************** */
            jxl.SheetSettings sheetset = sheet.getSettings();
            sheetset.setProtected(false);

            /** ************设置单元格字体************** */
            WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
            WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

            /** ************以下设置三种单元格样式，灵活备用************ */
            // 用于标题居中
            WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
            wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
            wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
            wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
            wcf_center.setWrap(false); // 文字是否换行
            wcf_center.setBackground(Colour.YELLOW);//设置背景色

            // 用于正文居左
            WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
            wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
            wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
            wcf_left.setAlignment(Alignment.CENTRE); // 文字水平对齐
            wcf_left.setWrap(true); // 文字是否换行

            /** ***************以下是EXCEL开头大标题，暂时省略********************* */
            // sheet.mergeCells(0, 0, colWidth, 0);
            // sheet.addCell(new Label(0, 0, "XX报表", wcf_center));
            /** ***************以下是EXCEL第一行列标题********************* */
            for (int i = 0; i < Title.length; i++) {
                sheet.addCell(new Label(i, 0, Title[i], wcf_center));
            }
            /** ***************以下是EXCEL正文数据********************* */
            Field[] fields = null;
            int i = 1;
            for (Object obj : listContent) {
                fields = obj.getClass().getDeclaredFields();
                int j = 0;
                for (Field v : fields) {
                    v.setAccessible(true);
                    Object va = v.get(obj);
                    if (va == null) {
                        va = "";
                    }
                    sheet.addCell(new Label(j, i, va.toString(), wcf_left));
                    j++;
                }
                i++;
            }
            /** **********将以上缓存中的内容写到EXCEL文件中******** */
            workbook.write();
            /** *********关闭文件************* */
            workbook.close();

        } catch (Exception e) {
            result = "系统提示：Excel文件导出失败，原因：" + e.toString();
            System.out.println(result);
            e.printStackTrace();
        }
        return result;
    }

    public static String toUtf8String(String s){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c >= 0 && c <= 255){sb.append(c);}
            else{
                byte[] b;
                try { b = Character.toString(c).getBytes("utf-8");}
                catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
}
