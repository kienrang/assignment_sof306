app.controller("acc-ctrl", function ($scope, $http) {
    $scope.listAcc = [];
    $scope.form = {};

    $scope.init = function () {
        $http.get("/rest/accounts").then(resp => {
            $scope.listAcc = resp.data;
            // console.log(resp.data)
        }).catch(err => {
            console.log(err)
        })
    }

    $scope.init();

    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/acounts`, item).then(resp => {
            $scope.listAcc.push(resp.data);
            $scope.reset();
            alert("Thêm mới thành công")
        }).catch(err => {
            alert("Thêm mới không thành công")
            console.log(err);
        })
    }

    $scope.reset = function () {
        $scope.form = {

        }
    }

    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        console.log($scope.form);
    }

    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
            var index = $scope.listAcc.findIndex(p => p.username == item.username);
            console.log(resp.data);
            $scope.items[index] = item;
            alert("Cập nhật thành công");
        }).catch(err => {
            alert("Cập nhật không thành công")
            console.log(err)
        })
    }

    $scope.delete = function (item) {
        $http.delete(`/rest/accounts/${item.username}`).then(resp => {
            var index = $scope.items.findIndex(p => p.username == item.username);
            $scope.listAcc.splice(index, 1);
            $scope.reset();
            alert("Xóa thành công")
        }).catch(e => {
            alert("Xóa không thành công");
            console.log(e);
        })
    }
})