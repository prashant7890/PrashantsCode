package com.cloudamize.functional.cmp.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PerformanceControllerBean {

    @SerializedName("average.aws_metric_cpu_utilization")
    @Expose
    private String averageAwsMetricCpuUtilization;
    @SerializedName("average.aws_metric_disk_read_bytes")
    @Expose
    private String averageAwsMetricDiskReadBytes;
    @SerializedName("average.aws_metric_disk_read_ops")
    @Expose
    private String averageAwsMetricDiskReadOps;
    @SerializedName("aws_metric_vm_total_bandwidth_to_all_volumes")
    @Expose
    private String awsMetricVmTotalBandwidthToAllVolumes;
    @SerializedName("average.aws_metric_disk_write_ops")
    @Expose
    private String averageAwsMetricDiskWriteOps;
    @SerializedName("passmark.aws_metric_cpu_utilization")
    @Expose
    private String passmarkAwsMetricCpuUtilization;
    @SerializedName("specfp2017.aws_metric_cpu_utilization")
    @Expose
    private String specfp2017AwsMetricCpuUtilization;
    @SerializedName("average.aws_metric_vm_disk_total_iops")
    @Expose
    private String averageAwsMetricVmDiskTotalIops;
    @SerializedName("average.aws_metric_vm_disk_total_bandwidth")
    @Expose
    private String averageAwsMetricVmDiskTotalBandwidth;
    @SerializedName("average.aws_metric_network_out")
    @Expose
    private String averageAwsMetricNetworkOut;
    @SerializedName("average.aws_metric_network_in")
    @Expose
    private String averageAwsMetricNetworkIn;
    @SerializedName("specint2017.aws_metric_cpu_utilization")
    @Expose
    private String specint2017AwsMetricCpuUtilization;
    @SerializedName("average.aws_metric_vm_network_total_bandwidth")
    @Expose
    private String averageAwsMetricVmNetworkTotalBandwidth;
    @SerializedName("average.aws_metric_disk_write_bytes")
    @Expose
    private String averageAwsMetricDiskWriteBytes;
    @SerializedName("aws_metric_vm_total_iops_to_all_volumes")
    @Expose
    private String awsMetricVmTotalIopsToAllVolumes;

    public String getAverageAwsMetricCpuUtilization() {
        return averageAwsMetricCpuUtilization;
    }

    public void setAverageAwsMetricCpuUtilization(String averageAwsMetricCpuUtilization) {
        this.averageAwsMetricCpuUtilization = averageAwsMetricCpuUtilization;
    }

    public String getAverageAwsMetricDiskReadBytes() {
        return averageAwsMetricDiskReadBytes;
    }

    public void setAverageAwsMetricDiskReadBytes(String averageAwsMetricDiskReadBytes) {
        this.averageAwsMetricDiskReadBytes = averageAwsMetricDiskReadBytes;
    }

    public String getAverageAwsMetricDiskReadOps() {
        return averageAwsMetricDiskReadOps;
    }

    public void setAverageAwsMetricDiskReadOps(String averageAwsMetricDiskReadOps) {
        this.averageAwsMetricDiskReadOps = averageAwsMetricDiskReadOps;
    }

    public String getAwsMetricVmTotalBandwidthToAllVolumes() {
        return awsMetricVmTotalBandwidthToAllVolumes;
    }

    public void setAwsMetricVmTotalBandwidthToAllVolumes(String awsMetricVmTotalBandwidthToAllVolumes) {
        this.awsMetricVmTotalBandwidthToAllVolumes = awsMetricVmTotalBandwidthToAllVolumes;
    }

    public String getAverageAwsMetricDiskWriteOps() {
        return averageAwsMetricDiskWriteOps;
    }

    public void setAverageAwsMetricDiskWriteOps(String averageAwsMetricDiskWriteOps) {
        this.averageAwsMetricDiskWriteOps = averageAwsMetricDiskWriteOps;
    }

    public String getPassmarkAwsMetricCpuUtilization() {
        return passmarkAwsMetricCpuUtilization;
    }

    public void setPassmarkAwsMetricCpuUtilization(String passmarkAwsMetricCpuUtilization) {
        this.passmarkAwsMetricCpuUtilization = passmarkAwsMetricCpuUtilization;
    }

    public String getSpecfp2017AwsMetricCpuUtilization() {
        return specfp2017AwsMetricCpuUtilization;
    }

    public void setSpecfp2017AwsMetricCpuUtilization(String specfp2017AwsMetricCpuUtilization) {
        this.specfp2017AwsMetricCpuUtilization = specfp2017AwsMetricCpuUtilization;
    }

    public String getAverageAwsMetricVmDiskTotalIops() {
        return averageAwsMetricVmDiskTotalIops;
    }

    public void setAverageAwsMetricVmDiskTotalIops(String averageAwsMetricVmDiskTotalIops) {
        this.averageAwsMetricVmDiskTotalIops = averageAwsMetricVmDiskTotalIops;
    }

    public String getAverageAwsMetricVmDiskTotalBandwidth() {
        return averageAwsMetricVmDiskTotalBandwidth;
    }

    public void setAverageAwsMetricVmDiskTotalBandwidth(String averageAwsMetricVmDiskTotalBandwidth) {
        this.averageAwsMetricVmDiskTotalBandwidth = averageAwsMetricVmDiskTotalBandwidth;
    }

    public String getAverageAwsMetricNetworkOut() {
        return averageAwsMetricNetworkOut;
    }

    public void setAverageAwsMetricNetworkOut(String averageAwsMetricNetworkOut) {
        this.averageAwsMetricNetworkOut = averageAwsMetricNetworkOut;
    }

    public String getAverageAwsMetricNetworkIn() {
        return averageAwsMetricNetworkIn;
    }

    public void setAverageAwsMetricNetworkIn(String averageAwsMetricNetworkIn) {
        this.averageAwsMetricNetworkIn = averageAwsMetricNetworkIn;
    }

    public String getSpecint2017AwsMetricCpuUtilization() {
        return specint2017AwsMetricCpuUtilization;
    }

    public void setSpecint2017AwsMetricCpuUtilization(String specint2017AwsMetricCpuUtilization) {
        this.specint2017AwsMetricCpuUtilization = specint2017AwsMetricCpuUtilization;
    }

    public String getAverageAwsMetricVmNetworkTotalBandwidth() {
        return averageAwsMetricVmNetworkTotalBandwidth;
    }

    public void setAverageAwsMetricVmNetworkTotalBandwidth(String averageAwsMetricVmNetworkTotalBandwidth) {
        this.averageAwsMetricVmNetworkTotalBandwidth = averageAwsMetricVmNetworkTotalBandwidth;
    }

    public String getAverageAwsMetricDiskWriteBytes() {
        return averageAwsMetricDiskWriteBytes;
    }

    public void setAverageAwsMetricDiskWriteBytes(String averageAwsMetricDiskWriteBytes) {
        this.averageAwsMetricDiskWriteBytes = averageAwsMetricDiskWriteBytes;
    }

    public String getAwsMetricVmTotalIopsToAllVolumes() {
        return awsMetricVmTotalIopsToAllVolumes;
    }

    public void setAwsMetricVmTotalIopsToAllVolumes(String awsMetricVmTotalIopsToAllVolumes) {
        this.awsMetricVmTotalIopsToAllVolumes = awsMetricVmTotalIopsToAllVolumes;
    }

}