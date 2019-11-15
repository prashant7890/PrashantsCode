package com.cloudamize.functional.cmp.entity;

public class PerformanceMetricsEntity {

    public PerformanceMetricsEntity(String metric_full_name, String metric_display_name){
        this.metric_full_name= metric_full_name;
        this.metric_display_name= metric_display_name;
    };

    private String metric_full_name;

    private String metric_display_name;

    public String getMetric_full_name() {
        return metric_full_name;
    }

    public void setMetric_full_name(String metric_full_name) {
        this.metric_full_name = metric_full_name;
    }

    public String getMetric_display_name() {
        return metric_display_name;
    }

    public void setMetric_display_name(String metric_display_name) {
        this.metric_display_name = metric_display_name;
    }


}
