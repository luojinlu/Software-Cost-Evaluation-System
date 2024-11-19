package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Dashboard {
    @TableId
    private Integer id; // 配置ID
    private Integer tenantId; // 租户ID
    private Integer projectId; // 项目ID
    private String widgetType; // 数据看板类型
    private String widgetTitle; // 数据看板标题
    private String widgetDataSource; // 数据源
    private String chartType; // 图表类型
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt; // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt; // 更新时间

}