// pages/restaruant-list/restaruant-list.js
const app = getApp()
// pages/orders/orders.js
var base64 = require("../../static/images/base64");
var restaruants =  [{
  id: "1",
  name: "炸鸡汉堡",
  flavor: ['fast food'],
  address: 'A___B____C____',
  src: base64.icon60,
  thumbnail: '../../static/images/fastfood_mini.png'
},
{
  id: "2",
  name: "海底捞",
  flavor: ['hot pot', 'Chinese food'],
  address: 'A___B___C___',
  src:  base64.icon20,
  thumbnail: '../../static/images/dish_mini.png'
},
{
  id: "3",
  name: "Salad",
  flavor: ['sweet', 'fresh'],
  address: 'A_____B_____C_____',
  src:  base64.icon60,
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "4",
  name: "黄焖鸡米饭",
  flavor: ['Rice'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
},
{
  id: "5",
  name: "东北饺子馆",
  flavor: ['dumplings'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "6",
  name: "寿司拉面",
  flavor: ['Japanese food'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "7",
  name: "煲仔饭",
  flavor: ['Cantonese food'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "8",
  name: "螺蛳粉",
  flavor: ['Spicy', 'noodles'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
},
{
  id: "9",
  name: "真功夫",
  flavor: ['Steamed food'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
},
{
  id: "10",
  name: "五谷鱼粉",
  flavor: ['noodles'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "11",
  name: "永和大王",
  flavor: ['fast food', 'Rice', 'noodles'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
},
{
  id: "12",
  name: "炒饭",
  flavor: ['Rice'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "13",
  name: "凉皮",
  flavor: ['Snacks'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
},
{
  id: "14",
  name: "麻辣烫",
  flavor: ['Spicy', 'vegetables'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "15",
  name: "点都德",
  flavor: ['dianxin', 'Cantonese food'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "16",
  name: "酸菜鱼",
  flavor: ['Spicy', 'fish'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}, {
  id: "17",
  name: "必胜客",
  flavor: ['fast food', 'pizza'],
  address: 'A_____B_____C_____',
  src: '../../static/images/fruits_mini.png',
  thumbnail: '../../static/images/fruits_mini.png'
}];

Page({
  data: {
    currentRestaruants: restaruants.slice(0,3),
    selectedRestaruants:{},
    picked: false,
    multiIndex:[0,0],
    multiArray:[],
    objectMultiArray:[],
    fullTime :['11:00-11:30',"11:30-12:00","12:00-13:00","12:30-13:00","17:00-17:30","17:30-18:00", "18:00-18:30","18:30-19:00","21:00-21:30", "21:30-22:00","22:00-22:30"],
    chooseTime:false,
    loading:false,
    timeZone:[],
    currentTime:'',
    selectedTime:'',
    icon60:base64.icon60
  },
  refreshRestaruants: function () {
    var totalRestaruants = restaruants
    var results = []
    for (var i = 0; i < 3; i++) {
      var idx = parseInt(Math.random() * totalRestaruants.length)
      totalRestaruants[idx]['checked'] = false;      
      results.push(totalRestaruants[idx])
      totalRestaruants.splice(idx, 1)
    }
    this.setData({
      currentRestaruants: results
    })
    console.log(this.data.currentRestaruants)
  },
  chooseRestaruant: function(e){
    var res = this.data.currentRestaruants
    res.forEach(element => {
      element.checked = false;
    });
    res[e.currentTarget.dataset.index].checked = true
    this.setData({picked : true,currentRestaruants:res,selectedRestaruants:e.currentTarget.dataset.id})
  },
  postOrder: function(){
    var params = new Object()
    params.time = this.data.selectedTime
    params.rid = this.data.selectedRestaruants.id
    params.userId = ''
    if(this.data.picked){
      this.setData({loading:true})
      wx.showLoading({ title: '拼命加载中...' })
      var self = this
      setTimeout(function(){ 
        // self.setData({loading:false})
        wx.navigateTo({url: '../orders/orders'
      })},3000)
      // app.webService.POST({
      //   params:params,
      //   path:'',
      //   success:function(res){
      //     wx.navigateTo({
      //       url: '../orders/orders'
      //     })
      //   }
      // })

    }
  },
  bindTimeZonePickerChange: function (e) {
    this.setData({selectedTime:this.data.multiArray[0][e.detail.value[0]]+" "+this.data.multiArray[1][e.detail.value[1]],
    })
    console.log(this.data.selectedTime)
  },

  bindDatePickerChange: function (e){
    console.log('修改的列为', e.detail.column, '，值为', e.detail.value);
    var multiArray= this.data.multiArray
    var time_zone = this.data.fullTime.filter(time=>time.substring(0,5)>=this.data.currentTime)
    if(e.detail.column === 0){
      if(e.detail.value === 0){
        multiArray[1] = time_zone
      }else{
       multiArray[1] = this.data.fullTime
      }
    }
    this.setData({multiArray:multiArray})
  },
  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    this.data.currentRestaruants.forEach(e=>e['checked']=false)
  },

  /**
   * Lifecycle function--Called when page is initially rendered
   */
  onReady: function () {
    var date = new Date()
    var current_hour = date.getHours()>9 ? date.getHours():"0"+date.getHours()
    var current_minute = date.getMinutes() >9 ? date.getMinutes():"0"+date.getMinutes()
    var current_time = current_hour+":"+current_minute
    var show_time = this.data.fullTime.filter(e=>e.substring(0,5)>=current_time)
    var arr = []
    for(var i =0; i<show_time.length;i++){
      arr.push({id:i,name:show_time[i]})
    }
    var object_time =[[{id:0,name:'今天'},{id:0,name:'明天'}],arr]
    this.setData({multiArray:[["今天","明天"],show_time],objectMultiArray:object_time,currentTime:current_time,selectedTime:show_time[0]})
    console.log(this.data.multiArray);
  },

  /**
   * Lifecycle function--Called when page show
   */
  onShow: function () {

  },

  /**
   * Lifecycle function--Called when page hide
   */
  onHide: function () {

  },

  /**
   * Lifecycle function--Called when page unload
   */
  onUnload: function () {

  },

  /**
   * Page event handler function--Called when user drop down
   */
  onPullDownRefresh: function () {

  },

  /**
   * Called when page reach bottom
   */
  onReachBottom: function () {

  },

  /**
   * Called when user click on the top right corner to share
   */
  onShareAppMessage: function () {

  }
})