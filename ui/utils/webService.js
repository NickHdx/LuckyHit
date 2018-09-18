var API_URL = 'http://localhost:8080/luckyhit/api/'
 
var requestHandler = {
  params:{},
  path:{},
  success: function(res){
    // success
  },
  fail: function() {
    // fail
  },
}
 
function GET(requestHandler) {
  request('GET',requestHandler)
}

function POST(requestHandler) {
  request('POST',requestHandler)
}
 
function request(method,requestHandler) {
  var params = requestHandler.params;
  var path = requestHandler.path;
  wx.request({
   url: API_URL+path,
   data: params,
   method: method,
   success: function(res){
    requestHandler.success(res)
   },
   fail: function() {
    requestHandler.fail()
   },
   complete: function() {
    // complete
   }
  })
}
 
module.exports = {
 GET: GET,
 POST: POST
}
