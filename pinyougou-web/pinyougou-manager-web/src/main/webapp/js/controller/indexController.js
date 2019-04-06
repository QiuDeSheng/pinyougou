//定义首页控制器
app.controller('indexController',function ($scope,baseService) {
    //获取用户名
    $scope.showLoginName = function () {
        baseService.sendGet("/showLoginName").then(function (response) {
            // 获取用户名
            $scope.loginName = response.data.loginName;
        });
    };
    
});