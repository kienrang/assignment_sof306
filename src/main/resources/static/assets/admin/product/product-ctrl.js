app.controller("product-ctrl", function($scope, $http){
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function () {
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate);
            })
        });
        $http.get("/rest/category").then(resp => {
            $scope.cates = resp.data;
        });
    }

    $scope.initialize();
    $scope.pager = {
        page:0,
        size:10,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start,start +this.size);
        },
        get count(){
            return Math.ceil(1.0*$scope.items.length/this.size);
        },
        first(){
            this.page =0;
        },
        prev(){
            this.page--;
            if (this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if (this.page>=this.count){
                this.first();
            }
        },
        last(){
            this.page=this.count-1;
        }
    }


    $scope.create = function(){
        var item = angular.copy($scope.form);
        console.log(item);
        $http.post(`/rest/products`,item).then(resp=>{
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Them moi thanh cong");
        }).catch(error=>{
            alert("loi them sp");
            console.log(error);
        });
    }
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`,item).then(resp=>{
            var index = $scope.items.findIndex(p=>p.id==item.id);
            $scope.items[index] = item;
            alert("Cap nhap thanh cong");
        }).catch(e=>{
            alert("cap nhap loi");
            console.log(e);
        })
    }
    $scope.delete = function(item){
        $http.delete(`/rest/products/${item.id}`).then(resp=>{
            var index = $scope.items.findIndex(p=>p.id==item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xoa thanh cong")
        }).catch(e=>{
            alert("loi xoa");
            console.log(e);
        })
    }
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            image: 'upload.jpg',
            available: 0
        }
    }
    $scope.edit = function(item){
        $scope.form= angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    $scope.imageChanged = function(files){
        var data =new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/images',data,{
            transformRequest:angular.identity,
            headers:{'Content-Type':undefined}
        }).then(resp=>{
            $scope.form.image = resp.data.name;
        }).catch(error=>{
            alert("Upload loi");
            console.log(error);
        })
    }


});