<template>
  <el-row :gutter="20">
  
    <el-col :span="6">
      <div class="grid-content bg-purple">
          <span style="">作者10人</span>
      </div>
  </el-col>
  
    <el-col :span="6">
      <div class="grid-content bg-purple">
          <span style="">出版社15个</span>
      </div>
  </el-col>
  
    <el-col :span="6">
      <div class="grid-content bg-purple">
          <span style="">Django</span>
      </div>
  </el-col>
  
    <el-col :span="6">
      <div class="grid-content bg-purple">
          <span style="">评论20条</span>
      </div>
  </el-col>
  
  </el-row>
  
  
  <el-row :gutter="30">
      <el-table
      :data="tableData"
      stripe
      style="width: 97%;margin-left: 21px;">
      <el-table-column
        prop="date"
        label="..."
        width="200">
      </el-table-column>
      <el-table-column
        prop="name"
        label="..."
        width="280">
      </el-table-column>
      <el-table-column
        prop="address"
        label="...">
  
      </el-table-column>
    </el-table>
  </el-row>
  
  <el-row :gutter="20">
    <div class="block">
      <el-image :src="src" style="margin-left: 10px;"></el-image>
    </div>
  </el-row>
  
  
  <!-- <div  style="display: flex;">
    分类柱状图：
    <div  ref="barChart" style="width: 400px; height: 400px;flex: 1;"></div>
    地区饼图：
    <div ref="pieChart" style="width: 400px; height: 400px;flex: 1;"></div>
  </div> -->
  
  </template>
  
  <!-- <script setup>
  import { onMounted, ref } from 'vue';
  import * as echarts from 'echarts';
   
  const pieChart = ref(null);
  const barChart = ref(null);
   
  onMounted(() => {
    const pieOption = {
      series: [
        {
          name: '地区',
          type: 'pie',
          radius: '80%',
          data: [
            { value: 235, name: '北京' },
            { value: 274, name: '上海' },
            { value: 310, name: '西安' },
            { value: 335, name: '邯郸' },
          ],
        },
      ],
    };
   
    const barOption = {
      xAxis: {
        type: 'category',
        data: ['一居室', '二居室', '三居室', '四居室'],
      },
      yAxis: {
        type: 'value',
      },
      series: [
        {
          data: [120, 200, 150, 80],
          type: 'bar',
        },
      ],
    };
   
    const pieChartInstance = echarts.init(pieChart.value);
    const barChartInstance = echarts.init(barChart.value);
    pieChartInstance.setOption(pieOption);
    barChartInstance.setOption(barOption);
  });
  </script> -->
  
  <script >
  
    export default {
      data() {
        return {
          tableData: [{
            date: '系统名称',
            name: '图书管理系统',
            address: '......'
          }, {
            date: '系统技术',
            name: 'Python+Django+Vue+Mysql',
            address: '......'
          }, {
            date: '开发环境',
            name: 'Vscode+Pycharm',
            address: '......'
          }, {
            date: '开发时间',
            name: 'one month',
            address: '......'
          }],
          // src: 'https://pic.imgdb.cn/item/65d6fbb99f345e8d037879c3.png'
        }
      },
    }
  </script>
  
  <style  scoped>
      span {
          color: white;
          font-weight: 1000;
          font-size: 26px;
  
      }
    .el-row {
      margin-bottom: 20px;
      &:last-child {
        margin-bottom: 0;
      }
    }
    .el-col {
      border-radius: 10px;
      text-align: center;
      line-height:120px;
  
  
    }
    .bg-purple-dark {
      background: #99a9bf;
    }
    .bg-purple {
      background: #d3dce6;
    }
    .bg-purple-light {
      background: #e5e9f2;
    }
    .grid-content {
      border-radius: 4px;
      min-height: 150px;
    }
    .row-bg {
      padding: 10px 0;
      background-color: #f9fafc;
    }
  </style>