// pages/orders/orders.js
const app = getApp()
var base64 = require("../../static/images/base64")

Page({

  /**
   * Page initial data
   */
  data: {
    orderCondition: false
  },
  
  refreshMatching: function() {
    wx.navigateTo({url:"../restaruant-list/restaruant-list"})
  },
  confirmMatching: function() {

  },

  /**
   * Lifecycle function--Called when page load
   */
  onLoad: function (options) {
    this.setData({
      icon20: base64.icon20,
      icon60: base64.icon60,
      food60: '../../static/images/restaurants/res.jpg',
      currentUserInfo: app.globalData.userInfo,
      matchedUserInfo: {
        avatarUrl: base64.icon60
      }
    });
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