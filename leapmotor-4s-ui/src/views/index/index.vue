<template>
  <el-container>
    <el-header :height="115" class="logo-container">
      <el-image :src="avatar" class="logo-image"></el-image>
    </el-header>
    <div class="service-container">
      <div style="height: 20%"></div>
      <div class="inner-center">
        <el-input
            type="text"
            v-model="queryParams.licensePlate"
            clearable
            placeholder="请输入车牌号"
            style="width: 15%;"
            ></el-input>
        <el-button class="search-button" @click="dataSearch">查找</el-button>
      </div>
      <div style="height: 10%"></div>
      <div
          v-if="buttonVisible"
          class="inner-center"
          @close="closeButton">
        <el-button
            class="detail-info" @click="openDetail"><b>详细信息</b></el-button>
        <el-button
            class="detail-common"
            @click="openDialog"><b>查看车身状况</b></el-button>
        <el-button
            v-if="collapseButton"
            style="background: rgba(255, 255, 255, 0); margin: 0"
            @click="closeButton">收起{{collapse}}</el-button>
      </div>
      <el-dialog :visible.sync="dialogVisible"
                 title="车身状况"
                 @close="closeDialog">
        <el-tabs v-model="imageTab"
                 @tab-click="handleTabClick">
          <el-tab-pane label="左上角" name="carVisibleTab1">
            <el-image-viewer
                :zIndex='9999'
                v-if="viewerVisible"
                :on-switch="onSwitch"
                :on-close="closeViewer"
                :url-list="imageListTotal.upperLeft"
                :initial-index="currentIndex" />
            <el-row>
              <el-col :span="4" v-for="item in imageListWithIdTotal.upperLeft" :key="item.id" @click.native="chooseImage(item.id)">
                <el-card @click="chooseImage(item.id)" class="inner-center" style="width: 80px; height: 80px;">
                  <el-image :src="item.url" style="width: 50px; height: 50px"></el-image>
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="左下角" name="carVisibleTab2">
<!--              <el-image-viewer-->
<!--                  :zIndex='9999'-->
<!--                  v-if="viewerVisible"-->
<!--                  :on-switch="onSwitch"-->
<!--                  :on-close="closeViewer"-->
<!--                  :url-list="imageListTotal.lowerLeft"-->
<!--                  :initial-index="currentIndex" />-->
            <el-col :span="4" v-for="item in imageListWithIdTotal.lowerLeft" :key="item.id" @click.native="chooseImage(item.id)">
              <el-card @click="chooseImage(item.id)" class="inner-center" style="width: 80px; height: 80px;">
                <el-image :src="item.url" style="width: 50px; height: 50px"></el-image>
              </el-card>
            </el-col>
          </el-tab-pane>
          <el-tab-pane label="右上角" name="carVisibleTab3">
<!--              <el-image-viewer-->
<!--                      :zIndex='9999'-->
<!--                      v-if="viewerVisible"-->
<!--                      :on-switch="onSwitch"-->
<!--                      :on-close="closeViewer"-->
<!--                      :url-list="imageListTotal.upperRight"-->
<!--                      :initial-index="currentIndex" />-->
            <el-col :span="4" v-for="item in imageListWithIdTotal.upperRight" :key="item.id" @click.native="chooseImage(item.id)">
              <el-card @click="chooseImage(item.id)" class="inner-center" style="width: 80px; height: 80px;">
                <el-image :src="item.url" style="width: 50px; height: 50px"></el-image>
              </el-card>
            </el-col>
          </el-tab-pane>
          <el-tab-pane label="右下角" name="carVisibleTab4">
<!--              <el-image-viewer-->
<!--                      :zIndex='9999'-->
<!--                      v-if="viewerVisible"-->
<!--                      :on-switch="onSwitch"-->
<!--                      :on-close="closeViewer"-->
<!--                      :url-list="imageListTotal.lowerRight"-->
<!--                      :initial-index="currentIndex" />-->
            <el-col :span="4" v-for="item in imageListWithIdTotal.lowerRight" :key="item.id" @click.native="chooseImage(item.id)">
              <el-card @click="chooseImage(item.id)" class="inner-center" style="width: 80px; height: 80px;">
                <el-image :src="item.url" style="width: 50px; height: 50px"></el-image>
              </el-card>
            </el-col>
          </el-tab-pane>
          <el-tab-pane label="底盘前部" name="carVisibleTab5">
<!--              <el-image-viewer-->
<!--                      :zIndex='9999'-->
<!--                      v-if="viewerVisible"-->
<!--                      :on-switch="onSwitch"-->
<!--                      :on-close="closeViewer"-->
<!--                      :url-list="imageListTotal.chassisFront"-->
<!--                      :initial-index="currentIndex" />-->
            <el-col :span="4" v-for="item in imageListWithIdTotal.chassisFront" :key="item.id" @click.native="chooseImage(item.id)">
              <el-card @click="chooseImage(item.id)" class="inner-center" style="width: 80px; height: 80px;">
                <el-image :src="item.url" style="width: 50px; height: 50px"></el-image>
              </el-card>
            </el-col>
          </el-tab-pane>
          <el-tab-pane label="底盘后部" name="carVisibleTab6">
<!--              <el-image-viewer-->
<!--                      :zIndex='9999'-->
<!--                      v-if="viewerVisible"-->
<!--                      :on-switch="onSwitch"-->
<!--                      :on-close="closeViewer"-->
<!--                      :url-list="imageListTotal.chassisRear"-->
<!--                      :initial-index="currentIndex" />-->
            <el-col :span="4" v-for="item in imageListWithIdTotal.chassisRear" :key="item.id" @click.native="chooseImage(item.id)">
              <el-card @click="chooseImage(item.id)" class="inner-center" style="width: 80px; height: 80px;">
                <el-image :src="item.url" style="width: 50px; height: 50px"></el-image>
              </el-card>
            </el-col>
          </el-tab-pane>
        </el-tabs>
      </el-dialog>
      <div style="height: 10%"></div>
      <div v-if="detailCardVisible" class="detail-card">
        <el-card class="detail-card-inner">
          <div style="text-align: center; font-size: 18px;">详细信息</div>
          <div style="height: 10%">&nbsp</div>
          <el-row>
            <el-col :span="4" v-for="item in singleCarInfo"
                    :key="item.id"
                    class="detail-card-col">
              <b>{{item.field}} : {{item.value}}</b>
            </el-col>
          </el-row>
          <div style="padding-left: 15px;">
            <el-button
                style="font-size: 13px; background: rgba(255, 255, 255, 0.5);"
                @click="openRemarkDialog">查看备注</el-button>
          </div>
        </el-card>
      </div>
      <el-dialog :visible.sync="remarkVisible"
                 title="备注详情"
                 @close="closeRemarkDialog">{{singleCarInfo[singleCarInfo.length - 1].value}}</el-dialog>
    </div>
  </el-container>
</template>

<script>
import fa from "element-ui/src/locale/lang/fa";
import Minio from 'minio';
import {listCarImage} from "@/api/system/syscar/car"
import {returnMinioClient} from "@/api/system/minio";

export default {
  components: {
    'el-image-viewer': () => import('element-ui/packages/image/src/image-viewer')
  },
  mounted() {
    this.getMinioClient()
    console.log("getMinioClient")
  },
  data (){
    return{
      avatar: require('@/assets/images/index_logo.png'),
      queryParams:{
        licensePlate: undefined,
      },
      // 收起查看
      collapseButton: false,
      buttonVisible: false,
      // 对话框查看
      dialogVisible: false,
      // 关闭查看器
      viewerVisible: false,
      // 详细信息卡查看
      detailCardVisible: false,
      // 备注对话框查看
      remarkVisible: false,

      collapse: '∧',
      imageTab: 'carVisibleTab1',
      currentIndex: 1,

      carList:[],
      total: undefined,
      bucketName: 'carimage',
      minioClient: undefined,
      baseUrl: '172.22.33.209:9000/',

      // 测试字段
      singleCarInfo: [
          {field:'车牌号', value: undefined},
          {field: '保养号', value: undefined},
          {field: '经办人', value: undefined},
          {field: '最后保养时间', value: undefined},
      ],

      // 汽车图像各个方向url
        imageListWithIdTotal:{
            upperLeft: [],
            upperRight: [],
            lowerLeft: [],
            lowerRight: [],
            chassisFront: [],
            chassisRear: []
        },
       imageListWithId: [
       ],

      imageListTotal: {
          upperLeft: [],
          upperRight: [],
          lowerLeft: [],
          lowerRight: [],
          chassisFront: [],
          chassisRear: []
      }
    }
  },
  methods:{
    openDialog(){
      this.dialogVisible = true;
      console.log(this.dialogVisible)
    },
    closeButton(){
      // this.buttonVisible = false;
      this.detailCardVisible = false;
      this.collapseButton = false;
    },
    closeDialog(){
      this.dialogVisible = false;
    },
    handleTabClick(tab){
      console.log(`Tab ${tab.name} is clicked`);
    },
    closeViewer(){
      this.viewerVisible = false;
    },
    chooseImage(index){
      this.currentIndex = index;
      this.viewerVisible = true
      console.log("预览" + (index + 1) + "张图片")
    },
    onSwitch(index) {
      this.currentIndex = index
      // this.imageList = this.imageList.slice(index).concat(this.imageList.slice(0, index))
      console.log("切换到第" + (index + 1) + "张图片")
    },
    openDetail(){
      this.detailCardVisible = true;
      this.collapseButton = true;
    },
    closeRemarkDialog(){
      this.remarkVisible = false;
    },
    openRemarkDialog(){
      this.remarkVisible = true;
    },

    /** 后端交互方法 */

    /** 车牌号搜索 */
    // handleQuery(){
    //   this.getList();
    //   this.getSingleCarInfo();
    // },
    dataSearch(){
      this.getList();
    },
    getList() {
        this.$nextTick(()=>{
            listCarImage(this.queryParams).then(response => {
                this.carList = response.data;
                this.total = response.data.length;
                this.getSingleCarInfo();
                this.getMinioObject(this.carList);
                this.buttonVisible = true;
            });
        })

    },
    getSingleCarInfo(){
      console.log("carList[0]: " + this.carList[0])
      this.singleCarInfo[0].value = this.carList[0].licensePlate;
      this.singleCarInfo[1].value = this.carList[0].orderNumber;
      this.singleCarInfo[2].value = this.carList[0].agentName;
      this.singleCarInfo[3].value = this.carList[0].putTime;
    },
    getMinioClient(){
      this.minioClient = returnMinioClient();
    },
    getMinioObject(objectList) {
      let loopCount = {"upperLeft":0, "lowerLeft":0, "upperRight":0, "lowerRight":0, "chassisFront":0, "chassisRear":0};
      objectList.forEach(object => {
        this.minioClient.presignedGetObject(this.bucketName, object.filePath, 24 * 60 * 60, (err, url) => {
          if (err) {
            console.error('Error getting presigned URL:', err);
          } else {
            this.imageListWithIdTotal[object.direction].push({id: loopCount[object.direction], url: url});
            // this.imageListWithId.push({id: loopCount, url: url});
            this.imageListTotal[object.direction].push(url);
            loopCount[object.direction]++;
          }
        });
      })
        console.log(this.imageListWithIdTotal)
    }
  }
}
</script>

<style>

/*主体样式*/
.el-container{height: 100%;}

/*logo样式*/
.logo-container{
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 115px;
  width: 100%;
  margin: 0;
}
.logo-image{
  position: absolute;
  height: 100%;
  width: 13%;}

/*业务部分样式*/
.service-container{height: 50%; width: 100%}

/*flex布局居中*/
.inner-center{
  display: flex;
  justify-content: center;
  align-items: center;
}

.el-input__inner{
  border-radius: 10px;
}

/*查找按钮*/
.search-button{
  background-color: #a4adb3;
  color: white;
  margin-left: 12px;
  border-radius: 10px;
}

/*详细信息*/
.detail-common{
  width: 7.9%;
  background: rgba(255, 255, 255, 0.5);
  border-radius: 10px;
  margin: 0;
}

/*查看车身状况*/
.detail-info{
  width: 7.9%;
  margin-right: 30px;
  background: rgba(255, 255, 255, 0.5);
  border-radius: 10px;
}

.el-dialog{
  border-radius: 10px;
}

/*详细信息卡*/
.detail-card{
  height: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.detail-card-inner{
  width: 40%;
  height: 100%;
  background: rgba(128, 128, 128, 0.2);
}

.detail-card-col{
  width: 50%;
  padding-bottom: 15px;
  padding-left: 20px;
  font-size: 15px;
}
</style>