// pages/interests.js
const app = getApp()

function isContained(a, b){
  if(!(a instanceof Array) || !(b instanceof Array)) return false
  if(a.length < b.length) return false
  var aStr = a.toString()
  for(var i = 0, len = b.length; i < len; i++){
     if(aStr.indexOf(b[i]) == -1) return false
  }
  return true
}

Page({
  data: {
    textFields: /* app.globalData.userInfo.interests */[
      { flavorId: '1', name: '麻辣', active: true},
      { flavorId: '2', name: '咸鲜', active: false},
      { flavorId: '3', name: '酸辣', active: false},
      { flavorId: '4', name: '蒜香', active: true},
      { flavorId: '5', name: '甜酸', active: false},
      { flavorId: '6', name: '葱香', active: false},
      { flavorId: '7', name: '咖喱', active: false},
      { flavorId: '8', name: '咸甜', active: false},
      { flavorId: '9', name: '鱼香' , active: false},
      { flavorId: '10', name: '卤香' , active: false}
    ]
  },
  //事件处理函数
  toNextPage: function() {
    wx.navigateTo({
      url: '../orders/orders'
    })
  },
  setActive: function() {

  },
  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    var that = this
    wx.request({
        url: 'http://10.86.172.251:8080/luckyhit/api/userinfo/login',
        data: {
          nickName: app.globalData.userInfo.nickName
        },
        method: 'POST',
        header: {
          'content-type': 'application/json'
        },
        success: function (response) {
          app.globalData.userInfo.id = response.data.userInfo.id
          app.globalData.userInfo.flavorList = response.data.userInfo.flavorList
          var userFlavorLsit = app.globalData.userInfo.flavorList
          var flavorList = that.data.textFields
          for (var i=0; i<=flavorList.length; i++) {
            if (userFlavorLsit) {
              var aStr = userFlavorLsit.toString()
              if (aStr.indexOf(flavorList[i]) > -1) {
                flavorList[i].active = true
              }
            }
          }
          that.setData({
            textFields: flavorList
          })
        },
        fail: function (error) {
          alert('Error')
        }
      })
  },

  /**
   * Lifecycle function--Called when page is initially rendered
   */
  onReady: function () {

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